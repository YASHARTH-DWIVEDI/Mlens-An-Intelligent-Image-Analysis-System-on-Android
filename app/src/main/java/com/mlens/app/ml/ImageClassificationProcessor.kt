package com.mlens.app.ml

import android.content.Context
import android.graphics.Bitmap
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.coroutines.suspendCancellableCoroutine
import org.tensorflow.lite.Interpreter
import org.tensorflow.lite.support.common.FileUtil
import org.tensorflow.lite.support.image.ImageProcessor
import org.tensorflow.lite.support.image.TensorImage
import org.tensorflow.lite.support.image.ops.ResizeOp
import org.tensorflow.lite.support.label.TensorLabel
import java.nio.FloatBuffer
import java.nio.MappedByteBuffer
import com.google.mlkit.vision.common.InputImage
import com.google.mlkit.vision.label.ImageLabeling
import com.google.mlkit.vision.label.defaults.ImageLabelerOptions
import com.google.mlkit.vision.label.ImageLabel
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

class ImageClassificationProcessor(private val context: Context) {
    
    private var interpreter: Interpreter? = null
    private var labels: List<String> = emptyList()
    private var imageProcessor: ImageProcessor? = null
    
    data class ClassificationResult(
        val labels: List<ClassificationLabel>
    )
    
    data class ClassificationLabel(
        val label: String,
        val confidence: Float
    )
    
    companion object {
        private const val TAG = "ImageClassificationProcessor"
        private const val MODEL_PATH = "mobilenet_v1_1.0_224.tflite"
        private const val LABELS_PATH = "labels.txt"
        private const val IMAGE_SIZE = 224
        private const val MAX_RESULTS = 5
        private const val CONFIDENCE_THRESHOLD = 0.1f
    }
    
    init {
        initializeModel()
    }
    
    private fun initializeModel() {
        try {
            // Load TensorFlow Lite model
            val modelBuffer = loadModelFile()
            val options = Interpreter.Options()
            interpreter = Interpreter(modelBuffer, options)
            
            // Load labels
            labels = loadLabels()
            
            // Setup image processor
            imageProcessor = ImageProcessor.Builder()
                .add(ResizeOp(IMAGE_SIZE, IMAGE_SIZE, ResizeOp.ResizeMethod.BILINEAR))
                .build()
                
        } catch (e: Exception) {
            android.util.Log.e(TAG, "Failed to initialize image processor", e)
            // Fallback to basic classification without model
        }
    }
    
    private fun loadModelFile(): MappedByteBuffer {
        return try {
            FileUtil.loadMappedFile(context, MODEL_PATH)
        } catch (e: Exception) {
            // If bundled model is not available, create a placeholder
            // In real implementation, you would download or bundle the actual model
            throw IllegalStateException("Model file not found. Please add $MODEL_PATH to assets folder")
        }
    }
    
    private fun loadLabels(): List<String> {
        return try {
            FileUtil.loadLabels(context, LABELS_PATH)
        } catch (e: Exception) {
            // Fallback labels for common objects
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
                "refrigerator", "book", "clock", "vase", "scissors", "teddy bear", "hair drier",
                "toothbrush", "food", "nature", "building", "vehicle", "animal", "object"
            )
        }
    }
    
    suspend fun classifyImage(bitmap: Bitmap): ClassificationResult {
        return try {
            // Optimized ML Kit approach with better preprocessing
            val optimizedBitmap = optimizeImageForML(bitmap)
            
            // Use multiple ML Kit detectors for comprehensive analysis
            val results = mutableListOf<ClassificationLabel>()
            
            // 1. Enhanced ML Kit Image Labeling with higher confidence
            val mlKitResults = classifyWithEnhancedMLKit(optimizedBitmap)
            results.addAll(mlKitResults)
            
            // 2. Multiple ML Kit passes for better detection
            val secondPassResults = classifyWithDifferentSettings(optimizedBitmap)
            results.addAll(secondPassResults)
            
            // 3. Smart contextual enhancement based on detected objects
            val enhancedResults = enhanceResultsIntelligently(results, optimizedBitmap)
            
            if (enhancedResults.isNotEmpty()) {
                ClassificationResult(enhancedResults.take(8)) // Limit to 8 best results
            } else {
                // Improved fallback with better image analysis
                val fallbackResults = improvedFallbackClassification(optimizedBitmap)
                ClassificationResult(fallbackResults)
            }
        } catch (e: Exception) {
            fallbackClassification(bitmap)
        }
    }
    
    private fun optimizeImageForML(bitmap: Bitmap): Bitmap {
        // Optimize image for better ML Kit performance
        val targetSize = 1024
        val scaledBitmap = if (bitmap.width > targetSize || bitmap.height > targetSize) {
            val scale = targetSize.toFloat() / maxOf(bitmap.width, bitmap.height)
            val newWidth = (bitmap.width * scale).toInt()
            val newHeight = (bitmap.height * scale).toInt()
            Bitmap.createScaledBitmap(bitmap, newWidth, newHeight, true)
        } else {
            bitmap
        }
        
        // Enhance contrast and brightness for better recognition
        return enhanceImageContrast(scaledBitmap)
    }
    
    private fun enhanceImageContrast(bitmap: Bitmap): Bitmap {
        val enhanced = bitmap.copy(bitmap.config ?: Bitmap.Config.ARGB_8888, true)
        val pixels = IntArray(enhanced.width * enhanced.height)
        enhanced.getPixels(pixels, 0, enhanced.width, 0, 0, enhanced.width, enhanced.height)
        
        // Simple contrast enhancement
        for (i in pixels.indices) {
            val pixel = pixels[i]
            val red = ((pixel shr 16) and 0xFF)
            val green = ((pixel shr 8) and 0xFF)
            val blue = (pixel and 0xFF)
            
            // Enhance contrast (simple linear stretch)
            val enhancedRed = minOf(255, maxOf(0, ((red - 128) * 1.2 + 128).toInt()))
            val enhancedGreen = minOf(255, maxOf(0, ((green - 128) * 1.2 + 128).toInt()))
            val enhancedBlue = minOf(255, maxOf(0, ((blue - 128) * 1.2 + 128).toInt()))
            
            pixels[i] = (0xFF shl 24) or (enhancedRed shl 16) or (enhancedGreen shl 8) or enhancedBlue
        }
        
        enhanced.setPixels(pixels, 0, enhanced.width, 0, 0, enhanced.width, enhanced.height)
        return enhanced
    }
    
    private suspend fun classifyWithEnhancedMLKit(bitmap: Bitmap): List<ClassificationLabel> {
        return try {
            val image = InputImage.fromBitmap(bitmap, 0)
            
            // Use high accuracy options
            val options = ImageLabelerOptions.Builder()
                .setConfidenceThreshold(0.6f) // Higher confidence threshold
                .build()
            
            val labeler = ImageLabeling.getClient(options)
            
            val labels = suspendCancellableCoroutine<List<ImageLabel>> { continuation ->
                labeler.process(image)
                    .addOnSuccessListener { labels ->
                        continuation.resume(labels)
                    }
                    .addOnFailureListener { exception ->
                        continuation.resumeWithException(exception)
                    }
            }
            
            // Filter and enhance results
            labels
                .filter { it.confidence > 0.65f } // Even higher confidence for quality
                .sortedByDescending { it.confidence }
                .take(6) // Limit to top 6 results
                .map { label ->
                    ClassificationLabel(
                        label = cleanLabelText(label.text),
                        confidence = label.confidence
                    )
                }
        } catch (e: Exception) {
            emptyList()
        }
    }
    
    
    private fun enhanceResultsIntelligently(results: List<ClassificationLabel>, bitmap: Bitmap): List<ClassificationLabel> {
        // Group similar labels and pick the best confidence
        val groupedResults = results
            .groupBy { normalizeLabel(it.label) }
            .map { (_, labels) ->
                labels.maxByOrNull { it.confidence } ?: labels.first()
            }
            .sortedByDescending { it.confidence }
        
        // Add contextual tags only if they make sense
        val enhancedResults = groupedResults.toMutableList()
        
        // Add scene context based on detected objects (not hardcoded)
        val detectedLabels = groupedResults.map { it.label.lowercase() }
        
        // Only add contextual tags if there's strong evidence
        when {
            detectedLabels.any { it.contains("person") || it.contains("face") } -> {
                if (!detectedLabels.any { it.contains("people") || it.contains("portrait") }) {
                    enhancedResults.add(ClassificationLabel("People", 0.7f))
                }
            }
            detectedLabels.any { it.contains("food") || it.contains("drink") } -> {
                if (!detectedLabels.any { it.contains("dining") }) {
                    enhancedResults.add(ClassificationLabel("Food & Drink", 0.6f))
                }
            }
            detectedLabels.any { it.contains("car") || it.contains("vehicle") } -> {
                if (!detectedLabels.any { it.contains("transportation") }) {
                    enhancedResults.add(ClassificationLabel("Transportation", 0.6f))
                }
            }
        }
        
        return enhancedResults
            .distinctBy { it.label }
            .sortedByDescending { it.confidence }
    }
    
    private fun improvedFallbackClassification(bitmap: Bitmap): List<ClassificationLabel> {
        val results = mutableListOf<ClassificationLabel>()
        
        // Analyze basic image properties
        val analysis = analyzeBasicImageProperties(bitmap)
        
        // Add basic classifications based on image analysis
        when {
            analysis.aspectRatio > 1.5 -> results.add(ClassificationLabel("Landscape", 0.5f))
            analysis.aspectRatio < 0.7 -> results.add(ClassificationLabel("Portrait", 0.5f))
            else -> results.add(ClassificationLabel("Square Format", 0.5f))
        }
        
        // Color-based classification
        when {
            analysis.dominantColor == "blue" -> results.add(ClassificationLabel("Blue Tones", 0.4f))
            analysis.dominantColor == "green" -> results.add(ClassificationLabel("Green Tones", 0.4f))
            analysis.dominantColor == "red" -> results.add(ClassificationLabel("Red Tones", 0.4f))
        }
        
        // Brightness-based classification
        when {
            analysis.brightness > 0.8 -> results.add(ClassificationLabel("Bright", 0.4f))
            analysis.brightness < 0.3 -> results.add(ClassificationLabel("Dark", 0.4f))
        }
        
        return results.take(3)
    }
    
    private fun cleanLabelText(text: String): String {
        return text.split(" ")
            .joinToString(" ") { word ->
                word.lowercase().replaceFirstChar { 
                    if (it.isLowerCase()) it.titlecase() else it.toString() 
                }
            }
    }
    
    private fun normalizeLabel(label: String): String {
        return label.lowercase()
            .replace(Regex("[^a-z0-9\\s]"), "")
            .trim()
    }
    
    data class BasicImageAnalysis(
        val aspectRatio: Float,
        val brightness: Float,
        val dominantColor: String
    )
    
    private fun analyzeBasicImageProperties(bitmap: Bitmap): BasicImageAnalysis {
        val aspectRatio = bitmap.width.toFloat() / bitmap.height.toFloat()
        
        // Sample pixels for analysis
        val pixels = IntArray(minOf(1000, bitmap.width * bitmap.height))
        val sampleStep = maxOf(1, (bitmap.width * bitmap.height) / 1000)
        
        var index = 0
        var redSum = 0L
        var greenSum = 0L
        var blueSum = 0L
        var brightnessSum = 0L
        
        for (y in 0 until bitmap.height step maxOf(1, bitmap.height / 32)) {
            for (x in 0 until bitmap.width step maxOf(1, bitmap.width / 32)) {
                if (index < pixels.size) {
                    val pixel = bitmap.getPixel(x, y)
                    pixels[index] = pixel
                    
                    val red = (pixel shr 16) and 0xFF
                    val green = (pixel shr 8) and 0xFF
                    val blue = pixel and 0xFF
                    
                    redSum += red
                    greenSum += green
                    blueSum += blue
                    brightnessSum += (red + green + blue) / 3
                    
                    index++
                }
            }
        }
        
        val avgRed = redSum / index
        val avgGreen = greenSum / index
        val avgBlue = blueSum / index
        val brightness = (brightnessSum / index).toFloat() / 255f
        
        val dominantColor = when {
            avgRed > avgGreen && avgRed > avgBlue -> "red"
            avgGreen > avgRed && avgGreen > avgBlue -> "green"
            avgBlue > avgRed && avgBlue > avgGreen -> "blue"
            else -> "neutral"
        }
        
        return BasicImageAnalysis(aspectRatio, brightness, dominantColor)
    }
    
    private suspend fun classifyWithDifferentSettings(bitmap: Bitmap): List<ClassificationLabel> {
        return try {
            val image = InputImage.fromBitmap(bitmap, 0)
            
            // Use lower confidence threshold for more detection
            val options = ImageLabelerOptions.Builder()
                .setConfidenceThreshold(0.4f) // Lower threshold for more results
                .build()
            
            val labeler = ImageLabeling.getClient(options)
            
            val labels = suspendCancellableCoroutine<List<ImageLabel>> { continuation ->
                labeler.process(image)
                    .addOnSuccessListener { labels ->
                        continuation.resume(labels)
                    }
                    .addOnFailureListener { exception ->
                        continuation.resumeWithException(exception)
                    }
            }
            
            // Filter and enhance results from second pass
            labels
                .filter { it.confidence > 0.45f && it.confidence < 0.65f } // Get mid-confidence results
                .sortedByDescending { it.confidence }
                .take(4) // Limit to top 4 additional results
                .map { label ->
                    ClassificationLabel(
                        label = cleanLabelText(label.text),
                        confidence = label.confidence * 0.9f // Slightly reduce confidence for second pass
                    )
                }
        } catch (e: Exception) {
            emptyList()
        }
    }
    
    private suspend fun classifyWithMLKit(bitmap: Bitmap): List<String> = withContext(Dispatchers.IO) {
        try {
            val image = InputImage.fromBitmap(bitmap, 0)
            val labeler = ImageLabeling.getClient(ImageLabelerOptions.DEFAULT_OPTIONS)
            
            val labels = suspendCancellableCoroutine<List<ImageLabel>> { continuation ->
                labeler.process(image)
                    .addOnSuccessListener { labels ->
                        continuation.resume(labels)
                    }
                    .addOnFailureListener { exception ->
                        continuation.resumeWithException(exception)
                    }
            }
            
            // Filter and format labels with confidence > 0.6
            labels.filter { it.confidence > 0.6f }
                .sortedByDescending { it.confidence }
                .take(6)
                .map { label ->
                    // Clean up label text
                    label.text.lowercase()
                        .split(" ")
                        .joinToString(" ") { word ->
                            word.replaceFirstChar { if (it.isLowerCase()) it.titlecase() else it.toString() }
                        }
                }
        } catch (e: Exception) {
            emptyList()
        }
    }
    
    private fun enhanceMLKitResults(mlKitLabels: List<String>, bitmap: Bitmap): List<String> {
        val enhancedTags = mutableListOf<String>()
        enhancedTags.addAll(mlKitLabels)
        
        val labelText = mlKitLabels.joinToString(" ").lowercase()
        
        // Add contextual and scene tags
        val contextualTags = generateSmartContextualTags(labelText, bitmap)
        enhancedTags.addAll(contextualTags)
        
        // Add color and composition tags
        val visualTags = analyzeVisualProperties(bitmap)
        enhancedTags.addAll(visualTags)
        
        return enhancedTags.distinct().take(12)
    }
    
    private fun generateSmartContextualTags(labelText: String, bitmap: Bitmap): List<String> {
        val contextualTags = mutableListOf<String>()
        
        // Scene and activity detection
        when {
            labelText.contains("person") && labelText.contains("food") -> {
                contextualTags.addAll(listOf("Dining", "Social", "Meal"))
            }
            labelText.contains("car") || labelText.contains("vehicle") || labelText.contains("road") -> {
                contextualTags.addAll(listOf("Transportation", "Travel", "Automotive"))
            }
            labelText.contains("building") || labelText.contains("architecture") -> {
                contextualTags.addAll(listOf("Urban", "Architecture", "City"))
            }
            labelText.contains("tree") || labelText.contains("plant") || labelText.contains("flower") -> {
                contextualTags.addAll(listOf("Nature", "Outdoors", "Garden"))
            }
            labelText.contains("animal") || labelText.contains("dog") || labelText.contains("cat") -> {
                contextualTags.addAll(listOf("Animals", "Pets", "Wildlife"))
            }
            labelText.contains("water") || labelText.contains("sea") || labelText.contains("lake") -> {
                contextualTags.addAll(listOf("Water", "Landscape", "Nature"))
            }
            labelText.contains("sky") || labelText.contains("cloud") -> {
                contextualTags.addAll(listOf("Sky", "Weather", "Outdoors"))
            }
            labelText.contains("food") || labelText.contains("drink") -> {
                contextualTags.addAll(listOf("Food & Drink", "Cuisine", "Dining"))
            }
            labelText.contains("sport") || labelText.contains("ball") -> {
                contextualTags.addAll(listOf("Sports", "Recreation", "Activity"))
            }
            labelText.contains("book") || labelText.contains("text") -> {
                contextualTags.addAll(listOf("Reading", "Education", "Literature"))
            }
            labelText.contains("computer") || labelText.contains("phone") -> {
                contextualTags.addAll(listOf("Technology", "Electronics", "Digital"))
            }
        }
        
        // Environment detection
        when {
            labelText.contains("indoor") || labelText.contains("room") -> contextualTags.add("Indoor")
            labelText.contains("outdoor") || labelText.contains("outside") -> contextualTags.add("Outdoor")
        }
        
        // Time of day detection (basic)
        val brightness = calculateImageBrightness(bitmap)
        when {
            brightness < 0.3 -> contextualTags.add("Night")
            brightness > 0.7 -> contextualTags.add("Bright")
            else -> contextualTags.add("Daylight")
        }
        
        return contextualTags.distinct()
    }
    
    private fun analyzeVisualProperties(bitmap: Bitmap): List<String> {
        val visualTags = mutableListOf<String>()
        
        // Aspect ratio analysis
        val aspectRatio = bitmap.width.toFloat() / bitmap.height.toFloat()
        when {
            aspectRatio > 1.5 -> visualTags.add("Landscape Format")
            aspectRatio < 0.7 -> visualTags.add("Portrait Format")
            else -> visualTags.add("Square Format")
        }
        
        // Color analysis
        val colorInfo = analyzeImageColors(bitmap)
        visualTags.addAll(colorInfo)
        
        return visualTags
    }
    
    private fun analyzeImageColors(bitmap: Bitmap): List<String> {
        val colorTags = mutableListOf<String>()
        
        // Sample pixels for color analysis
        val sampleSize = minOf(bitmap.width * bitmap.height, 10000)
        val pixels = IntArray(sampleSize)
        
        val stepX = bitmap.width / kotlin.math.sqrt(sampleSize.toDouble()).toInt()
        val stepY = bitmap.height / kotlin.math.sqrt(sampleSize.toDouble()).toInt()
        
        var index = 0
        for (y in 0 until bitmap.height step stepY) {
            for (x in 0 until bitmap.width step stepX) {
                if (index < sampleSize) {
                    pixels[index] = bitmap.getPixel(x, y)
                    index++
                }
            }
        }
        
        var redSum = 0
        var greenSum = 0
        var blueSum = 0
        var saturationSum = 0f
        
        for (pixel in pixels.take(index)) {
            val red = (pixel shr 16) and 0xFF
            val green = (pixel shr 8) and 0xFF
            val blue = pixel and 0xFF
            
            redSum += red
            greenSum += green
            blueSum += blue
            
            // Calculate saturation
            val max = maxOf(red, green, blue)
            val min = minOf(red, green, blue)
            val saturation = if (max != 0) (max - min).toFloat() / max else 0f
            saturationSum += saturation
        }
        
        val avgRed = redSum / index
        val avgGreen = greenSum / index
        val avgBlue = blueSum / index
        val avgSaturation = saturationSum / index
        
        // Dominant color detection
        when {
            avgRed > avgGreen + 20 && avgRed > avgBlue + 20 -> colorTags.add("Red Tones")
            avgGreen > avgRed + 20 && avgGreen > avgBlue + 20 -> colorTags.add("Green Tones")
            avgBlue > avgRed + 20 && avgBlue > avgGreen + 20 -> colorTags.add("Blue Tones")
            avgRed > 150 && avgGreen > 150 && avgBlue < 100 -> colorTags.add("Warm Colors")
            avgBlue > 150 && avgRed < 100 && avgGreen < 100 -> colorTags.add("Cool Colors")
        }
        
        // Saturation analysis
        when {
            avgSaturation > 0.7 -> colorTags.add("Vibrant")
            avgSaturation < 0.3 -> colorTags.add("Muted Colors")
            else -> colorTags.add("Natural Colors")
        }
        
        return colorTags
    }
    
    private fun calculateImageBrightness(bitmap: Bitmap): Float {
        val pixels = IntArray(bitmap.width * bitmap.height)
        bitmap.getPixels(pixels, 0, bitmap.width, 0, 0, bitmap.width, bitmap.height)
        
        var brightnessSum = 0
        for (pixel in pixels.take(1000)) { // Sample for performance
            val red = (pixel shr 16) and 0xFF
            val green = (pixel shr 8) and 0xFF
            val blue = pixel and 0xFF
            brightnessSum += (red + green + blue) / 3
        }
        
        return brightnessSum / 1000f / 255f
    }
    
    // Enhanced analysis classes and methods
    data class ImageFeatureAnalysis(
        val hasCircularPatterns: Boolean,
        val hasDigitalDisplay: Boolean,
        val hasNeedlePattern: Boolean,
        val hasAutomotiveColors: Boolean
    )
    
    data class ShapeAnalysis(
        val circularShapes: Int,
        val rectangularShapes: Int,
        val hasRadialPattern: Boolean
    )
    
    data class ContextAnalysis(
        val hasBacklighting: Boolean,
        val hasLEDCharacteristics: Boolean,
        val hasAutomotiveColorScheme: Boolean
    )
    
    private fun analyzeImageFeatures(bitmap: Bitmap): ImageFeatureAnalysis {
        // Simplified feature detection - in a real app, you'd use more sophisticated computer vision
        val pixels = IntArray(bitmap.width * bitmap.height)
        bitmap.getPixels(pixels, 0, bitmap.width, 0, 0, bitmap.width, bitmap.height)
        
        // Detect circular patterns by analyzing pixel distribution
        val hasCircular = detectCircularPatterns(pixels, bitmap.width, bitmap.height)
        
        // Detect digital display characteristics (high contrast, rectangular regions)
        val hasDigital = detectDigitalDisplay(pixels, bitmap.width, bitmap.height)
        
        // Detect needle-like patterns (thin lines radiating from center)
        val hasNeedle = detectNeedlePattern(pixels, bitmap.width, bitmap.height)
        
        // Detect automotive color schemes (blacks, grays, blues, oranges)
        val hasAutomotiveColors = detectAutomotiveColors(pixels)
        
        return ImageFeatureAnalysis(hasCircular, hasDigital, hasNeedle, hasAutomotiveColors)
    }
    
    private fun analyzeShapes(bitmap: Bitmap): ShapeAnalysis {
        // Simplified shape detection
        val pixels = IntArray(bitmap.width * bitmap.height)
        bitmap.getPixels(pixels, 0, bitmap.width, 0, 0, bitmap.width, bitmap.height)
        
        val circularCount = countCircularShapes(pixels, bitmap.width, bitmap.height)
        val rectangularCount = countRectangularShapes(pixels, bitmap.width, bitmap.height)
        val hasRadial = detectRadialPattern(pixels, bitmap.width, bitmap.height)
        
        return ShapeAnalysis(circularCount, rectangularCount, hasRadial)
    }
    
    private fun analyzeAdvancedContext(bitmap: Bitmap): ContextAnalysis {
        val pixels = IntArray(bitmap.width * bitmap.height)
        bitmap.getPixels(pixels, 0, bitmap.width, 0, 0, bitmap.width, bitmap.height)
        
        val hasBacklight = detectBacklighting(pixels)
        val hasLED = detectLEDCharacteristics(pixels)
        val hasAutomotiveScheme = detectAutomotiveColorScheme(pixels)
        
        return ContextAnalysis(hasBacklight, hasLED, hasAutomotiveScheme)
    }
    
    // Simplified detection methods (in production, use proper computer vision algorithms)
    private fun detectCircularPatterns(pixels: IntArray, width: Int, height: Int): Boolean {
        // Look for circular edge patterns - simplified heuristic
        val centerX = width / 2
        val centerY = height / 2
        var circularEdges = 0
        
        for (radius in 20..minOf(width, height) / 3 step 10) {
            var edgePoints = 0
            for (angle in 0..360 step 10) {
                val x = centerX + (radius * kotlin.math.cos(Math.toRadians(angle.toDouble()))).toInt()
                val y = centerY + (radius * kotlin.math.sin(Math.toRadians(angle.toDouble()))).toInt()
                
                if (x in 0 until width && y in 0 until height) {
                    val pixelIndex = y * width + x
                    if (pixelIndex < pixels.size) {
                        val brightness = getPixelBrightness(pixels[pixelIndex])
                        if (brightness > 150 || brightness < 50) { // Edge detection heuristic
                            edgePoints++
                        }
                    }
                }
            }
            if (edgePoints > 20) circularEdges++
        }
        
        return circularEdges > 0
    }
    
    private fun detectDigitalDisplay(pixels: IntArray, width: Int, height: Int): Boolean {
        // Look for high contrast rectangular regions
        var highContrastRegions = 0
        val blockSize = 20
        
        for (y in 0 until height - blockSize step blockSize) {
            for (x in 0 until width - blockSize step blockSize) {
                var minBrightness = 255
                var maxBrightness = 0
                
                for (dy in 0 until blockSize) {
                    for (dx in 0 until blockSize) {
                        val pixelIndex = (y + dy) * width + (x + dx)
                        if (pixelIndex < pixels.size) {
                            val brightness = getPixelBrightness(pixels[pixelIndex])
                            minBrightness = minOf(minBrightness, brightness)
                            maxBrightness = maxOf(maxBrightness, brightness)
                        }
                    }
                }
                
                if (maxBrightness - minBrightness > 100) {
                    highContrastRegions++
                }
            }
        }
        
        return highContrastRegions > 5
    }
    
    private fun detectNeedlePattern(pixels: IntArray, width: Int, height: Int): Boolean {
        // Look for thin lines radiating from center - simplified
        val centerX = width / 2
        val centerY = height / 2
        var radialLines = 0
        
        for (angle in 0..360 step 30) {
            var linePixels = 0
            for (distance in 10..minOf(width, height) / 3) {
                val x = centerX + (distance * kotlin.math.cos(Math.toRadians(angle.toDouble()))).toInt()
                val y = centerY + (distance * kotlin.math.sin(Math.toRadians(angle.toDouble()))).toInt()
                
                if (x in 0 until width && y in 0 until height) {
                    val pixelIndex = y * width + x
                    if (pixelIndex < pixels.size) {
                        val brightness = getPixelBrightness(pixels[pixelIndex])
                        if (brightness > 200) { // Bright line detection
                            linePixels++
                        }
                    }
                }
            }
            if (linePixels > 5) radialLines++
        }
        
        return radialLines > 0
    }
    
    private fun detectAutomotiveColors(pixels: IntArray): Boolean {
        var automotiveColorCount = 0
        
        pixels.take(1000).forEach { pixel ->
            val red = (pixel shr 16) and 0xFF
            val green = (pixel shr 8) and 0xFF
            val blue = pixel and 0xFF
            
            // Common automotive dashboard colors
            when {
                // Orange/amber (common for warning lights)
                red > 200 && green > 100 && green < 180 && blue < 50 -> automotiveColorCount++
                // Blue (common for dashboard lighting)
                blue > 150 && red < 100 && green < 150 -> automotiveColorCount++
                // Green (common for indicators)
                green > 150 && red < 100 && blue < 100 -> automotiveColorCount++
                // White/bright (digital displays)
                red > 200 && green > 200 && blue > 200 -> automotiveColorCount++
            }
        }
        
        return automotiveColorCount > 50
    }
    
    private fun getPixelBrightness(pixel: Int): Int {
        val red = (pixel shr 16) and 0xFF
        val green = (pixel shr 8) and 0xFF
        val blue = pixel and 0xFF
        return (red + green + blue) / 3
    }
    
    // Placeholder methods for shape detection
    private fun countCircularShapes(pixels: IntArray, width: Int, height: Int): Int = 1
    private fun countRectangularShapes(pixels: IntArray, width: Int, height: Int): Int = 2
    private fun detectRadialPattern(pixels: IntArray, width: Int, height: Int): Boolean = true
    private fun detectBacklighting(pixels: IntArray): Boolean = true
    private fun detectLEDCharacteristics(pixels: IntArray): Boolean = true
    private fun detectAutomotiveColorScheme(pixels: IntArray): Boolean = true
    
    private suspend fun detectAutomotiveElements(bitmap: Bitmap): List<ClassificationLabel> {
        val results = mutableListOf<ClassificationLabel>()
        
        // Analyze image for automotive-specific features
        val imageAnalysis = analyzeImageFeatures(bitmap)
        
        // Check for circular patterns (speedometer, gauges)
        if (imageAnalysis.hasCircularPatterns) {
            results.add(ClassificationLabel("Speedometer", 0.85f))
            results.add(ClassificationLabel("Dashboard", 0.8f))
            results.add(ClassificationLabel("Gauge", 0.75f))
            results.add(ClassificationLabel("Automotive", 0.9f))
        }
        
        // Check for digital displays
        if (imageAnalysis.hasDigitalDisplay) {
            results.add(ClassificationLabel("Digital Display", 0.8f))
            results.add(ClassificationLabel("Electronics", 0.7f))
            results.add(ClassificationLabel("Dashboard", 0.75f))
        }
        
        // Check for needle patterns
        if (imageAnalysis.hasNeedlePattern) {
            results.add(ClassificationLabel("Analog Gauge", 0.8f))
            results.add(ClassificationLabel("Meter", 0.75f))
            results.add(ClassificationLabel("Instrument", 0.7f))
        }
        
        // Check for automotive colors and materials
        if (imageAnalysis.hasAutomotiveColors) {
            results.add(ClassificationLabel("Vehicle Interior", 0.7f))
            results.add(ClassificationLabel("Dashboard", 0.65f))
        }
        
        return results
    }
    
    private suspend fun detectTextElements(bitmap: Bitmap): List<ClassificationLabel> {
        val results = mutableListOf<ClassificationLabel>()
        
        try {
            // Use ML Kit text recognition
            val image = InputImage.fromBitmap(bitmap, 0)
            val recognizer = com.google.mlkit.vision.text.TextRecognition.getClient(com.google.mlkit.vision.text.latin.TextRecognizerOptions.DEFAULT_OPTIONS)
            
            val text = suspendCancellableCoroutine<com.google.mlkit.vision.text.Text> { continuation ->
                recognizer.process(image)
                    .addOnSuccessListener { result ->
                        continuation.resume(result)
                    }
                    .addOnFailureListener { exception ->
                        continuation.resumeWithException(exception)
                    }
            }
            
            val detectedText = text.text.lowercase()
            
            // Analyze detected text for automotive terms
            when {
                detectedText.contains(Regex("\\d+\\s*(km/h|mph|kmh)")) -> {
                    results.add(ClassificationLabel("Speed Display", 0.9f))
                    results.add(ClassificationLabel("Speedometer", 0.85f))
                }
                detectedText.contains(Regex("\\d+\\s*(rpm)")) -> {
                    results.add(ClassificationLabel("Tachometer", 0.9f))
                    results.add(ClassificationLabel("RPM Gauge", 0.85f))
                }
                detectedText.contains(Regex("fuel|petrol|gas|tank")) -> {
                    results.add(ClassificationLabel("Fuel Gauge", 0.9f))
                    results.add(ClassificationLabel("Fuel Display", 0.85f))
                }
                detectedText.contains(Regex("\\d+\\s*(°c|°f|temp)")) -> {
                    results.add(ClassificationLabel("Temperature Gauge", 0.9f))
                }
                detectedText.contains(Regex("\\d+\\s*(km|miles|mi)")) -> {
                    results.add(ClassificationLabel("Odometer", 0.9f))
                    results.add(ClassificationLabel("Distance Display", 0.85f))
                }
                detectedText.contains(Regex("\\d+:\\d+|time")) -> {
                    results.add(ClassificationLabel("Clock", 0.8f))
                    results.add(ClassificationLabel("Time Display", 0.75f))
                }
            }
            
            // General automotive keywords
            val automotiveKeywords = listOf(
                "engine", "battery", "oil", "brake", "abs", "airbag", 
                "seatbelt", "door", "light", "signal", "warning"
            )
            
            automotiveKeywords.forEach { keyword ->
                if (detectedText.contains(keyword)) {
                    results.add(ClassificationLabel("Vehicle Warning", 0.7f))
                    results.add(ClassificationLabel("Dashboard", 0.65f))
                }
            }
            
        } catch (e: Exception) {
            // Text detection failed, continue with other methods
        }
        
        return results
    }
    
    private fun detectShapesAndPatterns(bitmap: Bitmap): List<ClassificationLabel> {
        val results = mutableListOf<ClassificationLabel>()
        
        // Analyze image for geometric patterns
        val shapeAnalysis = analyzeShapes(bitmap)
        
        if (shapeAnalysis.circularShapes > 0) {
            results.add(ClassificationLabel("Circular Display", 0.6f))
            if (shapeAnalysis.circularShapes > 1) {
                results.add(ClassificationLabel("Multiple Gauges", 0.7f))
            }
        }
        
        if (shapeAnalysis.rectangularShapes > 2) {
            results.add(ClassificationLabel("Digital Interface", 0.6f))
            results.add(ClassificationLabel("Display Panel", 0.65f))
        }
        
        if (shapeAnalysis.hasRadialPattern) {
            results.add(ClassificationLabel("Radial Gauge", 0.75f))
            results.add(ClassificationLabel("Analog Meter", 0.7f))
        }
        
        return results
    }
    
    private fun analyzeImageContext(bitmap: Bitmap): List<ClassificationLabel> {
        val results = mutableListOf<ClassificationLabel>()
        
        // Enhanced color and lighting analysis
        val contextAnalysis = analyzeAdvancedContext(bitmap)
        
        // Dashboard-specific lighting
        if (contextAnalysis.hasBacklighting) {
            results.add(ClassificationLabel("Backlit Display", 0.7f))
            results.add(ClassificationLabel("Dashboard", 0.65f))
        }
        
        // LED/LCD characteristics
        if (contextAnalysis.hasLEDCharacteristics) {
            results.add(ClassificationLabel("LED Display", 0.75f))
            results.add(ClassificationLabel("Digital Readout", 0.7f))
        }
        
        // Automotive color schemes
        if (contextAnalysis.hasAutomotiveColorScheme) {
            results.add(ClassificationLabel("Vehicle Interior", 0.6f))
            results.add(ClassificationLabel("Automotive", 0.55f))
        }
        
        return results
    }
    
    private fun enhanceAndFilterResults(results: List<ClassificationLabel>, bitmap: Bitmap): List<ClassificationLabel> {
        return results
            .groupBy { it.label }
            .map { (label, labels) ->
                ClassificationLabel(label, labels.maxOf { it.confidence })
            }
            .sortedByDescending { it.confidence }
            .take(10)
    }
    
    private fun preprocessImage(bitmap: Bitmap): TensorImage {
        val tensorImage = TensorImage.fromBitmap(bitmap)
        return imageProcessor?.process(tensorImage) ?: tensorImage
    }
    
    private fun runInference(tensorImage: TensorImage): FloatArray {
        val interpreter = this.interpreter
        return if (interpreter != null) {
            val inputBuffer = tensorImage.buffer
            val outputBuffer = FloatBuffer.allocate(labels.size)
            
            interpreter.run(inputBuffer, outputBuffer)
            
            outputBuffer.rewind()
            val predictions = FloatArray(labels.size)
            outputBuffer.get(predictions)
            predictions
        } else {
            // Return dummy predictions if model is not loaded
            FloatArray(labels.size) { if (it < 5) 0.1f + (it * 0.05f) else 0.01f }
        }
    }
    
    private fun postprocessResults(predictions: FloatArray): List<ClassificationLabel> {
        val results = mutableListOf<ClassificationLabel>()
        
        for (i in predictions.indices) {
            if (i < labels.size && predictions[i] > CONFIDENCE_THRESHOLD) {
                results.add(
                    ClassificationLabel(
                        label = labels[i],
                        confidence = predictions[i]
                    )
                )
            }
        }
        
        return results
            .sortedByDescending { it.confidence }
            .take(MAX_RESULTS)
    }
    
    private fun fallbackClassification(bitmap: Bitmap): ClassificationResult {
        // Simple fallback classification based on image properties
        val labels = mutableListOf<ClassificationLabel>()
        
        // Analyze image properties
        val width = bitmap.width
        val height = bitmap.height
        val aspectRatio = width.toFloat() / height.toFloat()
        
        // Basic heuristics
        when {
            aspectRatio > 1.5f -> {
                labels.add(ClassificationLabel("landscape", 0.7f))
                labels.add(ClassificationLabel("photo", 0.6f))
            }
            aspectRatio < 0.7f -> {
                labels.add(ClassificationLabel("portrait", 0.7f))
                labels.add(ClassificationLabel("photo", 0.6f))
            }
            else -> {
                labels.add(ClassificationLabel("image", 0.5f))
                labels.add(ClassificationLabel("photo", 0.4f))
            }
        }
        
        // Analyze color distribution (simplified)
        val hasColorVariety = analyzeColorDistribution(bitmap)
        if (hasColorVariety) {
            labels.add(ClassificationLabel("colorful", 0.6f))
        } else {
            labels.add(ClassificationLabel("monochrome", 0.6f))
        }
        
        return ClassificationResult(labels.take(MAX_RESULTS))
    }
    
    private fun analyzeColorDistribution(bitmap: Bitmap): Boolean {
        // Sample some pixels to determine color variety
        val sampleSize = 100
        val step = maxOf(1, (bitmap.width * bitmap.height) / sampleSize)
        
        val colors = mutableSetOf<Int>()
        var count = 0
        
        for (y in 0 until bitmap.height step maxOf(1, bitmap.height / 10)) {
            for (x in 0 until bitmap.width step maxOf(1, bitmap.width / 10)) {
                if (count++ >= sampleSize) break
                
                val pixel = bitmap.getPixel(x, y)
                val r = (pixel shr 16) and 0xFF
                val g = (pixel shr 8) and 0xFF
                val b = pixel and 0xFF
                
                // Quantize colors to reduce noise
                val quantizedColor = ((r / 32) shl 10) or ((g / 32) shl 5) or (b / 32)
                colors.add(quantizedColor)
            }
        }
        
        // Consider colorful if more than 10 distinct quantized colors
        return colors.size > 10
    }
    
    fun cleanup() {
        interpreter?.close()
    }
}