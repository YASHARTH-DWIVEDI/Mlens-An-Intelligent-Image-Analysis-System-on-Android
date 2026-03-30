package com.mlens.app.ml

import android.content.Context
import android.graphics.Bitmap
import android.util.Log
import com.google.mlkit.vision.common.InputImage
import com.google.mlkit.vision.label.ImageLabeling
import com.google.mlkit.vision.label.defaults.ImageLabelerOptions
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

/**
 * Advanced Scene Analysis for comprehensive scene understanding
 */
class AdvancedSceneAnalyzer(private val context: Context) {
    
    private val sceneLabeler = ImageLabeling.getClient(
        ImageLabelerOptions.Builder()
            .setConfidenceThreshold(0.5f)
            .build()
    )
    
    companion object {
        private const val TAG = "AdvancedSceneAnalyzer"
    }
    
    suspend fun analyzeScene(bitmap: Bitmap): FlagshipImageCaptioner.SceneContext {
        return try {
            val image = InputImage.fromBitmap(bitmap, 0)
            
            // Get scene labels
            val sceneLabels = getSceneLabels(image)
            
            // Analyze image properties
            val colorAnalysis = analyzeColors(bitmap)
            val environmentAnalysis = analyzeEnvironment(sceneLabels, bitmap)
            
            FlagshipImageCaptioner.SceneContext(
                primaryScene = environmentAnalysis.primaryScene,
                isOutdoor = environmentAnalysis.isOutdoor,
                confidence = environmentAnalysis.confidence,
                dominantColors = colorAnalysis.dominantColors
            )
            
        } catch (e: Exception) {
            Log.e(TAG, "Scene analysis failed", e)
            FlagshipImageCaptioner.SceneContext(
                primaryScene = "general scene",
                isOutdoor = false,
                confidence = 0.3f,
                dominantColors = listOf("neutral")
            )
        }
    }
    
    private suspend fun getSceneLabels(image: InputImage): List<Pair<String, Float>> {
        return suspendCancellableCoroutine { continuation ->
            sceneLabeler.process(image)
                .addOnSuccessListener { labels ->
                    val labelPairs = labels.map { it.text to it.confidence }
                    continuation.resume(labelPairs)
                }
                .addOnFailureListener { exception ->
                    continuation.resumeWithException(exception)
                }
        }
    }
    
    private fun analyzeEnvironment(
        sceneLabels: List<Pair<String, Float>>,
        bitmap: Bitmap
    ): EnvironmentAnalysis {
        
        val labelTexts = sceneLabels.map { it.first.lowercase() }
        val labelConfidences = sceneLabels.toMap()
        
        // Determine if outdoor/indoor
        val outdoorIndicators = listOf(
            "outdoor", "sky", "cloud", "tree", "grass", "street", "road", "nature",
            "landscape", "park", "garden", "beach", "mountain", "field"
        )
        
        val indoorIndicators = listOf(
            "indoor", "room", "wall", "ceiling", "furniture", "table", "chair",
            "kitchen", "bedroom", "office", "restaurant", "store"
        )
        
        val outdoorScore = outdoorIndicators.sumOf { indicator ->
            labelTexts.count { it.contains(indicator) } * 
            (labelConfidences[labelTexts.find { it.contains(indicator) }] ?: 0f).toDouble()
        }
        
        val indoorScore = indoorIndicators.sumOf { indicator ->
            labelTexts.count { it.contains(indicator) } * 
            (labelConfidences[labelTexts.find { it.contains(indicator) }] ?: 0f).toDouble()
        }
        
        val isOutdoor = outdoorScore > indoorScore
        val environmentConfidence = kotlin.math.max(outdoorScore, indoorScore) / sceneLabels.size
        
        // Determine primary scene
        val primaryScene = determinePrimaryScene(sceneLabels, isOutdoor)
        
        return EnvironmentAnalysis(
            primaryScene = primaryScene,
            isOutdoor = isOutdoor,
            confidence = environmentConfidence.toFloat()
        )
    }
    
    private fun determinePrimaryScene(
        sceneLabels: List<Pair<String, Float>>,
        isOutdoor: Boolean
    ): String {
        
        val topLabel = sceneLabels.maxByOrNull { it.second }?.first?.lowercase() ?: ""
        
        return when {
            // Specific scene types
            topLabel.contains("kitchen") -> "kitchen"
            topLabel.contains("restaurant") || topLabel.contains("dining") -> "restaurant"
            topLabel.contains("office") || topLabel.contains("workspace") -> "office"
            topLabel.contains("bedroom") -> "bedroom"
            topLabel.contains("bathroom") -> "bathroom"
            topLabel.contains("living") || topLabel.contains("lounge") -> "living room"
            
            // Outdoor scenes
            isOutdoor && topLabel.contains("park") -> "park"
            isOutdoor && topLabel.contains("street") -> "street"
            isOutdoor && topLabel.contains("beach") -> "beach"
            isOutdoor && topLabel.contains("mountain") -> "mountain"
            isOutdoor && topLabel.contains("garden") -> "garden"
            isOutdoor && topLabel.contains("forest") -> "forest"
            
            // General categories
            isOutdoor -> "outdoor scene"
            !isOutdoor -> "indoor scene"
            
            else -> "general scene"
        }
    }
    
    private fun analyzeColors(bitmap: Bitmap): ColorAnalysis {
        val colorCounts = mutableMapOf<String, Int>()
        val sampleSize = 1000 // Sample pixels for performance
        
        val stepX = maxOf(1, bitmap.width / 32)
        val stepY = maxOf(1, bitmap.height / 32)
        
        var totalPixels = 0
        
        for (y in 0 until bitmap.height step stepY) {
            for (x in 0 until bitmap.width step stepX) {
                if (totalPixels >= sampleSize) break
                
                val pixel = bitmap.getPixel(x, y)
                val red = (pixel shr 16) and 0xFF
                val green = (pixel shr 8) and 0xFF
                val blue = pixel and 0xFF
                
                val colorName = categorizeColor(red, green, blue)
                colorCounts[colorName] = colorCounts.getOrDefault(colorName, 0) + 1
                totalPixels++
            }
        }
        
        val dominantColors = colorCounts.entries
            .sortedByDescending { it.value }
            .take(3)
            .map { it.key }
        
        return ColorAnalysis(dominantColors)
    }
    
    private fun categorizeColor(red: Int, green: Int, blue: Int): String {
        val brightness = (red + green + blue) / 3
        
        return when {
            brightness < 50 -> "dark"
            brightness > 200 -> "bright"
            red > green + 30 && red > blue + 30 -> "red"
            green > red + 30 && green > blue + 30 -> "green"
            blue > red + 30 && blue > green + 30 -> "blue"
            red > 150 && green > 150 && blue < 100 -> "yellow"
            red > 150 && green < 100 && blue > 150 -> "purple"
            red < 100 && green > 150 && blue > 150 -> "cyan"
            red > 100 && green > 100 && blue > 100 -> "neutral"
            else -> "mixed"
        }
    }
    
    fun cleanup() {
        sceneLabeler.close()
    }
    
    private data class EnvironmentAnalysis(
        val primaryScene: String,
        val isOutdoor: Boolean,
        val confidence: Float
    )
    
    private data class ColorAnalysis(
        val dominantColors: List<String>
    )
}