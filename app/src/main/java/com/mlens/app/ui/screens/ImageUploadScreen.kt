package com.mlens.app.ui.screens

import android.Manifest
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.icons.filled.PhotoLibrary
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import android.util.Log
import androidx.core.content.FileProvider
import androidx.navigation.NavController
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberMultiplePermissionsState
import com.mlens.app.data.repository.ImageRepository
import com.mlens.app.ui.components.LoadingIndicator
import com.mlens.app.utils.ImageUtils
import kotlinx.coroutines.launch
import java.io.File

@OptIn(ExperimentalMaterial3Api::class, ExperimentalPermissionsApi::class)
@Composable
fun ImageUploadScreen(
    navController: NavController,
    repository: ImageRepository
) {
    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    var isProcessing by remember { mutableStateOf(false) }
    var currentPhotoUri by remember { mutableStateOf<Uri?>(null) }
    
    // Permission handling
    val permissionsState = rememberMultiplePermissionsState(
        permissions = listOf(
            Manifest.permission.CAMERA,
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.TIRAMISU) {
                Manifest.permission.READ_MEDIA_IMAGES
            } else {
                Manifest.permission.READ_EXTERNAL_STORAGE
            }
        )
    )
    
    // Camera launcher
    val cameraLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.TakePicture()
    ) { success ->
        Log.d("MLens", "Camera result: success=$success, uri=$currentPhotoUri")
        if (success && currentPhotoUri != null) {
            scope.launch {
                isProcessing = true
                try {
                    Log.d("MLens", "Processing camera image: $currentPhotoUri")
                    val result = repository.processImageForEditing(currentPhotoUri!!, context)
                    
                    // Navigate to tag editing screen
                    result.getOrNull()?.let { processedData ->
                        // Save data temporarily and navigate with simple ID
                        val tempId = System.currentTimeMillis()
                        repository.saveTempProcessedData(tempId, processedData)
                        Log.d("MLens", "Saved temp data with ID: $tempId, navigating to tag_edit/$tempId")
                        isProcessing = false
                        navController.navigate("tag_edit/$tempId") {
                            popUpTo("upload") { inclusive = true }
                        }
                    } ?: run {
                        Log.e("MLens", "Failed to get processed data")
                        isProcessing = false
                        navController.popBackStack()
                    }
                } catch (e: Exception) {
                    Log.e("MLens", "Error processing camera image", e)
                    isProcessing = false
                }
            }
        } else {
            Log.w("MLens", "Camera capture failed or cancelled")
            isProcessing = false
        }
    }
    
    // Gallery launcher
    val galleryLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri ->
        Log.d("MLens", "Gallery result received: $uri")
        uri?.let {
            scope.launch {
                isProcessing = true
                try {
                    Log.d("MLens", "Starting image processing for URI: $it")
                    val result = repository.processImageForEditing(it, context)
                    Log.d("MLens", "Image processing result: $result")
                    
                    // Navigate to tag editing screen
                    result.getOrNull()?.let { processedData ->
                        // Save data temporarily and navigate with simple ID
                        val tempId = System.currentTimeMillis()
                        repository.saveTempProcessedData(tempId, processedData)
                        Log.d("MLens", "Saved temp data with ID: $tempId, navigating to tag_edit/$tempId")
                        isProcessing = false
                        navController.navigate("tag_edit/$tempId") {
                            popUpTo("upload") { inclusive = true }
                        }
                    } ?: run {
                        Log.e("MLens", "Failed to get processed data")
                        isProcessing = false
                        navController.popBackStack()
                    }
                } catch (e: Exception) {
                    Log.e("MLens", "Error processing image", e)
                    isProcessing = false
                }
            }
        } ?: run {
            Log.w("MLens", "Gallery selection cancelled or failed")
            isProcessing = false
        }
    }
    
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Add Image") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        if (isProcessing) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                contentAlignment = Alignment.Center
            ) {
                LoadingIndicator(text = "Processing image...")
            }
        } else {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Choose how to add your image",
                    style = MaterialTheme.typography.headlineSmall,
                    modifier = Modifier.padding(bottom = 32.dp)
                )
                
                // Camera button
                Button(
                    onClick = {
                        Log.d("MLens", "Camera button clicked")
                        if (permissionsState.allPermissionsGranted) {
                            try {
                                val photoFile = File(
                                    context.cacheDir,
                                    ImageUtils.generateImageFilename()
                                )
                                Log.d("MLens", "Created photo file: ${photoFile.absolutePath}")
                                currentPhotoUri = FileProvider.getUriForFile(
                                    context,
                                    "${context.packageName}.fileprovider",
                                    photoFile
                                )
                                Log.d("MLens", "Generated URI: $currentPhotoUri")
                                isProcessing = true
                                cameraLauncher.launch(currentPhotoUri!!)
                            } catch (e: Exception) {
                                Log.e("MLens", "Error setting up camera", e)
                                isProcessing = false
                            }
                        } else {
                            Log.d("MLens", "Requesting camera permissions")
                            permissionsState.launchMultiplePermissionRequest()
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.CameraAlt,
                        contentDescription = null,
                        modifier = Modifier.padding(end = 8.dp)
                    )
                    Text("Take Photo")
                }
                
                Spacer(modifier = Modifier.height(16.dp))
                
                // Gallery button
                OutlinedButton(
                    onClick = {
                        Log.d("MLens", "Gallery button clicked")
                        Log.d("MLens", "Permissions granted: ${permissionsState.allPermissionsGranted}")
                        if (permissionsState.allPermissionsGranted) {
                            Log.d("MLens", "Launching gallery picker")
                            galleryLauncher.launch("image/*")
                        } else {
                            Log.d("MLens", "Requesting permissions")
                            permissionsState.launchMultiplePermissionRequest()
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.PhotoLibrary,
                        contentDescription = null,
                        modifier = Modifier.padding(end = 8.dp)
                    )
                    Text("Choose from Gallery")
                }
                
                if (!permissionsState.allPermissionsGranted) {
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = "Camera and storage permissions are required",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.error
                    )
                }
            }
        }
    }
}

