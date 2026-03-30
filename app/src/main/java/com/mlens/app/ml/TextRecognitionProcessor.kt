package com.mlens.app.ml

import android.graphics.Bitmap
import com.google.mlkit.vision.common.InputImage
import com.google.mlkit.vision.text.TextRecognition
import com.google.mlkit.vision.text.latin.TextRecognizerOptions
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

class TextRecognitionProcessor {
    
    private val recognizer = TextRecognition.getClient(TextRecognizerOptions.DEFAULT_OPTIONS)
    
    data class OCRResult(
        val text: String,
        val confidence: Float,
        val blocks: List<TextBlock>
    )
    
    data class TextBlock(
        val text: String,
        val boundingBox: android.graphics.Rect?,
        val confidence: Float
    )
    
    suspend fun recognizeText(bitmap: Bitmap): OCRResult {
        return suspendCoroutine { continuation ->
            try {
                val image = InputImage.fromBitmap(bitmap, 0)
                
                recognizer.process(image)
                    .addOnSuccessListener { visionText ->
                        val blocks = mutableListOf<TextBlock>()
                        var totalConfidence = 0f
                        var blockCount = 0
                        
                        for (block in visionText.textBlocks) {
                            blocks.add(
                                TextBlock(
                                    text = block.text,
                                    boundingBox = block.boundingBox,
                                    confidence = calculateBlockConfidence(block)
                                )
                            )
                            totalConfidence += calculateBlockConfidence(block)
                            blockCount++
                        }
                        
                        val averageConfidence = if (blockCount > 0) totalConfidence / blockCount else 0f
                        
                        val result = OCRResult(
                            text = visionText.text,
                            confidence = averageConfidence,
                            blocks = blocks
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
    
    private fun calculateBlockConfidence(block: com.google.mlkit.vision.text.Text.TextBlock): Float {
        // ML Kit doesn't provide confidence scores directly
        // We calculate a heuristic confidence based on:
        // 1. Text length
        // 2. Number of recognized characters vs special characters
        // 3. Presence of dictionary words (simplified)
        
        val text = block.text
        if (text.isEmpty()) return 0f
        
        var confidence = 0.5f // Base confidence
        
        // Bonus for longer text (more context)
        if (text.length > 10) confidence += 0.1f
        if (text.length > 30) confidence += 0.1f
        
        // Bonus for alphanumeric content
        val alphanumericRatio = text.count { it.isLetterOrDigit() }.toFloat() / text.length
        confidence += alphanumericRatio * 0.3f
        
        // Bonus for proper spacing and formatting
        if (text.contains(" ") && !text.contains("  ")) confidence += 0.1f
        
        // Penalty for too many special characters
        val specialCharRatio = text.count { !it.isLetterOrDigit() && !it.isWhitespace() }.toFloat() / text.length
        if (specialCharRatio > 0.3f) confidence -= 0.2f
        
        return confidence.coerceIn(0f, 1f)
    }
    
    fun cleanup() {
        recognizer.close()
    }
}