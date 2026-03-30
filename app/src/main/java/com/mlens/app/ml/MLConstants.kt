package com.mlens.app.ml

/**
 * Centralized constants for ML processing
 * Makes it easier to tune and maintain ML parameters
 */
object MLConstants {
    // Confidence thresholds
    const val MIN_OCR_CONFIDENCE = 0.5f
    const val MIN_OBJECT_CONFIDENCE = 0.6f
    const val MIN_CLASSIFICATION_CONFIDENCE = 0.5f
    const val MIN_SCENE_CONFIDENCE = 0.5f
    const val HIGH_CONFIDENCE_THRESHOLD = 0.7f
    
    // Text processing
    const val MIN_SUMMARY_TEXT_LENGTH = 50
    const val MIN_VALID_TEXT_LENGTH = 5
    
    // Document detection keywords
    val DOCUMENT_KEYWORDS = listOf(
        "paper", "text", "document", "invoice", "receipt", 
        "letter", "menu", "page", "book", "writing"
    )
    
    // Image processing
    const val MAX_IMAGE_DIMENSION = 1024
    const val BITMAP_QUALITY = 90
    
    // Model parameters
    const val YOLO_INPUT_SIZE = 640
    const val YOLO_CONFIDENCE_THRESHOLD = 0.45f
    const val YOLO_IOU_THRESHOLD = 0.45f
}
