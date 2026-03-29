package com.mlens.app.data.database;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u0007\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\u00020\u0003H\u00a7@\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u00a7@\u00a2\u0006\u0002\u0010\bJ\u0016\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u00a7@\u00a2\u0006\u0002\u0010\fJ\u0014\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u000f0\u000eH\'J\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\u000bH\u00a7@\u00a2\u0006\u0002\u0010\fJ\u000e\u0010\u0011\u001a\u00020\u0012H\u00a7@\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0015H\u00a7@\u00a2\u0006\u0002\u0010\u0016J\u001c\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u000f0\u000e2\u0006\u0010\u0018\u001a\u00020\u0019H\'J\u001c\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u000f0\u000e2\u0006\u0010\u0014\u001a\u00020\u0015H\'J\u0016\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0007H\u00a7@\u00a2\u0006\u0002\u0010\bJ\u001c\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u000f0\u000e2\u0006\u0010\u001d\u001a\u00020\u0019H\'J$\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u000f0\u000e2\u0006\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u0014\u001a\u00020\u0015H\'J\u0016\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u00a7@\u00a2\u0006\u0002\u0010\bJ(\u0010 \u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010!\u001a\u00020\u000bH\u00a7@\u00a2\u0006\u0002\u0010\"JZ\u0010#\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\b\u0010$\u001a\u0004\u0018\u00010\u00192\b\u0010%\u001a\u0004\u0018\u00010\u00192\b\u0010&\u001a\u0004\u0018\u00010\u00192\b\u0010\'\u001a\u0004\u0018\u00010\u00192\b\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010!\u001a\u00020\u000bH\u00a7@\u00a2\u0006\u0002\u0010*\u00a8\u0006+"}, d2 = {"Lcom/mlens/app/data/database/ImageDao;", "", "deleteAllImages", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteImage", "image", "Lcom/mlens/app/data/database/ImageEntity;", "(Lcom/mlens/app/data/database/ImageEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteImageById", "id", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllImages", "Lkotlinx/coroutines/flow/Flow;", "", "getImageById", "getImageCount", "", "getImageCountByType", "isTextBased", "", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getImagesByStatus", "status", "", "getImagesByType", "insertImage", "searchImages", "query", "searchImagesByType", "updateImage", "updateProcessingStatus", "timestamp", "(JLjava/lang/String;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateWithMLResults", "extractedText", "summary", "tags", "searchKeywords", "confidenceScore", "", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/String;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
@androidx.room.Dao()
public abstract interface ImageDao {
    
    @androidx.room.Query(value = "SELECT * FROM images ORDER BY created_at DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.mlens.app.data.database.ImageEntity>> getAllImages();
    
    @androidx.room.Query(value = "SELECT * FROM images WHERE id = :id")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getImageById(long id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.mlens.app.data.database.ImageEntity> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM images WHERE is_text_based = :isTextBased ORDER BY created_at DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.mlens.app.data.database.ImageEntity>> getImagesByType(boolean isTextBased);
    
    @androidx.room.Query(value = "\n        SELECT * FROM images \n        WHERE search_keywords LIKE \'%\' || :query || \'%\' \n        OR summary LIKE \'%\' || :query || \'%\' \n        OR tags LIKE \'%\' || :query || \'%\'\n        OR extracted_text LIKE \'%\' || :query || \'%\'\n        ORDER BY created_at DESC\n    ")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.mlens.app.data.database.ImageEntity>> searchImages(@org.jetbrains.annotations.NotNull()
    java.lang.String query);
    
    @androidx.room.Query(value = "\n        SELECT * FROM images \n        WHERE is_text_based = :isTextBased \n        AND (search_keywords LIKE \'%\' || :query || \'%\' \n        OR summary LIKE \'%\' || :query || \'%\' \n        OR tags LIKE \'%\' || :query || \'%\'\n        OR extracted_text LIKE \'%\' || :query || \'%\')\n        ORDER BY created_at DESC\n    ")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.mlens.app.data.database.ImageEntity>> searchImagesByType(@org.jetbrains.annotations.NotNull()
    java.lang.String query, boolean isTextBased);
    
    @androidx.room.Query(value = "SELECT * FROM images WHERE processing_status = :status ORDER BY created_at DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.mlens.app.data.database.ImageEntity>> getImagesByStatus(@org.jetbrains.annotations.NotNull()
    java.lang.String status);
    
    @androidx.room.Query(value = "SELECT COUNT(*) FROM images")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getImageCount(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion);
    
    @androidx.room.Query(value = "SELECT COUNT(*) FROM images WHERE is_text_based = :isTextBased")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getImageCountByType(boolean isTextBased, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertImage(@org.jetbrains.annotations.NotNull()
    com.mlens.app.data.database.ImageEntity image, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion);
    
    @androidx.room.Update()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateImage(@org.jetbrains.annotations.NotNull()
    com.mlens.app.data.database.ImageEntity image, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Delete()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteImage(@org.jetbrains.annotations.NotNull()
    com.mlens.app.data.database.ImageEntity image, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM images WHERE id = :id")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteImageById(long id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM images")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteAllImages(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "UPDATE images SET processing_status = :status, updated_at = :timestamp WHERE id = :id")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateProcessingStatus(long id, @org.jetbrains.annotations.NotNull()
    java.lang.String status, long timestamp, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "\n        UPDATE images \n        SET extracted_text = :extractedText, \n            summary = :summary, \n            tags = :tags, \n            search_keywords = :searchKeywords,\n            confidence_score = :confidenceScore,\n            processing_status = :status,\n            updated_at = :timestamp\n        WHERE id = :id\n    ")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateWithMLResults(long id, @org.jetbrains.annotations.Nullable()
    java.lang.String extractedText, @org.jetbrains.annotations.Nullable()
    java.lang.String summary, @org.jetbrains.annotations.Nullable()
    java.lang.String tags, @org.jetbrains.annotations.Nullable()
    java.lang.String searchKeywords, @org.jetbrains.annotations.Nullable()
    java.lang.Float confidenceScore, @org.jetbrains.annotations.NotNull()
    java.lang.String status, long timestamp, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 3, xi = 48)
    public static final class DefaultImpls {
    }
}