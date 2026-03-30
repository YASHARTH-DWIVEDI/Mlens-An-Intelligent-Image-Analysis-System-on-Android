package com.mlens.app.data.database

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface ImageDao {
    
    @Query("SELECT * FROM images ORDER BY created_at DESC")
    fun getAllImages(): Flow<List<ImageEntity>>
    
    @Query("SELECT * FROM images WHERE id = :id")
    suspend fun getImageById(id: Long): ImageEntity?
    
    @Query("SELECT * FROM images WHERE is_text_based = :isTextBased ORDER BY created_at DESC")
    fun getImagesByType(isTextBased: Boolean): Flow<List<ImageEntity>>
    
    @Query("""
        SELECT * FROM images 
        WHERE search_keywords LIKE '%' || :query || '%' 
        OR summary LIKE '%' || :query || '%' 
        OR tags LIKE '%' || :query || '%'
        OR extracted_text LIKE '%' || :query || '%'
        ORDER BY created_at DESC
    """)
    fun searchImages(query: String): Flow<List<ImageEntity>>
    
    @Query("""
        SELECT * FROM images 
        WHERE is_text_based = :isTextBased 
        AND (search_keywords LIKE '%' || :query || '%' 
        OR summary LIKE '%' || :query || '%' 
        OR tags LIKE '%' || :query || '%'
        OR extracted_text LIKE '%' || :query || '%')
        ORDER BY created_at DESC
    """)
    fun searchImagesByType(query: String, isTextBased: Boolean): Flow<List<ImageEntity>>
    
    @Query("SELECT * FROM images WHERE processing_status = :status ORDER BY created_at DESC")
    fun getImagesByStatus(status: String): Flow<List<ImageEntity>>
    
    @Query("SELECT COUNT(*) FROM images")
    suspend fun getImageCount(): Int
    
    @Query("SELECT COUNT(*) FROM images WHERE is_text_based = :isTextBased")
    suspend fun getImageCountByType(isTextBased: Boolean): Int
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertImage(image: ImageEntity): Long
    
    @Update
    suspend fun updateImage(image: ImageEntity)
    
    @Delete
    suspend fun deleteImage(image: ImageEntity)
    
    @Query("DELETE FROM images WHERE id = :id")
    suspend fun deleteImageById(id: Long)
    
    @Query("DELETE FROM images")
    suspend fun deleteAllImages()
    
    // Update processing status
    @Query("UPDATE images SET processing_status = :status, updated_at = :timestamp WHERE id = :id")
    suspend fun updateProcessingStatus(id: Long, status: String, timestamp: Long = System.currentTimeMillis())
    
    // Update with ML results
    @Query("""
        UPDATE images 
        SET extracted_text = :extractedText, 
            summary = :summary, 
            tags = :tags, 
            search_keywords = :searchKeywords,
            confidence_score = :confidenceScore,
            processing_status = :status,
            updated_at = :timestamp
        WHERE id = :id
    """)
    suspend fun updateWithMLResults(
        id: Long,
        extractedText: String?,
        summary: String?,
        tags: String?,
        searchKeywords: String?,
        confidenceScore: Float?,
        status: String,
        timestamp: Long = System.currentTimeMillis()
    )
}