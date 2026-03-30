package com.mlens.app.ml

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.ColorMatrix
import android.graphics.ColorMatrixColorFilter
import android.graphics.Paint
import com.google.mlkit.vision.common.InputImage
import com.google.mlkit.vision.text.TextRecognition
import com.google.mlkit.vision.text.latin.TextRecognizerOptions
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

class EnhancedTextProcessor(private val context: Context) {
    
    private val latinRecognizer = TextRecognition.getClient(TextRecognizerOptions.DEFAULT_OPTIONS)
    // Using only Latin text recognizer for optimized size
    
    data class EnhancedOCRResult(
        val text: String,
        val confidence: Float,
        val language: String,
        val blocks: List<TextBlock>,
        val preprocessingApplied: List<String>
    )
    
    data class TextBlock(
        val text: String,
        val boundingBox: android.graphics.Rect?,
        val confidence: Float,
        val language: String?
    )
    
    suspend fun recognizeTextEnhanced(bitmap: Bitmap): EnhancedOCRResult {
        val preprocessingSteps = mutableListOf<String>()
        
        // Apply multiple preprocessing techniques
        val preprocessedImages = mutableListOf<Pair<Bitmap, String>>()
        
        // Original image
        preprocessedImages.add(bitmap to "original")
        
        // High contrast version
        val highContrast = enhanceContrast(bitmap, 1.5f)
        preprocessedImages.add(highContrast to "high_contrast")
        preprocessingSteps.add("high_contrast")
        
        // Grayscale with enhanced brightness
        val grayscale = convertToOptimalGrayscale(bitmap)
        preprocessedImages.add(grayscale to "grayscale")
        preprocessingSteps.add("grayscale")
        
        // Sharpened version
        val sharpened = sharpenImage(bitmap)
        preprocessedImages.add(sharpened to "sharpened")
        preprocessingSteps.add("sharpened")
        
        // Noise reduced version
        val denoised = reduceNoise(bitmap)
        preprocessedImages.add(denoised to "denoised")
        preprocessingSteps.add("denoised")
        
        // Try recognition with Latin recognizer and multiple preprocessing
        val allResults = mutableListOf<EnhancedOCRResult>()
        
        for ((processedBitmap, processingType) in preprocessedImages) {
            try {
                val result = recognizeWithSpecificRecognizer(processedBitmap, latinRecognizer, "latin")
                if (result.text.isNotBlank() && result.confidence > 0.3f) {
                    allResults.add(result.copy(
                        preprocessingApplied = listOf(processingType)
                    ))
                }
            } catch (e: Exception) {
                // Continue with next preprocessing
            }
        }
        
        // Select best result based on confidence and text length
        val bestResult = allResults.maxByOrNull { 
            it.confidence * 0.7f + (it.text.length / 100f) * 0.3f 
        }
        
        return bestResult ?: EnhancedOCRResult(
            text = "",
            confidence = 0f,
            language = "unknown",
            blocks = emptyList(),
            preprocessingApplied = preprocessingSteps
        )
    }
    
    private suspend fun recognizeWithSpecificRecognizer(
        bitmap: Bitmap, 
        recognizer: com.google.mlkit.vision.text.TextRecognizer,
        language: String
    ): EnhancedOCRResult {
        return suspendCoroutine { continuation ->
            try {
                val image = InputImage.fromBitmap(bitmap, 0)
                
                recognizer.process(image)
                    .addOnSuccessListener { visionText ->
                        val blocks = mutableListOf<TextBlock>()
                        var totalConfidence = 0f
                        var blockCount = 0
                        
                        for (block in visionText.textBlocks) {
                            val blockConfidence = calculateAdvancedBlockConfidence(block, language)
                            blocks.add(
                                TextBlock(
                                    text = block.text,
                                    boundingBox = block.boundingBox,
                                    confidence = blockConfidence,
                                    language = language
                                )
                            )
                            totalConfidence += blockConfidence
                            blockCount++
                        }
                        
                        val averageConfidence = if (blockCount > 0) totalConfidence / blockCount else 0f
                        
                        val result = EnhancedOCRResult(
                            text = visionText.text,
                            confidence = averageConfidence,
                            language = language,
                            blocks = blocks,
                            preprocessingApplied = emptyList()
                        )
                        
                        continuation.resume(result)
                    }
                    .addOnFailureListener { exception ->
                        continuation.resumeWithException(exception)
                    }
            } catch (e: Exception) {
                continuation.resumeWithException(e)
            }
        }
    }
    
    private fun enhanceContrast(bitmap: Bitmap, factor: Float): Bitmap {
        val enhanced = Bitmap.createBitmap(bitmap.width, bitmap.height, bitmap.config ?: Bitmap.Config.ARGB_8888)
        val canvas = Canvas(enhanced)
        val paint = Paint()
        
        val colorMatrix = ColorMatrix()
        colorMatrix.set(floatArrayOf(
            factor, 0f, 0f, 0f, 0f,
            0f, factor, 0f, 0f, 0f,
            0f, 0f, factor, 0f, 0f,
            0f, 0f, 0f, 1f, 0f
        ))
        
        paint.colorFilter = ColorMatrixColorFilter(colorMatrix)
        canvas.drawBitmap(bitmap, 0f, 0f, paint)
        
        return enhanced
    }
    
    private fun convertToOptimalGrayscale(bitmap: Bitmap): Bitmap {
        val grayscale = Bitmap.createBitmap(bitmap.width, bitmap.height, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(grayscale)
        val paint = Paint()
        
        // Optimized grayscale conversion for text recognition
        val colorMatrix = ColorMatrix()
        colorMatrix.setSaturation(0f)
        
        // Enhance brightness for better text recognition
        val brightnessMatrix = ColorMatrix()
        brightnessMatrix.set(floatArrayOf(
            1.2f, 0f, 0f, 0f, 30f,
            0f, 1.2f, 0f, 0f, 30f,
            0f, 0f, 1.2f, 0f, 30f,
            0f, 0f, 0f, 1f, 0f
        ))
        
        colorMatrix.postConcat(brightnessMatrix)
        paint.colorFilter = ColorMatrixColorFilter(colorMatrix)
        canvas.drawBitmap(bitmap, 0f, 0f, paint)
        
        return grayscale
    }
    
    private fun sharpenImage(bitmap: Bitmap): Bitmap {
        val sharpened = bitmap.copy(bitmap.config ?: Bitmap.Config.ARGB_8888, true)
        val pixels = IntArray(sharpened.width * sharpened.height)
        sharpened.getPixels(pixels, 0, sharpened.width, 0, 0, sharpened.width, sharpened.height)
        
        // Simple sharpening kernel
        val width = sharpened.width
        val height = sharpened.height
        val newPixels = pixels.clone()
        
        for (y in 1 until height - 1) {
            for (x in 1 until width - 1) {
                val index = y * width + x
                val pixel = pixels[index]
                
                // Apply sharpening kernel
                val red = (pixel shr 16) and 0xFF
                val green = (pixel shr 8) and 0xFF
                val blue = pixel and 0xFF
                
                // Simple edge enhancement
                val newRed = minOf(255, maxOf(0, red + (red - ((pixels[index - 1] shr 16) and 0xFF)) / 4))
                val newGreen = minOf(255, maxOf(0, green + (green - ((pixels[index - 1] shr 8) and 0xFF)) / 4))
                val newBlue = minOf(255, maxOf(0, blue + (blue - (pixels[index - 1] and 0xFF)) / 4))
                
                newPixels[index] = (0xFF shl 24) or (newRed shl 16) or (newGreen shl 8) or newBlue
            }
        }
        
        sharpened.setPixels(newPixels, 0, width, 0, 0, width, height)
        return sharpened
    }
    
    private fun reduceNoise(bitmap: Bitmap): Bitmap {
        val denoised = bitmap.copy(bitmap.config ?: Bitmap.Config.ARGB_8888, true)
        val pixels = IntArray(denoised.width * denoised.height)
        denoised.getPixels(pixels, 0, denoised.width, 0, 0, denoised.width, denoised.height)
        
        // Simple median filter for noise reduction
        val width = denoised.width
        val height = denoised.height
        val newPixels = pixels.clone()
        
        for (y in 1 until height - 1) {
            for (x in 1 until width - 1) {
                val neighbors = mutableListOf<Int>()
                for (dy in -1..1) {
                    for (dx in -1..1) {
                        neighbors.add(pixels[(y + dy) * width + (x + dx)])
                    }
                }
                neighbors.sort()
                newPixels[y * width + x] = neighbors[4] // Median value
            }
        }
        
        denoised.setPixels(newPixels, 0, width, 0, 0, width, height)
        return denoised
    }
    
    private fun calculateAdvancedBlockConfidence(
        block: com.google.mlkit.vision.text.Text.TextBlock,
        language: String
    ): Float {
        val text = block.text
        if (text.isEmpty()) return 0f
        
        var confidence = 0.5f // Base confidence
        
        // Language-specific confidence adjustments
        when (language) {
            "latin" -> {
                // Bonus for common English patterns
                if (text.matches(Regex(".*[a-zA-Z].*"))) confidence += 0.2f
                if (text.contains(" ")) confidence += 0.1f
            }
            "chinese" -> {
                // Bonus for Chinese characters
                if (text.matches(Regex(".*[\\u4e00-\\u9fff].*"))) confidence += 0.3f
            }
            "japanese" -> {
                // Bonus for Japanese characters (Hiragana, Katakana, Kanji)
                if (text.matches(Regex(".*[\\u3040-\\u309f\\u30a0-\\u30ff\\u4e00-\\u9fff].*"))) confidence += 0.3f
            }
            "korean" -> {
                // Bonus for Korean characters
                if (text.matches(Regex(".*[\\uac00-\\ud7af].*"))) confidence += 0.3f
            }
        }
        
        // General quality indicators
        if (text.length > 10) confidence += 0.1f
        if (text.length > 30) confidence += 0.1f
        
        // Alphanumeric content ratio
        val alphanumericRatio = text.count { it.isLetterOrDigit() }.toFloat() / text.length
        confidence += alphanumericRatio * 0.2f
        
        // Proper spacing
        if (text.contains(" ") && !text.contains("  ")) confidence += 0.1f
        
        // Penalty for excessive special characters
        val specialCharRatio = text.count { !it.isLetterOrDigit() && !it.isWhitespace() }.toFloat() / text.length
        if (specialCharRatio > 0.3f) confidence -= 0.2f
        
        return confidence.coerceIn(0f, 1f)
    }
    
    fun cleanup() {
        latinRecognizer.close()
    }
}