package com.mlens.app.data.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "images",
    indices = [
        Index(value = ["is_text_based"]),
        Index(value = ["created_at"]),
        Index(value = ["processing_status"])
    ]
)
data class ImageEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    
    @ColumnInfo(name = "file_path")
    val filePath: String,
    
    @ColumnInfo(name = "is_text_based")
    val isTextBased: Boolean,
    
    @ColumnInfo(name = "extracted_text")
    val extractedText: String?,
    
    @ColumnInfo(name = "summary")
    val summary: String?,
    
    @ColumnInfo(name = "tags")
    val tags: String?, // JSON string of tags list
    
    @ColumnInfo(name = "search_keywords")
    val searchKeywords: String?, // Processed keywords for search
    
    @ColumnInfo(name = "confidence_score")
    val confidenceScore: Float?,
    
    @ColumnInfo(name = "processing_status")
    val processingStatus: String, // "processing", "completed", "error"
    
    @ColumnInfo(name = "created_at")
    val createdAt: Long = System.currentTimeMillis(),
    
    @ColumnInfo(name = "updated_at")
    val updatedAt: Long = System.currentTimeMillis()
)

// Data class for image with tags list (for UI)
data class ImageWithTags(
    val id: Long,
    val filePath: String,
    val isTextBased: Boolean,
    val extractedText: String?,
    val summary: String?,
    val tags: List<String>,
    val searchKeywords: String?,
    val confidenceScore: Float?,
    val processingStatus: String,
    val createdAt: Long,
    val updatedAt: Long
)