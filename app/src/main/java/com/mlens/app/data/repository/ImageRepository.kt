package com.mlens.app.data.repository

import android.net.Uri
import com.mlens.app.data.database.ImageDao
import com.mlens.app.data.database.ImageEntity
import com.mlens.app.data.database.ImageWithTags
import com.mlens.app.ml.MLProcessor
import kotlinx.serialization.json.Json
import kotlinx.serialization.encodeToString
import kotlinx.serialization.decodeFromString
import com.mlens.app.utils.ImageUtils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

class ImageRepository(
    private val imageDao: ImageDao,
    private val mlProcessor: MLProcessor
) {
    private val json = Json { ignoreUnknownKeys = true }
    private val tempDataMap = mutableMapOf<Long, ProcessedImageData>()
    
    fun saveTempProcessedData(tempId: Long, data: ProcessedImageData) {
        tempDataMap[tempId] = data
    }
    
    fun getTempProcessedData(tempId: Long): ProcessedImageData? {
        return tempDataMap[tempId] // Don't remove immediately
    }
    
    fun removeTempProcessedData(tempId: Long) {
        tempDataMap.remove(tempId) // Remove when done
    }
    
    suspend fun updateExistingImage(
        imageId: Long,
        isTextBased: Boolean,
        extractedText: String?,
        summary: String?,
        tags: List<String>
    ): Result<Unit> = withContext(Dispatchers.IO) {
        try {
            val existingImage = imageDao.getImageById(imageId)
            if (existingImage != null) {
                val updatedImage = existingImage.copy(
                    isTextBased = isTextBased,
                    extractedText = extractedText,
                    summary = summary,
                    tags = if (tags.isNotEmpty()) json.encodeToString(tags) else null,
                    searchKeywords = generateSearchKeywords(
                        MLProcessor.MLResult(
                            isTextBased = isTextBased,
                            extractedText = extractedText,
                            summary = summary,
                            tags = tags,
                            confidence = existingImage.confidenceScore ?: 0.9f
                        )
                    ),
                    updatedAt = System.currentTimeMillis()
                )
                imageDao.updateImage(updatedImage)
                Result.success(Unit)
            } else {
                Result.failure(Exception("Image not found"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
    
    // Get all images with tags as list
    fun getAllImages(): Flow<List<ImageWithTags>> {
        return imageDao.getAllImages().map { entities ->
            entities.map { entity -> entity.toImageWithTags() }
        }
    }
    
    // Get images by type (text or visual)
    fun getImagesByType(isTextBased: Boolean): Flow<List<ImageWithTags>> {
        return imageDao.getImagesByType(isTextBased).map { entities ->
            entities.map { entity -> entity.toImageWithTags() }
        }
    }
    
    // Search images
    fun searchImages(query: String): Flow<List<ImageWithTags>> {
        return imageDao.searchImages(query).map { entities ->
            entities.map { entity -> entity.toImageWithTags() }
        }
    }
    
    // Search images by type
    fun searchImagesByType(query: String, isTextBased: Boolean): Flow<List<ImageWithTags>> {
        return imageDao.searchImagesByType(query, isTextBased).map { entities ->
            entities.map { entity -> entity.toImageWithTags() }
        }
    }
    
    // Get single image by ID
    suspend fun getImageById(id: Long): ImageWithTags? {
        return withContext(Dispatchers.IO) {
            imageDao.getImageById(id)?.toImageWithTags()
        }
    }
    
    // Get image counts
    suspend fun getImageCount(): Int = imageDao.getImageCount()
    suspend fun getTextImageCount(): Int = imageDao.getImageCountByType(true)
    suspend fun getVisualImageCount(): Int = imageDao.getImageCountByType(false)
    
    // Process and save image
    data class ProcessedImageData(
        val imagePath: String,
        val isTextBased: Boolean,
        val extractedText: String?,
        val summary: String?,
        val tags: List<String>
    )
    
    suspend fun processImageForEditing(imageUri: Uri, context: android.content.Context): Result<ProcessedImageData> {
        return withContext(Dispatchers.IO) {
            try {
                // Load bitmap from URI
                val bitmap = ImageUtils.loadBitmapFromUri(context, imageUri)
                    ?: return@withContext Result.failure(Exception("Failed to load image"))
                
                // Save image to app storage
                val savedImagePath = ImageUtils.saveBitmapToInternalStorage(context, bitmap)
                    ?: return@withContext Result.failure(Exception("Failed to save image"))
                
                // Process with ML
                val mlResult = mlProcessor.processImage(savedImagePath)
                
                val processedData = ProcessedImageData(
                    imagePath = savedImagePath,
                    isTextBased = mlResult.isTextBased,
                    extractedText = mlResult.extractedText,
                    summary = mlResult.summary,
                    tags = mlResult.tags
                )
                
                Result.success(processedData)
            } catch (e: Exception) {
                Result.failure(e)
            }
        }
    }
    
    suspend fun saveProcessedImage(
        imagePath: String,
        isTextBased: Boolean,
        extractedText: String?,
        summary: String?,
        tags: List<String>,
        confidenceScore: Float
    ): Result<Unit> {
        return withContext(Dispatchers.IO) {
            try {
                val imageEntity = ImageEntity(
                    filePath = imagePath,
                    isTextBased = isTextBased,
                    extractedText = extractedText,
                    summary = summary,
                    tags = if (tags.isNotEmpty()) json.encodeToString(tags) else null,
                    searchKeywords = generateSearchKeywords(
                        MLProcessor.MLResult(
                            isTextBased = isTextBased,
                            extractedText = extractedText,
                            summary = summary,
                            tags = tags,
                            confidence = confidenceScore
                        )
                    ),
                    confidenceScore = confidenceScore,
                    processingStatus = "completed",
                    createdAt = System.currentTimeMillis(),
                    updatedAt = System.currentTimeMillis()
                )
                
                imageDao.insertImage(imageEntity)
                Result.success(Unit)
            } catch (e: Exception) {
                Result.failure(e)
            }
        }
    }
    
    suspend fun processAndSaveImage(imageUri: Uri, context: android.content.Context): Result<Long> {
        return withContext(Dispatchers.IO) {
            try {
                // Load bitmap from URI
                val bitmap = ImageUtils.loadBitmapFromUri(context, imageUri)
                    ?: return@withContext Result.failure(Exception("Failed to load image"))
                
                // Save image to app storage
                val savedImagePath = ImageUtils.saveBitmapToInternalStorage(context, bitmap)
                    ?: return@withContext Result.failure(Exception("Failed to save image"))
                
                // Create initial database entry
                val initialImage = ImageEntity(
                    filePath = savedImagePath,
                    isTextBased = false, // Will be updated after processing
                    extractedText = null,
                    summary = null,
                    tags = null,
                    searchKeywords = null,
                    confidenceScore = null,
                    processingStatus = "processing"
                )
                
                val imageId = imageDao.insertImage(initialImage)
                
                // Process image with ML
                processImageWithML(imageId, savedImagePath)
                
                Result.success(imageId)
            } catch (e: Exception) {
                Result.failure(e)
            }
        }
    }
    
    // Process image with machine learning
    private suspend fun processImageWithML(imageId: Long, imagePath: String) {
        withContext(Dispatchers.IO) {
            try {
                val mlResult = mlProcessor.processImage(imagePath)
                
                val tags = if (mlResult.tags.isNotEmpty()) {
                    json.encodeToString(mlResult.tags)
                } else null
                
                val searchKeywords = generateSearchKeywords(mlResult)
                
                imageDao.updateWithMLResults(
                    id = imageId,
                    extractedText = mlResult.extractedText,
                    summary = mlResult.summary,
                    tags = tags,
                    searchKeywords = searchKeywords,
                    confidenceScore = mlResult.confidence,
                    status = "completed"
                )
                
                // Update isTextBased flag
                val image = imageDao.getImageById(imageId)
                image?.let {
                    val updatedImage = it.copy(
                        isTextBased = mlResult.isTextBased
                    )
                    imageDao.updateImage(updatedImage)
                }
                
            } catch (e: Exception) {
                // Update status to error
                imageDao.updateProcessingStatus(imageId, "error")
            }
        }
    }
    
    // Generate search keywords from ML results
    private fun generateSearchKeywords(mlResult: MLProcessor.MLResult): String {
        val keywords = mutableSetOf<String>()
        
        // Add tags
        keywords.addAll(mlResult.tags)
        
        // Add words from summary
        mlResult.summary?.let { summary ->
            keywords.addAll(
                summary.split(" ", ",", ".", "!", "?")
                    .map { it.trim().lowercase() }
                    .filter { it.length > 2 }
            )
        }
        
        // Add words from extracted text
        mlResult.extractedText?.let { text ->
            keywords.addAll(
                text.split(" ", ",", ".", "!", "?", "\n")
                    .map { it.trim().lowercase() }
                    .filter { it.length > 2 }
                    .take(50) // Limit to prevent overly large keyword sets
            )
        }
        
        return keywords.joinToString(" ")
    }
    
    // Delete image
    suspend fun deleteImage(imageId: Long): Result<Unit> {
        return withContext(Dispatchers.IO) {
            try {
                val image = imageDao.getImageById(imageId)
                image?.let {
                    // Delete file from storage
                    ImageUtils.deleteImageFile(it.filePath)
                    // Delete from database
                    imageDao.deleteImageById(imageId)
                }
                Result.success(Unit)
            } catch (e: Exception) {
                Result.failure(e)
            }
        }
    }
    
    // Extension function to convert entity to UI model
    private fun ImageEntity.toImageWithTags(): ImageWithTags {
        val tagsList = if (!tags.isNullOrEmpty()) {
            try {
                json.decodeFromString<List<String>>(tags)
            } catch (e: Exception) {
                // Fallback to comma-separated parsing
                tags.split(",").map { it.trim() }.filter { it.isNotEmpty() }
            }
        } else {
            emptyList()
        }
        
        return ImageWithTags(
            id = id,
            filePath = filePath,
            isTextBased = isTextBased,
            extractedText = extractedText,
            summary = summary,
            tags = tagsList,
            searchKeywords = searchKeywords,
            confidenceScore = confidenceScore,
            processingStatus = processingStatus,
            createdAt = createdAt,
            updatedAt = updatedAt
        )
    }
}