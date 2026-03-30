package com.mlens.app.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.mlens.app.data.database.ImageWithTags
import com.mlens.app.data.repository.ImageRepository
import com.mlens.app.utils.DatabaseExporter
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import android.content.Context
import android.util.Log

class MainViewModel(
    private val repository: ImageRepository,
    private val context: Context
) : ViewModel() {
    
    private val databaseExporter = DatabaseExporter(context)
    
    private val _uiState = MutableStateFlow(MainUiState())
    val uiState: StateFlow<MainUiState> = _uiState.asStateFlow()
    
    private val _searchQuery = MutableStateFlow("")
    private val _filterType = MutableStateFlow(FilterType.ALL)
    
    init {
        loadImages()
        observeSearchAndFilter()
    }
    
    private fun loadImages() {
        viewModelScope.launch {
            try {
                // Load initial statistics
                val totalCount = repository.getImageCount()
                val textCount = repository.getTextImageCount()
                val visualCount = repository.getVisualImageCount()
                
                _uiState.update { currentState ->
                    currentState.copy(
                        totalImages = totalCount,
                        textImages = textCount,
                        visualImages = visualCount,
                        isLoading = false
                    )
                }
            } catch (e: Exception) {
                _uiState.update { currentState ->
                    currentState.copy(
                        error = e.message,
                        isLoading = false
                    )
                }
            }
        }
    }
    
    private fun observeSearchAndFilter() {
        combine(
            _searchQuery,
            _filterType
        ) { query, filterType ->
            Pair(query, filterType)
        }.distinctUntilChanged()
            .onEach { (query, filterType) ->
                loadFilteredImages(query, filterType)
            }.launchIn(viewModelScope)
    }
    
    private fun loadFilteredImages(query: String, filterType: FilterType) {
        viewModelScope.launch {
            try {
                _uiState.update { it.copy(isLoading = true) }
                
                val imagesFlow = when {
                    query.isNotEmpty() && filterType != FilterType.ALL -> {
                        repository.searchImagesByType(query, filterType == FilterType.TEXT)
                    }
                    query.isNotEmpty() -> {
                        repository.searchImages(query)
                    }
                    filterType != FilterType.ALL -> {
                        repository.getImagesByType(filterType == FilterType.TEXT)
                    }
                    else -> {
                        repository.getAllImages()
                    }
                }
                
                imagesFlow.collect { images ->
                    _uiState.update { currentState ->
                        currentState.copy(
                            images = images,
                            isLoading = false,
                            error = null
                        )
                    }
                }
            } catch (e: Exception) {
                _uiState.update { currentState ->
                    currentState.copy(
                        error = e.message,
                        isLoading = false
                    )
                }
            }
        }
    }
    
    fun updateSearchQuery(query: String) {
        _searchQuery.value = query
    }
    
    fun updateFilter(filterType: FilterType) {
        _filterType.value = filterType
    }
    
    fun deleteImage(imageId: Long) {
        viewModelScope.launch {
            try {
                repository.deleteImage(imageId)
                // Refresh data after deletion
                loadImages()
            } catch (e: Exception) {
                _uiState.update { currentState ->
                    currentState.copy(error = "Failed to delete image: ${e.message}")
                }
            }
        }
    }
    
    fun clearError() {
        _uiState.update { it.copy(error = null) }
    }
    
    fun refreshData() {
        loadImages()
        loadFilteredImages(_searchQuery.value, _filterType.value)
    }
    
    fun exportDatabase(password: String = "mlens2024", onExportReady: (String) -> Unit) {
        viewModelScope.launch {
            try {
                _uiState.update { it.copy(isExporting = true, error = null) }
                
                val result = databaseExporter.exportDatabaseForSharing(password)
                
                if (result.success && result.filePath != null) {
                    _uiState.update { 
                        it.copy(
                            isExporting = false, 
                            exportSuccess = "Database export ready for sharing"
                        ) 
                    }
                    onExportReady(result.filePath)
                    Log.d("MainViewModel", "Export successful: ${result.filePath}")
                } else {
                    _uiState.update { 
                        it.copy(
                            isExporting = false, 
                            error = "Export failed: ${result.error}"
                        ) 
                    }
                }
            } catch (e: Exception) {
                _uiState.update { 
                    it.copy(
                        isExporting = false, 
                        error = "Export failed: ${e.message}"
                    ) 
                }
                Log.e("MainViewModel", "Export failed", e)
            }
        }
    }
    
    fun importDatabaseFromUri(zipFileUri: android.net.Uri, password: String = "mlens2024", onImportSuccess: () -> Unit) {
        viewModelScope.launch {
            try {
                _uiState.update { it.copy(isImporting = true, error = null) }
                
                val result = databaseExporter.importDatabaseFromUri(zipFileUri, password)
                
                if (result.success) {
                    _uiState.update { 
                        it.copy(
                            isImporting = false, 
                            importSuccess = "Database imported successfully! ${result.importedImages} images restored. App will exit in 5 seconds..."
                        ) 
                    }
                    Log.d("MainViewModel", "Import successful: ${result.importedImages} images")
                    
                    // Wait 5 seconds to show success message, then exit app completely
                    kotlinx.coroutines.delay(5000)
                    onImportSuccess()
                } else {
                    _uiState.update { 
                        it.copy(
                            isImporting = false, 
                            error = "Import failed: ${result.error}"
                        ) 
                    }
                }
            } catch (e: Exception) {
                _uiState.update { 
                    it.copy(
                        isImporting = false, 
                        error = "Import failed: ${e.message}"
                    ) 
                }
                Log.e("MainViewModel", "Import failed", e)
            }
        }
    }
    
    fun clearMessages() {
        _uiState.update { 
            it.copy(
                exportSuccess = null, 
                importSuccess = null, 
                error = null
            ) 
        }
    }
    
    data class MainUiState(
        val images: List<ImageWithTags> = emptyList(),
        val totalImages: Int = 0,
        val textImages: Int = 0,
        val visualImages: Int = 0,
        val isLoading: Boolean = true,
        val error: String? = null,
        val isExporting: Boolean = false,
        val isImporting: Boolean = false,
        val exportSuccess: String? = null,
        val importSuccess: String? = null
    )
    
    enum class FilterType {
        ALL, TEXT, VISUAL
    }
}

class MainViewModelFactory(
    private val repository: ImageRepository,
    private val context: Context
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(repository, context) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}