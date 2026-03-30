package com.mlens.app.ml

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Rect
import android.util.Log
import com.google.mlkit.vision.common.InputImage
import com.google.mlkit.vision.objects.ObjectDetection
import com.google.mlkit.vision.objects.defaults.ObjectDetectorOptions
import com.google.mlkit.vision.label.ImageLabeling
import com.google.mlkit.vision.label.defaults.ImageLabelerOptions
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

/**
 * Flagship Object Detection using latest ML Kit models and advanced processing
 */
class FlagshipObjectDetector(private val context: Context) {
    private val yolo by lazy { FlagshipYoloDetector(context) }
    
    private val objectDetector = ObjectDetection.getClient(
        ObjectDetectorOptions.Builder()
            .setDetectorMode(ObjectDetectorOptions.SINGLE_IMAGE_MODE)
            .enableMultipleObjects()
            .enableClassification()
            .build()
    )
    
    private val highAccuracyLabeler = ImageLabeling.getClient(
        ImageLabelerOptions.Builder()
            .setConfidenceThreshold(0.7f)
            .build()
    )
    
    private val broadLabeler = ImageLabeling.getClient(
        ImageLabelerOptions.Builder()
            .setConfidenceThreshold(0.4f)
            .build()
    )
    
    companion object {
        private const val TAG = "FlagshipObjectDetector"
    }
    
    data class FlagshipDetectionResult(
        val objects: List<FlagshipImageCaptioner.DetectedObjectAdvanced>,
        val sceneLabels: List<String>,
        val confidence: Float,
        val processingTime: Long
    )
    
    suspend fun detectObjectsAdvanced(bitmap: Bitmap): List<FlagshipImageCaptioner.DetectedObjectAdvanced> {
        return coroutineScope {
            val startTime = System.currentTimeMillis()
            
            try {
                val image = InputImage.fromBitmap(bitmap, 0)
                
                // Run multiple detection methods in parallel
                val objectsDeferred = async {
                    // Prefer YOLO if available
                    if (yolo.isAvailable()) detectWithYolo(bitmap) else detectObjectsWithBounds(image)
                }
                val highAccuracyLabelsDeferred = async { getHighAccuracyLabels(image) }
                val broadLabelsDeferred = async { getBroadLabels(image) }
                
                val results = awaitAll(
                    objectsDeferred, highAccuracyLabelsDeferred, broadLabelsDeferred
                )
                val objectsAny = results[0]
                val highAccuracyLabels = results[1] as List<Pair<String, Float>>
                val broadLabels = results[2] as List<Pair<String, Float>>
                val objects = when (objectsAny) {
                    is List<*> -> objectsAny.filterIsInstance<ObjectWithBounds>()
                    else -> emptyList()
                }
                
                // Combine and enhance results
                val enhancedObjects = enhanceObjectDetection(objects, highAccuracyLabels, broadLabels, bitmap)
                
                Log.d(TAG, "Advanced object detection completed in ${System.currentTimeMillis() - startTime}ms")
                enhancedObjects
                
            } catch (e: Exception) {
                Log.e(TAG, "Advanced object detection failed", e)
                emptyList()
            }
        }
    }
    
    private suspend fun detectObjectsWithBounds(image: InputImage): List<ObjectWithBounds> {
        return suspendCancellableCoroutine { continuation ->
            objectDetector.process(image)
                .addOnSuccessListener { detectedObjects ->
                    val objects = detectedObjects.map { obj ->
                        ObjectWithBounds(
                            boundingBox = obj.boundingBox,
                            labels = obj.labels.map { it.text to it.confidence },
                            trackingId = obj.trackingId
                        )
                    }
                    continuation.resume(objects)
                }
                .addOnFailureListener { exception ->
                    continuation.resumeWithException(exception)
                }
        }
    }
    
    private fun detectWithYolo(bitmap: Bitmap): List<ObjectWithBounds> {
        return try {
            val detections = yolo.detect(bitmap)
            detections.map {
                ObjectWithBounds(
                    boundingBox = it.box,
                    labels = listOf(it.label to it.score),
                    trackingId = null
                )
            }
        } catch (e: Exception) {
            emptyList()
        }
    }
    
    private suspend fun getHighAccuracyLabels(image: InputImage): List<Pair<String, Float>> {
        return suspendCancellableCoroutine { continuation ->
            highAccuracyLabeler.process(image)
                .addOnSuccessListener { labels ->
                    val labelPairs = labels.map { it.text to it.confidence }
                    continuation.resume(labelPairs)
                }
                .addOnFailureListener { exception ->
                    continuation.resumeWithException(exception)
                }
        }
    }
    
    private suspend fun getBroadLabels(image: InputImage): List<Pair<String, Float>> {
        return suspendCancellableCoroutine { continuation ->
            broadLabeler.process(image)
                .addOnSuccessListener { labels ->
                    val labelPairs = labels.map { it.text to it.confidence }
                    continuation.resume(labelPairs)
                }
                .addOnFailureListener { exception ->
                    continuation.resumeWithException(exception)
                }
        }
    }
    
    private fun enhanceObjectDetection(
        objects: List<ObjectWithBounds>,
        highAccuracyLabels: List<Pair<String, Float>>,
        broadLabels: List<Pair<String, Float>>,
        bitmap: Bitmap
    ): List<FlagshipImageCaptioner.DetectedObjectAdvanced> {
        
        val enhancedObjects = mutableListOf<FlagshipImageCaptioner.DetectedObjectAdvanced>()
        
        // Process objects with bounding boxes first
        objects.forEach { obj ->
            val bestLabel = obj.labels.maxByOrNull { it.second }
            if (bestLabel != null && bestLabel.second > 0.5f) {
                enhancedObjects.add(
                    FlagshipImageCaptioner.DetectedObjectAdvanced(
                        name = cleanObjectName(bestLabel.first),
                        confidence = bestLabel.second,
                        boundingBox = obj.boundingBox
                    )
                )
            }
        }
        
        // Add high-confidence labels without bounding boxes
        highAccuracyLabels.forEach { (label, confidence) ->
            val cleanName = cleanObjectName(label)
            if (!enhancedObjects.any { it.name.equals(cleanName, ignoreCase = true) }) {
                enhancedObjects.add(
                    FlagshipImageCaptioner.DetectedObjectAdvanced(
                        name = cleanName,
                        confidence = confidence,
                        boundingBox = Rect(0, 0, bitmap.width, bitmap.height) // Full image bounds
                    )
                )
            }
        }
        
        // Add contextual objects from broad detection
        val contextualObjects = extractContextualObjects(broadLabels, enhancedObjects)
        enhancedObjects.addAll(contextualObjects)
        
        return enhancedObjects
            .sortedByDescending { it.confidence }
            .take(8) // Limit to top 8 objects for better caption generation
    }
    
    private fun extractContextualObjects(
        broadLabels: List<Pair<String, Float>>,
        existingObjects: List<FlagshipImageCaptioner.DetectedObjectAdvanced>
    ): List<FlagshipImageCaptioner.DetectedObjectAdvanced> {
        
        val contextualObjects = mutableListOf<FlagshipImageCaptioner.DetectedObjectAdvanced>()
        val existingNames = existingObjects.map { it.name.lowercase() }
        
        broadLabels.forEach { (label, confidence) ->
            val cleanName = cleanObjectName(label)
            val lowerName = cleanName.lowercase()
            
            // Only add if not already detected and has reasonable confidence
            if (confidence > 0.5f && !existingNames.contains(lowerName)) {
                // Check if this adds meaningful context
                if (isContextuallyRelevant(cleanName, existingObjects)) {
                    contextualObjects.add(
                        FlagshipImageCaptioner.DetectedObjectAdvanced(
                            name = cleanName,
                            confidence = confidence * 0.8f, // Slightly reduce confidence for contextual objects
                            boundingBox = Rect(0, 0, 100, 100) // Placeholder bounds
                        )
                    )
                }
            }
        }
        
        return contextualObjects.take(3) // Limit contextual objects
    }
    
    private fun isContextuallyRelevant(
        objectName: String,
        existingObjects: List<FlagshipImageCaptioner.DetectedObjectAdvanced>
    ): Boolean {
        val lowerName = objectName.lowercase()
        val existingNames = existingObjects.map { it.name.lowercase() }
        
        return when {
            // Environment context
            lowerName in listOf("outdoor", "indoor", "nature", "urban") -> true
            
            // Activity context
            lowerName in listOf("dining", "sports", "recreation", "work") -> 
                existingNames.any { it.contains("person") }
            
            // Scene context
            lowerName in listOf("landscape", "portrait", "architecture") -> true
            
            // Material/texture context
            lowerName in listOf("grass", "water", "sky", "ground") -> 
                existingNames.any { it in listOf("person", "animal", "vehicle") }
            
            else -> false
        }
    }
    
    private fun cleanObjectName(rawName: String): String {
        return rawName
            .lowercase()
            .replace(Regex("[^a-z0-9\\s]"), "")
            .split(" ")
            .joinToString(" ") { word ->
                word.replaceFirstChar { if (it.isLowerCase()) it.titlecase() else it.toString() }
            }
            .trim()
    }
    
    fun cleanup() {
        objectDetector.close()
        highAccuracyLabeler.close()
        broadLabeler.close()
    }
    
    private data class ObjectWithBounds(
        val boundingBox: Rect,
        val labels: List<Pair<String, Float>>,
        val trackingId: Int?
    )
}