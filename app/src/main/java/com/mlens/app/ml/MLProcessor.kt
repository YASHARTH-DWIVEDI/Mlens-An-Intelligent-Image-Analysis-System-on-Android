package com.mlens.app.ml

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import com.mlens.app.utils.ImageUtils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.coroutines.CoroutineScope

class MLProcessor(private val context: Context) {
    
    private val textRecognitionProcessor = TextRecognitionProcessor()
    private val enhancedTextProcessor = EnhancedTextProcessor(context)
    private val imageClassificationProcessor = ImageClassificationProcessor(context)
    private val objectDetectionProcessor = ObjectDetectionProcessor(context)
    private val textSummarizer = TextSummarizer()
    
    data class MLResult(
        val isTextBased: Boolean,
        val extractedText: String?,
        val summary: String?,
        val tags: List<String>,
        val confidence: Float?,
        val detectedObjects: List<String> = emptyList(),
        val sceneDescription: String? = null,
        val language: String? = null,
        val processingMethod: String? = null,
        val naturalLanguageDescription: String? = null,
        val alternativeDescriptions: List<String> = emptyList(),
        val processingTime: Long = 0L
    )
    
    companion object {
        @Volatile
        private var isInitialized = false
        
        fun initialize(context: Context) {
            if (!isInitialized) {
                // Initialize ML models
                isInitialized = true
            }
        }
    }
    
    suspend fun processImage(imagePath: String): MLResult {
        return withContext(Dispatchers.IO) {
            try {
                val startTime = System.currentTimeMillis()
                val bitmap = BitmapFactory.decodeFile(imagePath)
                    ?: throw IllegalArgumentException("Cannot decode image at path: $imagePath")
                
                // Resize image for optimal processing
                val processedBitmap = ImageUtils.resizeForMLProcessing(bitmap)
                
                // Run BOTH OCR and Object Detection on EVERY image
                processImageComprehensively(processedBitmap, startTime)
                
            } catch (e: Exception) {
                android.util.Log.e("MLProcessor", "Error processing image", e)
                MLResult(
                    isTextBased = false,
                    extractedText = null,
                    summary = null,
                    tags = listOf("processing_error"),
                    confidence = 0.0f,
                    processingMethod = "error"
                )
            }
        }
    }
    
    private suspend fun processImageComprehensively(bitmap: Bitmap, startTime: Long): MLResult {
        android.util.Log.d("MLProcessor", "Starting Adaptive Processing Pipeline (Matching Report Fig 3.3)")

        return withContext(Dispatchers.IO) {
            // --- STEP 1: RAPID CLASSIFICATION (The "Router") ---
            // We run the lightweight classifier first to decide the path.
            val classificationResult = imageClassificationProcessor.classifyImage(bitmap)
            
            // Analyze top labels to determine content type
            val topLabels = classificationResult.labels.map { it.label.lowercase() }
            
            // Logic: If any top label matches a document keyword, we treat it as a Document
            val isDocument = topLabels.any { label -> 
                MLConstants.DOCUMENT_KEYWORDS.any { keyword -> label.contains(keyword) } 
            }

            // Initialize variables to hold results
            val detectedObjects = mutableListOf<String>()
            val allTags = mutableSetOf<String>()
            var extractedText: String? = null
            var summary: String? = null
            var sceneDescription: String? = null
            var finalConfidence = 0f

            // Add classification tags (visual context) to the tag list regardless of path
            allTags.addAll(classificationResult.labels.filter { it.confidence > MLConstants.MIN_CLASSIFICATION_CONFIDENCE }.map { it.label })

            // --- STEP 2: SELECTIVE ROUTING (The "Diamond" in Report Flowchart) ---
            
            if (isDocument) {
                // === ROUTE A: DOCUMENT PIPELINE ===
                android.util.Log.d("MLProcessor", "Route: DOCUMENT DETECTED. Executing OCR & Summarization.")
                
                // 1. Run Enhanced OCR
                val ocrResult = enhancedTextProcessor.recognizeTextEnhanced(bitmap)
                extractedText = cleanAndValidateOCRText(ocrResult.text)
                finalConfidence = ocrResult.confidence

                // 2. Run Summarization (Only if text is sufficient)
                // This restores the feature mentioned in your report
                if (extractedText.isNotEmpty() && extractedText.length > MLConstants.MIN_SUMMARY_TEXT_LENGTH) {
                     summary = textSummarizer.summarizeTextAdvanced(extractedText)
                }
                
                allTags.add("document")
                allTags.add("text_content")

            } else {
                // === ROUTE B: SCENE PIPELINE ===
                android.util.Log.d("MLProcessor", "Route: SCENE DETECTED. Executing Object Detection.")
                
                // 1. Run Object Detection
                val objectResult = objectDetectionProcessor.detectObjects(bitmap)
                finalConfidence = objectResult.overallConfidence
                
                // 2. Collect objects
                for (obj in objectResult.objects) {
                    obj.labels.maxByOrNull { it.confidence }?.let {
                        detectedObjects.add(it.text)
                        allTags.add(it.text)
                    }
                }
                
                // 3. Collect scene labels
                for (scene in objectResult.sceneLabels) {
                    allTags.add(scene.text)
                }
                
                // 4. Generate descriptive text (Captioning)
                sceneDescription = objectDetectionProcessor.generateDescriptiveText(objectResult)
            }

            val processingTime = System.currentTimeMillis() - startTime
            
            android.util.Log.d("MLProcessor", "Processing completed in ${processingTime}ms. Mode: ${if(isDocument) "Document" else "Scene"}")

            // Return the final result
            MLResult(
                isTextBased = isDocument,
                extractedText = extractedText,
                summary = summary,
                tags = allTags.toList().sorted(),
                confidence = finalConfidence,
                detectedObjects = detectedObjects,
                sceneDescription = sceneDescription,
                language = "en", 
                processingMethod = if (isDocument) "adaptive_document" else "adaptive_scene",
                processingTime = processingTime
            )
        }
    }
    
    // Helper methods for comprehensive processing
    
    private fun cleanAndValidateOCRText(rawText: String): String {
        val cleaned = rawText.trim()
        
        // Filter out watermarks and noise
        val lines = cleaned.lines().filter { line ->
            val trimmedLine = line.trim()
            when {
                trimmedLine.isEmpty() -> false
                trimmedLine.length <= 3 -> false // Too short
                trimmedLine.matches(Regex("^[©®™]+$")) -> false // Just symbols
                trimmedLine.lowercase().matches(Regex(".*(watermark|getty|shutterstock|stock photo).*")) -> false
                trimmedLine.matches(Regex("^www\\.|.*\\.(com|net|org)$")) -> false // URLs
                else -> true
            }
        }
        
        return lines.joinToString("\n").trim()
    }
    
    // Note: This method is now simplified since we don't run both pipelines
    // It's kept for potential future use but is no longer called in the adaptive pipeline
}