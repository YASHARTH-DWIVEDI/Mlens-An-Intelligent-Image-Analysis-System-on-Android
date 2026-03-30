package com.mlens.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mlens.app.ui.screens.ImageDisplayScreen
import com.mlens.app.ui.screens.ImageUploadScreen
import com.mlens.app.ui.screens.MainScreen
import com.mlens.app.ui.screens.SearchScreen
import com.mlens.app.ui.screens.TagEditScreen
import androidx.compose.runtime.LaunchedEffect
import android.util.Log
import com.mlens.app.ui.theme.MLensTheme
import com.mlens.app.viewmodels.MainViewModel
import com.mlens.app.viewmodels.MainViewModelFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        
        setContent {
            MLensTheme {
                val navController = rememberNavController()
                val application = application as MLensApplication
                val viewModel: MainViewModel = viewModel(
                    factory = MainViewModelFactory(application.repository, this@MainActivity)
                )
                
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = "main",
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable("main") {
                            MainScreen(
                                navController = navController,
                                viewModel = viewModel
                            )
                        }
                        
                        composable("upload") {
                            ImageUploadScreen(
                                navController = navController,
                                repository = application.repository
                            )
                        }
                        
                        composable("search") {
                            SearchScreen(
                                navController = navController,
                                repository = application.repository
                            )
                        }
                        
                        composable("display/{imageId}") { backStackEntry ->
                            val imageId = backStackEntry.arguments?.getString("imageId")?.toLongOrNull()
                            if (imageId != null) {
                                ImageDisplayScreen(
                                    navController = navController,
                                    imageId = imageId,
                                    repository = application.repository
                                )
                            }
                        }
                        
                        composable("tag_edit/{tempId}") { backStackEntry ->
                            val tempId = backStackEntry.arguments?.getString("tempId")?.toLongOrNull() ?: 0L
                            val processedData = application.repository.getTempProcessedData(tempId)
                            
                            if (processedData != null) {
                                TagEditScreen(
                                    navController = navController,
                                    imagePath = processedData.imagePath,
                                    isTextBased = processedData.isTextBased,
                                    extractedText = processedData.extractedText,
                                    summary = processedData.summary,
                                    initialTags = processedData.tags,
                                    repository = application.repository
                                )
                            } else {
                                LaunchedEffect(Unit) {
                                    navController.popBackStack()
                                }
                            }
                        }
                        
                        composable("tag_edit/{tempId}/{existingId}") { backStackEntry ->
                            val tempId = backStackEntry.arguments?.getString("tempId")?.toLongOrNull() ?: 0L
                            val existingId = backStackEntry.arguments?.getString("existingId")?.toLongOrNull()
                            val processedData = application.repository.getTempProcessedData(tempId)
                            
                            if (processedData != null) {
                                TagEditScreen(
                                    navController = navController,
                                    imagePath = processedData.imagePath,
                                    isTextBased = processedData.isTextBased,
                                    extractedText = processedData.extractedText,
                                    summary = processedData.summary,
                                    initialTags = processedData.tags,
                                    repository = application.repository,
                                    existingImageId = existingId
                                )
                            } else {
                                LaunchedEffect(Unit) {
                                    navController.popBackStack()
                                }
                            }
                        }
                        
                        composable("reprocess/{imagePath}") { backStackEntry ->
                            val imagePath = backStackEntry.arguments?.getString("imagePath") ?: ""
                            // Redirect to upload screen for reprocessing
                            LaunchedEffect(imagePath) {
                                navController.navigate("upload") {
                                    popUpTo("main") { inclusive = false }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}