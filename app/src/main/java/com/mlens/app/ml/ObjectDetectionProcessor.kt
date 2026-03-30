package com.mlens.app.ml

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Rect
import com.google.mlkit.vision.common.InputImage
import com.google.mlkit.vision.objects.ObjectDetection
import com.google.mlkit.vision.objects.defaults.ObjectDetectorOptions
import com.google.mlkit.vision.objects.DetectedObject
import com.google.mlkit.vision.label.ImageLabeling
import com.google.mlkit.vision.label.defaults.ImageLabelerOptions
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

class ObjectDetectionProcessor(private val context: Context) {
    
    private val objectDetector = ObjectDetection.getClient(
        ObjectDetectorOptions.Builder()
            .setDetectorMode(ObjectDetectorOptions.SINGLE_IMAGE_MODE)
            .enableMultipleObjects()
            .enableClassification()
            .build()
    )
    
    private val imageLabeler = ImageLabeling.getClient(
        ImageLabelerOptions.Builder()
            .setConfidenceThreshold(0.4f) // Lower threshold for more detections
            .build()
    )
    
    
    data class ObjectDetectionResult(
        val objects: List<DetectedObjectInfo>,
        val sceneLabels: List<SceneLabel>,
        val overallConfidence: Float
    )
    
    data class DetectedObjectInfo(
        val boundingBox: Rect,
        val labels: List<ObjectLabel>,
        val trackingId: Int?
    )
    
    data class ObjectLabel(
        val text: String,
        val confidence: Float,
        val category: String
    )
    
    data class SceneLabel(
        val text: String,
        val confidence: Float
    )
    
    suspend fun detectObjects(bitmap: Bitmap): ObjectDetectionResult {
        return try {
            // Enhanced multi-model object detection for maximum accuracy
            val optimizedBitmap = optimizeBitmapForDetection(bitmap)
            val image = InputImage.fromBitmap(optimizedBitmap, 0)
            
            // Run ML Kit detection methods in parallel
            val mlKitObjects = detectObjectsInImage(image)
            val sceneLabels = labelScene(image)
            
            // Use only ML Kit results (optimized and lightweight)
            val combinedObjects = mlKitObjects
            val enhancedObjects = enhanceObjectDetection(combinedObjects, sceneLabels)
            val enhancedSceneLabels = enhanceSceneLabeling(sceneLabels, enhancedObjects)
            
            val overallConfidence = calculateOverallConfidence(enhancedObjects, enhancedSceneLabels)
            
            android.util.Log.d("ObjectDetection", "Detected ${enhancedObjects.size} objects with confidence $overallConfidence")
            
            ObjectDetectionResult(
                objects = enhancedObjects,
                sceneLabels = enhancedSceneLabels,
                overallConfidence = overallConfidence
            )
        } catch (e: Exception) {
            android.util.Log.e("ObjectDetection", "Detection failed", e)
            // Fallback result
            ObjectDetectionResult(
                objects = emptyList(),
                sceneLabels = listOf(SceneLabel("unknown", 0.1f)),
                overallConfidence = 0.1f
            )
        }
    }
    
    private suspend fun detectObjectsInImage(image: InputImage): List<DetectedObjectInfo> {
        return suspendCancellableCoroutine { continuation ->
            objectDetector.process(image)
                .addOnSuccessListener { detectedObjects ->
                    val objectInfos = detectedObjects.map { obj ->
                        val labels = obj.labels.map { label ->
                            ObjectLabel(
                                text = label.text,
                                confidence = label.confidence,
                                category = categorizeObject(label.text)
                            )
                        }
                        
                        DetectedObjectInfo(
                            boundingBox = obj.boundingBox,
                            labels = labels,
                            trackingId = obj.trackingId
                        )
                    }
                    continuation.resume(objectInfos)
                }
                .addOnFailureListener { exception ->
                    continuation.resumeWithException(exception)
                }
        }
    }
    
    private suspend fun labelScene(image: InputImage): List<SceneLabel> {
        return suspendCancellableCoroutine { continuation ->
            imageLabeler.process(image)
                .addOnSuccessListener { labels ->
                    val sceneLabels = labels.map { label ->
                        SceneLabel(
                            text = label.text,
                            confidence = label.confidence
                        )
                    }
                    continuation.resume(sceneLabels)
                }
                .addOnFailureListener { exception ->
                    continuation.resumeWithException(exception)
                }
        }
    }
    
    private fun enhanceObjectDetection(
        objects: List<DetectedObjectInfo>,
        sceneLabels: List<SceneLabel>
    ): List<DetectedObjectInfo> {
        // Enhance object detection with contextual information from scene labels
        return objects.map { obj ->
            val enhancedLabels = obj.labels.map { label ->
                val contextualBonus = calculateContextualBonus(label.text, sceneLabels)
                label.copy(confidence = (label.confidence + contextualBonus).coerceAtMost(1.0f))
            }.sortedByDescending { it.confidence }
            
            obj.copy(labels = enhancedLabels)
        }.sortedByDescending { it.labels.firstOrNull()?.confidence ?: 0f }
    }
    
    private fun enhanceSceneLabeling(
        sceneLabels: List<SceneLabel>,
        objects: List<DetectedObjectInfo>
    ): List<SceneLabel> {
        val enhancedLabels = sceneLabels.toMutableList()
        
        // Add contextual scene labels based on detected objects
        val objectCategories = objects.flatMap { it.labels }.map { it.category }.distinct()
        
        objectCategories.forEach { category ->
            val contextualLabel = generateContextualSceneLabel(category, objects)
            if (contextualLabel != null && enhancedLabels.none { it.text == contextualLabel.text }) {
                enhancedLabels.add(contextualLabel)
            }
        }
        
        return enhancedLabels.sortedByDescending { it.confidence }.take(10)
    }
    
    private fun categorizeObject(objectLabel: String): String {
        return when (objectLabel.lowercase()) {
            in listOf("person", "face", "human") -> "person"
            in listOf("car", "truck", "bus", "motorcycle", "bicycle", "vehicle") -> "vehicle"
            in listOf("dog", "cat", "bird", "horse", "cow", "sheep") -> "animal"
            in listOf("chair", "table", "couch", "bed", "furniture") -> "furniture"
            in listOf("book", "laptop", "phone", "computer", "device") -> "technology"
            in listOf("food", "fruit", "vegetable", "drink", "meal") -> "food"
            in listOf("building", "house", "structure") -> "architecture"
            in listOf("tree", "flower", "plant", "nature") -> "nature"
            in listOf("clothing", "shirt", "pants", "dress") -> "clothing"
            in listOf("tool", "equipment", "instrument") -> "tool"
            else -> "object"
        }
    }
    
    private fun calculateContextualBonus(objectLabel: String, sceneLabels: List<SceneLabel>): Float {
        var bonus = 0f
        
        sceneLabels.forEach { sceneLabel ->
            when {
                // Indoor/outdoor context
                sceneLabel.text.contains("indoor", ignoreCase = true) && 
                objectLabel in listOf("furniture", "technology", "clothing") -> bonus += 0.1f
                
                sceneLabel.text.contains("outdoor", ignoreCase = true) && 
                objectLabel in listOf("vehicle", "nature", "architecture") -> bonus += 0.1f
                
                // Kitchen context
                sceneLabel.text.contains("kitchen", ignoreCase = true) && 
                objectLabel.contains("food", ignoreCase = true) -> bonus += 0.15f
                
                // Office context
                sceneLabel.text.contains("office", ignoreCase = true) && 
                objectLabel in listOf("computer", "laptop", "desk") -> bonus += 0.15f
                
                // Street context
                sceneLabel.text.contains("street", ignoreCase = true) && 
                objectLabel in listOf("car", "person", "building") -> bonus += 0.1f
            }
        }
        
        return bonus.coerceAtMost(0.3f)
    }
    
    private fun generateContextualSceneLabel(
        category: String,
        objects: List<DetectedObjectInfo>
    ): SceneLabel? {
        val objectCount = objects.count { obj -> 
            obj.labels.any { it.category == category } 
        }
        
        return when {
            category == "vehicle" && objectCount >= 2 -> 
                SceneLabel("traffic scene", 0.7f)
            
            category == "person" && objectCount >= 3 -> 
                SceneLabel("crowd", 0.6f)
            
            category == "food" && objectCount >= 2 -> 
                SceneLabel("dining", 0.7f)
            
            category == "nature" && objectCount >= 2 -> 
                SceneLabel("outdoor nature", 0.6f)
            
            category == "furniture" && objectCount >= 3 -> 
                SceneLabel("interior room", 0.7f)
            
            category == "technology" && objectCount >= 2 -> 
                SceneLabel("workspace", 0.6f)
            
            else -> null
        }
    }
    
    private fun calculateOverallConfidence(
        objects: List<DetectedObjectInfo>,
        sceneLabels: List<SceneLabel>
    ): Float {
        val objectConfidence = objects.map { obj ->
            obj.labels.maxOfOrNull { it.confidence } ?: 0f
        }.average().toFloat()
        
        val sceneConfidence = sceneLabels.map { it.confidence }.average().toFloat()
        
        return (objectConfidence * 0.6f + sceneConfidence * 0.4f).coerceIn(0f, 1f)
    }
    
    fun generateDescriptiveText(result: ObjectDetectionResult): String {
        val objects = result.objects
        val sceneLabels = result.sceneLabels
        
        if (objects.isEmpty() && sceneLabels.isEmpty()) {
            return "Image content could not be identified"
        }
        
        val description = StringBuilder()
        
        // Add scene context
        val topSceneLabel = sceneLabels.firstOrNull()
        if (topSceneLabel != null && topSceneLabel.confidence > 0.5f) {
            description.append("Scene: ${topSceneLabel.text}. ")
        }
        
        // Add object information
        when {
            objects.isEmpty() -> {
                description.append("General content: ${sceneLabels.take(3).joinToString(", ") { it.text }}")
            }
            objects.size == 1 -> {
                val obj = objects.first()
                val topLabel = obj.labels.firstOrNull()
                if (topLabel != null) {
                    description.append("Contains: ${topLabel.text}")
                }
            }
            objects.size <= 3 -> {
                val objectNames = objects.mapNotNull { it.labels.firstOrNull()?.text }
                description.append("Contains: ${objectNames.joinToString(", ")}")
            }
            else -> {
                val topObjects = objects.take(3).mapNotNull { it.labels.firstOrNull()?.text }
                description.append("Contains: ${topObjects.joinToString(", ")} and ${objects.size - 3} other objects")
            }
        }
        
        return description.toString()
    }
    
    // Enhanced detection helper methods
    
    private fun optimizeBitmapForDetection(bitmap: Bitmap): Bitmap {
        // Optimize image size and quality for better detection
        val maxSize = 1024
        return if (bitmap.width > maxSize || bitmap.height > maxSize) {
            val scale = maxSize.toFloat() / maxOf(bitmap.width, bitmap.height)
            val newWidth = (bitmap.width * scale).toInt()
            val newHeight = (bitmap.height * scale).toInt()
            Bitmap.createScaledBitmap(bitmap, newWidth, newHeight, true)
        } else {
            bitmap
        }
    }
    
    
    private fun calculateOverlap(rect1: Rect, rect2: Rect): Float {
        val intersectionArea = maxOf(0, minOf(rect1.right, rect2.right) - maxOf(rect1.left, rect2.left)) *
                              maxOf(0, minOf(rect1.bottom, rect2.bottom) - maxOf(rect1.top, rect2.top))
        
        val rect1Area = (rect1.right - rect1.left) * (rect1.bottom - rect1.top)
        val rect2Area = (rect2.right - rect2.left) * (rect2.bottom - rect2.top)
        
        val unionArea = rect1Area + rect2Area - intersectionArea
        
        return if (unionArea > 0) intersectionArea.toFloat() / unionArea else 0f
    }
    
    fun cleanup() {
        objectDetector.close()
        imageLabeler.close()
    }
}