package com.mlens.app.ml

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Rect
import android.util.Log
import org.tensorflow.lite.Interpreter
import org.tensorflow.lite.support.common.FileUtil
import org.tensorflow.lite.support.image.ImageProcessor
import org.tensorflow.lite.support.image.TensorImage
import org.tensorflow.lite.support.image.ops.ResizeOp
import java.nio.ByteBuffer
import java.nio.FloatBuffer

/**
 * Enhanced TensorFlow Lite object detector using the latest EfficientDet models
 * and optimized post-processing for high-quality object detection
 */
class EnhancedTensorFlowDetector(private val context: Context) {
    
    private var interpreter: Interpreter? = null
    private var labels: List<String> = emptyList()
    private var imageProcessor: ImageProcessor? = null
    
    companion object {
        private const val TAG = "EnhancedTFDetector"
        private const val MODEL_PATH = "efficientdet_d0.tflite"
        private const val LABELS_PATH = "coco_labels.txt"
        private const val INPUT_SIZE = 512
        private const val MAX_DETECTIONS = 100
        private const val SCORE_THRESHOLD = 0.3f
        private const val NMS_THRESHOLD = 0.5f
    }
    
    data class Detection(
        val label: String,
        val confidence: Float,
        val boundingBox: Rect,
        val classId: Int
    )
    
    init {
        initializeModel()
    }
    
    fun isAvailable(): Boolean = interpreter != null
    
    private fun initializeModel() {
        try {
            // Load labels
            labels = loadLabels()
            
            // Load model with optimized options
            val options = Interpreter.Options().apply {
                setNumThreads(4) // Use multiple threads for better performance
                setUseNNAPI(true) // Use Android Neural Networks API if available
            }
            
            val modelBuffer = FileUtil.loadMappedFile(context, MODEL_PATH)
            interpreter = Interpreter(modelBuffer, options)
            
            // Setup image processor for EfficientDet
            imageProcessor = ImageProcessor.Builder()
                .add(ResizeOp(INPUT_SIZE, INPUT_SIZE, ResizeOp.ResizeMethod.BILINEAR))
                .build()
            
            Log.d(TAG, "Enhanced TensorFlow Lite detector initialized successfully")
            
        } catch (e: Exception) {
            Log.w(TAG, "Failed to initialize Enhanced TensorFlow detector: ${e.message}")
            interpreter = null
        }
    }
    
    private fun loadLabels(): List<String> {
        return try {
            FileUtil.loadLabels(context, LABELS_PATH)
        } catch (e: Exception) {
            // COCO labels as fallback
            listOf(
                "person", "bicycle", "car", "motorcycle", "airplane", "bus", "train", "truck", "boat",
                "traffic light", "fire hydrant", "stop sign", "parking meter", "bench", "bird", "cat",
                "dog", "horse", "sheep", "cow", "elephant", "bear", "zebra", "giraffe", "backpack",
                "umbrella", "handbag", "tie", "suitcase", "frisbee", "skis", "snowboard", "sports ball",
                "kite", "baseball bat", "baseball glove", "skateboard", "surfboard", "tennis racket",
                "bottle", "wine glass", "cup", "fork", "knife", "spoon", "bowl", "banana", "apple",
                "sandwich", "orange", "broccoli", "carrot", "hot dog", "pizza", "donut", "cake",
                "chair", "couch", "potted plant", "bed", "dining table", "toilet", "tv", "laptop",
                "mouse", "remote", "keyboard", "cell phone", "microwave", "oven", "toaster", "sink",
                "refrigerator", "book", "clock", "vase", "scissors", "teddy bear", "hair drier", "toothbrush"
            )
        }
    }
    
    fun detect(bitmap: Bitmap): List<Detection> {
        val currentInterpreter = interpreter ?: return emptyList()
        val currentProcessor = imageProcessor ?: return emptyList()
        
        try {
            // Preprocess image
            val tensorImage = TensorImage.fromBitmap(bitmap)
            val processedImage = currentProcessor.process(tensorImage)
            
            // Prepare input
            val inputBuffer = processedImage.buffer
            
            // Prepare outputs - EfficientDet typically has 4 outputs
            val outputBoxes = Array(1) { Array(MAX_DETECTIONS) { FloatArray(4) } }
            val outputClasses = Array(1) { FloatArray(MAX_DETECTIONS) }
            val outputScores = Array(1) { FloatArray(MAX_DETECTIONS) }
            val outputCount = FloatArray(1)
            
            val outputs = mapOf(
                0 to outputBoxes,
                1 to outputClasses,
                2 to outputScores,
                3 to outputCount
            )
            
            // Run inference
            currentInterpreter.runForMultipleInputsOutputs(arrayOf(inputBuffer), outputs)
            
            // Post-process results
            return processDetections(
                outputBoxes[0],
                outputClasses[0],
                outputScores[0],
                outputCount[0].toInt(),
                bitmap.width,
                bitmap.height
            )
            
        } catch (e: Exception) {
            Log.e(TAG, "Detection failed: ${e.message}")
            return emptyList()
        }
    }
    
    private fun processDetections(
        boxes: Array<FloatArray>,
        classes: FloatArray,
        scores: FloatArray,
        numDetections: Int,
        originalWidth: Int,
        originalHeight: Int
    ): List<Detection> {
        
        val detections = mutableListOf<Detection>()
        val validDetections = minOf(numDetections, MAX_DETECTIONS, scores.size)
        
        for (i in 0 until validDetections) {
            val score = scores[i]
            if (score < SCORE_THRESHOLD) continue
            
            val classId = classes[i].toInt()
            if (classId < 0 || classId >= labels.size) continue
            
            val box = boxes[i]
            if (box.size < 4) continue
            
            // Convert normalized coordinates to pixel coordinates
            // Assuming box format is [ymin, xmin, ymax, xmax] normalized
            val ymin = (box[0] * originalHeight).toInt().coerceIn(0, originalHeight)
            val xmin = (box[1] * originalWidth).toInt().coerceIn(0, originalWidth)
            val ymax = (box[2] * originalHeight).toInt().coerceIn(0, originalHeight)
            val xmax = (box[3] * originalWidth).toInt().coerceIn(0, originalWidth)
            
            // Ensure valid bounding box
            if (xmax <= xmin || ymax <= ymin) continue
            
            val detection = Detection(
                label = labels[classId],
                confidence = score,
                boundingBox = Rect(xmin, ymin, xmax, ymax),
                classId = classId
            )
            
            detections.add(detection)
        }
        
        // Apply Non-Maximum Suppression
        return applyNMS(detections, NMS_THRESHOLD)
    }
    
    private fun applyNMS(detections: List<Detection>, iouThreshold: Float): List<Detection> {
        if (detections.isEmpty()) return emptyList()
        
        val sortedDetections = detections.sortedByDescending { it.confidence }.toMutableList()
        val selectedDetections = mutableListOf<Detection>()
        
        while (sortedDetections.isNotEmpty()) {
            val best = sortedDetections.removeAt(0)
            selectedDetections.add(best)
            
            // Remove overlapping detections of the same class
            sortedDetections.removeAll { detection ->
                detection.classId == best.classId && 
                calculateIoU(detection.boundingBox, best.boundingBox) > iouThreshold
            }
        }
        
        return selectedDetections
    }
    
    private fun calculateIoU(box1: Rect, box2: Rect): Float {
        val intersectionLeft = maxOf(box1.left, box2.left)
        val intersectionTop = maxOf(box1.top, box2.top)
        val intersectionRight = minOf(box1.right, box2.right)
        val intersectionBottom = minOf(box1.bottom, box2.bottom)
        
        if (intersectionRight <= intersectionLeft || intersectionBottom <= intersectionTop) {
            return 0f
        }
        
        val intersectionArea = (intersectionRight - intersectionLeft) * (intersectionBottom - intersectionTop)
        val box1Area = (box1.right - box1.left) * (box1.bottom - box1.top)
        val box2Area = (box2.right - box2.left) * (box2.bottom - box2.top)
        val unionArea = box1Area + box2Area - intersectionArea
        
        return if (unionArea > 0) intersectionArea.toFloat() / unionArea.toFloat() else 0f
    }
    
    fun cleanup() {
        interpreter?.close()
        interpreter = null
    }
}