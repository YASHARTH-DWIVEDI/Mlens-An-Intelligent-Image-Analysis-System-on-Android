package com.mlens.app.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.*
import android.content.Intent
import androidx.core.content.FileProvider
import android.util.Log
import android.net.Uri
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.mlens.app.data.repository.ImageRepository
import kotlinx.coroutines.launch
import java.io.File

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ImageDisplayScreen(
    navController: NavController,
    imageId: Long,
    repository: ImageRepository
) {
    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    var imageData by remember { mutableStateOf<com.mlens.app.data.database.ImageWithTags?>(null) }
    
    LaunchedEffect(imageId) {
        scope.launch {
            imageData = repository.getImageById(imageId)
        }
    }
    
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Image Details") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                },
                actions = {
                    // Share button
                    IconButton(
                        onClick = {
                            imageData?.let { image ->
                                try {
                                    shareImage(context, image)
                                } catch (e: Exception) {
                                    Log.e("MLens", "Error sharing image", e)
                                }
                            }
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Default.Share,
                            contentDescription = "Share"
                        )
                    }
                    
                    // Edit button
                    IconButton(
                        onClick = {
                            imageData?.let { image ->
                                Log.d("MLens", "Opening edit screen for image: ${image.filePath}")
                                
                                // Create ProcessedImageData from current image data
                                val processedData = com.mlens.app.data.repository.ImageRepository.ProcessedImageData(
                                    imagePath = image.filePath,
                                    isTextBased = image.isTextBased,
                                    extractedText = image.extractedText,
                                    summary = image.summary,
                                    tags = image.tags
                                )
                                
                                // Save data temporarily and navigate with existing ID
                                val tempId = System.currentTimeMillis()
                                repository.saveTempProcessedData(tempId, processedData)
                                
                                navController.navigate("tag_edit/$tempId/${image.id}")
                            }
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Default.Edit,
                            contentDescription = "Edit"
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        imageData?.let { image ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .verticalScroll(rememberScrollState())
                    .padding(16.dp)
            ) {
                // Full Image Display
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(File(image.filePath))
                        .crossfade(true)
                        .build(),
                    contentDescription = "Full Image",
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(1f), // Square aspect ratio, adjust as needed
                    contentScale = ContentScale.Fit // Show full image without cropping
                )
                
                Spacer(modifier = Modifier.height(16.dp))
                
                // Extracted Text (if any)
                if (!image.extractedText.isNullOrEmpty()) {
                    Text(
                        text = "Extracted Text:",
                        style = MaterialTheme.typography.titleMedium
                    )
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                    ) {
                        // SelectionContainer makes text selectable with long press
                        SelectionContainer {
                            Text(
                                text = image.extractedText,
                                modifier = Modifier.padding(16.dp),
                                style = MaterialTheme.typography.bodyMedium
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                }
                
                // Tags (always show if available)
                if (image.tags.isNotEmpty()) {
                    Text(
                        text = "Tags:",
                        style = MaterialTheme.typography.titleMedium
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    
                    // Display tags in a flow layout
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        image.tags.take(6).forEach { tag -> // Show max 6 tags per row
                            AssistChip(
                                onClick = { },
                                label = { Text(tag) }
                            )
                        }
                    }
                    
                    // Show remaining tags if more than 6
                    if (image.tags.size > 6) {
                        Spacer(modifier = Modifier.height(8.dp))
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            image.tags.drop(6).forEach { tag ->
                                AssistChip(
                                    onClick = { },
                                    label = { Text(tag) }
                                )
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                }
                
                // Description/Summary (if any)
                if (!image.summary.isNullOrEmpty()) {
                    Text(
                        text = "Summary:",
                        style = MaterialTheme.typography.titleMedium
                    )
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                    ) {
                        // SelectionContainer makes text selectable with long press
                        SelectionContainer {
                            Text(
                                text = image.summary,
                                modifier = Modifier.padding(16.dp),
                                style = MaterialTheme.typography.bodyMedium
                            )
                        }
                    }
                }
                
                // Confidence score
                image.confidenceScore?.let { confidence ->
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = "Confidence: ${(confidence * 100).toInt()}%",
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            }
        }
    }
}

private fun shareImage(context: android.content.Context, image: com.mlens.app.data.database.ImageWithTags) {
    try {
        val imageFile = java.io.File(image.filePath)
        Log.d("MLens", "Attempting to share image: ${imageFile.absolutePath}")
        
        if (!imageFile.exists()) {
            Log.e("MLens", "Image file does not exist: ${image.filePath}")
            return
        }
        
        // Copy to cache directory for sharing (workaround for FileProvider path issues)
        val cacheDir = File(context.cacheDir, "shared_images")
        if (!cacheDir.exists()) {
            cacheDir.mkdirs()
        }
        
        val tempFile = File(cacheDir, "shared_image_${System.currentTimeMillis()}.jpg")
        imageFile.copyTo(tempFile, overwrite = true)
        
        Log.d("MLens", "Copied to temp file: ${tempFile.absolutePath}")
        
        val imageUri = try {
            FileProvider.getUriForFile(
                context,
                "${context.packageName}.fileprovider",
                tempFile
            )
        } catch (e: Exception) {
            Log.e("MLens", "Error creating FileProvider URI: ${e.message}", e)
            return
        }
        
        Log.d("MLens", "Created URI: $imageUri")
        
        val shareIntent = Intent().apply {
            action = Intent.ACTION_SEND
            type = "image/*"
            putExtra(Intent.EXTRA_STREAM, imageUri)
            addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
        }
        
        Log.d("MLens", "Starting share chooser...")
        
        try {
            val chooser = Intent.createChooser(shareIntent, "Share Image")
            if (context !is android.app.Activity) {
                chooser.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            }
            context.startActivity(chooser)
            Log.d("MLens", "Share chooser launched successfully")
            
            // Clean up temp file after a delay (in a real app, you'd do this more elegantly)
            android.os.Handler(android.os.Looper.getMainLooper()).postDelayed({
                try {
                    tempFile.delete()
                    Log.d("MLens", "Cleaned up temp file")
                } catch (e: Exception) {
                    Log.e("MLens", "Error cleaning up temp file: ${e.message}")
                }
            }, 5000) // 5 seconds delay
            
        } catch (e: Exception) {
            Log.e("MLens", "Error launching share chooser: ${e.message}", e)
            tempFile.delete() // Clean up on error
        }
        
    } catch (e: Exception) {
        Log.e("MLens", "Error in shareImage function: ${e.message}", e)
    }
}