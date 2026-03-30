package com.mlens.app.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.mlens.app.data.repository.ImageRepository
import com.mlens.app.ml.MLProcessor
import kotlinx.coroutines.launch
import java.io.File

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TagEditScreen(
    navController: NavController,
    imagePath: String,
    isTextBased: Boolean,
    extractedText: String?,
    summary: String?,
    initialTags: List<String>,
    repository: ImageRepository,
    existingImageId: Long? = null
) {
    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    
    var tags by remember { mutableStateOf(initialTags.toMutableList()) }
    var newTagText by remember { mutableStateOf("") }
    var editedSummary by remember { mutableStateOf(summary ?: "") }
    var isSaving by remember { mutableStateOf(false) }
    
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Edit Tags & Content") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                },
                actions = {
                    IconButton(
                        onClick = {
                            scope.launch {
                                isSaving = true
                                try {
                                    if (existingImageId != null) {
                                        // Update existing image
                                        repository.updateExistingImage(
                                            imageId = existingImageId,
                                            isTextBased = isTextBased,
                                            extractedText = extractedText,
                                            summary = if (isTextBased) editedSummary else null,
                                            tags = if (!isTextBased) tags else emptyList()
                                        )
                                    } else {
                                        // Save as new image
                                        repository.saveProcessedImage(
                                            imagePath = imagePath,
                                            isTextBased = isTextBased,
                                            extractedText = extractedText,
                                            summary = if (isTextBased) editedSummary else null,
                                            tags = if (!isTextBased) tags else emptyList(),
                                            confidenceScore = 0.9f
                                        )
                                    }
                                    navController.navigate("main") {
                                        popUpTo("main") { inclusive = true }
                                    }
                                } catch (e: Exception) {
                                    // Handle error
                                } finally {
                                    isSaving = false
                                }
                            }
                        },
                        enabled = !isSaving
                    ) {
                        if (isSaving) {
                            CircularProgressIndicator(modifier = Modifier.size(24.dp))
                        } else {
                            Icon(Icons.Default.Check, contentDescription = "Save")
                        }
                    }
                }
            )
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Image preview
            item {
                Card(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    AsyncImage(
                        model = ImageRequest.Builder(context)
                            .data(File(imagePath))
                            .crossfade(true)
                            .build(),
                        contentDescription = "Image preview",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp),
                        contentScale = ContentScale.Crop
                    )
                }
            }
            
            // Content type indicator
            item {
                AssistChip(
                    onClick = { },
                    label = { Text(if (isTextBased) "Text Content" else "Visual Content") }
                )
            }
            
            if (isTextBased) {
                // Summary editing for text content
                item {
                    Text(
                        text = "Summary",
                        style = MaterialTheme.typography.titleMedium
                    )
                }
                
                item {
                    OutlinedTextField(
                        value = editedSummary,
                        onValueChange = { editedSummary = it },
                        label = { Text("Edit summary") },
                        modifier = Modifier.fillMaxWidth(),
                        minLines = 3,
                        maxLines = 6
                    )
                }
                
                if (!extractedText.isNullOrEmpty()) {
                    item {
                        Text(
                            text = "Extracted Text",
                            style = MaterialTheme.typography.titleMedium
                        )
                    }
                    
                    item {
                        Card(
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                text = extractedText,
                                modifier = Modifier.padding(16.dp),
                                style = MaterialTheme.typography.bodyMedium
                            )
                        }
                    }
                }
            } else {
                // Tag editing for visual content
                item {
                    Text(
                        text = "Tags",
                        style = MaterialTheme.typography.titleMedium
                    )
                }
                
                // Add new tag
                item {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        OutlinedTextField(
                            value = newTagText,
                            onValueChange = { newTagText = it },
                            label = { Text("Add new tag") },
                            modifier = Modifier.weight(1f),
                            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                            keyboardActions = KeyboardActions(
                                onDone = {
                                    if (newTagText.isNotBlank()) {
                                        tags = tags.toMutableList().apply { 
                                            add(newTagText.trim()) 
                                        }
                                        newTagText = ""
                                    }
                                }
                            )
                        )
                        
                        Spacer(modifier = Modifier.width(8.dp))
                        
                        IconButton(
                            onClick = {
                                if (newTagText.isNotBlank()) {
                                    tags = tags.toMutableList().apply { 
                                        add(newTagText.trim()) 
                                    }
                                    newTagText = ""
                                }
                            }
                        ) {
                            Icon(Icons.Default.Add, contentDescription = "Add tag")
                        }
                    }
                }
                
                // Existing tags
                items(tags.toList()) { tag ->
                    Card(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = tag,
                                style = MaterialTheme.typography.bodyLarge,
                                modifier = Modifier.weight(1f)
                            )
                            
                            IconButton(
                                onClick = { 
                                    tags = tags.toMutableList().apply { 
                                        remove(tag) 
                                    }
                                }
                            ) {
                                Icon(
                                    Icons.Default.Delete,
                                    contentDescription = "Delete tag",
                                    tint = MaterialTheme.colorScheme.error
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}