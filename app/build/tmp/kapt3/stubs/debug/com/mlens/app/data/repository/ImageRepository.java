package com.mlens.app.data.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001FB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J$\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\u000bH\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0012\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00190\u0018J\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001c\u001a\u00020\u000bH\u0086@\u00a2\u0006\u0002\u0010\u0012J\u000e\u0010\u001d\u001a\u00020\u001eH\u0086@\u00a2\u0006\u0002\u0010\u001fJ\u001a\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00190\u00182\u0006\u0010!\u001a\u00020\"J\u0010\u0010#\u001a\u0004\u0018\u00010\f2\u0006\u0010$\u001a\u00020\u000bJ\u000e\u0010%\u001a\u00020\u001eH\u0086@\u00a2\u0006\u0002\u0010\u001fJ\u000e\u0010&\u001a\u00020\u001eH\u0086@\u00a2\u0006\u0002\u0010\u001fJ,\u0010\'\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000e2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b,\u0010-J,\u0010.\u001a\b\u0012\u0004\u0012\u00020\f0\u000e2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b/\u0010-J\u001e\u00100\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u00101\u001a\u00020\u0014H\u0082@\u00a2\u0006\u0002\u00102J\u000e\u00103\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020\u000bJV\u00104\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u00101\u001a\u00020\u00142\u0006\u0010!\u001a\u00020\"2\b\u00105\u001a\u0004\u0018\u00010\u00142\b\u00106\u001a\u0004\u0018\u00010\u00142\f\u00107\u001a\b\u0012\u0004\u0012\u00020\u00140\u00192\u0006\u00108\u001a\u000209H\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b:\u0010;J\u0016\u0010<\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020\u000b2\u0006\u0010=\u001a\u00020\fJ\u001a\u0010>\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00190\u00182\u0006\u0010?\u001a\u00020\u0014J\"\u0010@\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00190\u00182\u0006\u0010?\u001a\u00020\u00142\u0006\u0010!\u001a\u00020\"JN\u0010A\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\"2\b\u00105\u001a\u0004\u0018\u00010\u00142\b\u00106\u001a\u0004\u0018\u00010\u00142\f\u00107\u001a\b\u0012\u0004\u0012\u00020\u00140\u0019H\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\bB\u0010CJ\f\u0010D\u001a\u00020\u001a*\u00020EH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006G"}, d2 = {"Lcom/mlens/app/data/repository/ImageRepository;", "", "imageDao", "Lcom/mlens/app/data/database/ImageDao;", "mlProcessor", "Lcom/mlens/app/ml/MLProcessor;", "(Lcom/mlens/app/data/database/ImageDao;Lcom/mlens/app/ml/MLProcessor;)V", "json", "Lkotlinx/serialization/json/Json;", "tempDataMap", "", "", "Lcom/mlens/app/data/repository/ImageRepository$ProcessedImageData;", "deleteImage", "Lkotlin/Result;", "", "imageId", "deleteImage-gIAlu-s", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "generateSearchKeywords", "", "mlResult", "Lcom/mlens/app/ml/MLProcessor$MLResult;", "getAllImages", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/mlens/app/data/database/ImageWithTags;", "getImageById", "id", "getImageCount", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getImagesByType", "isTextBased", "", "getTempProcessedData", "tempId", "getTextImageCount", "getVisualImageCount", "processAndSaveImage", "imageUri", "Landroid/net/Uri;", "context", "Landroid/content/Context;", "processAndSaveImage-0E7RQCE", "(Landroid/net/Uri;Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processImageForEditing", "processImageForEditing-0E7RQCE", "processImageWithML", "imagePath", "(JLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeTempProcessedData", "saveProcessedImage", "extractedText", "summary", "tags", "confidenceScore", "", "saveProcessedImage-bMdYcbs", "(Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/util/List;FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveTempProcessedData", "data", "searchImages", "query", "searchImagesByType", "updateExistingImage", "updateExistingImage-hUnOzRk", "(JZLjava/lang/String;Ljava/lang/String;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toImageWithTags", "Lcom/mlens/app/data/database/ImageEntity;", "ProcessedImageData", "app_debug"})
public final class ImageRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.mlens.app.data.database.ImageDao imageDao = null;
    @org.jetbrains.annotations.NotNull()
    private final com.mlens.app.ml.MLProcessor mlProcessor = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.serialization.json.Json json = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.Map<java.lang.Long, com.mlens.app.data.repository.ImageRepository.ProcessedImageData> tempDataMap = null;
    
    public ImageRepository(@org.jetbrains.annotations.NotNull()
    com.mlens.app.data.database.ImageDao imageDao, @org.jetbrains.annotations.NotNull()
    com.mlens.app.ml.MLProcessor mlProcessor) {
        super();
    }
    
    public final void saveTempProcessedData(long tempId, @org.jetbrains.annotations.NotNull()
    com.mlens.app.data.repository.ImageRepository.ProcessedImageData data) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.mlens.app.data.repository.ImageRepository.ProcessedImageData getTempProcessedData(long tempId) {
        return null;
    }
    
    public final void removeTempProcessedData(long tempId) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.mlens.app.data.database.ImageWithTags>> getAllImages() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.mlens.app.data.database.ImageWithTags>> getImagesByType(boolean isTextBased) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.mlens.app.data.database.ImageWithTags>> searchImages(@org.jetbrains.annotations.NotNull()
    java.lang.String query) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.mlens.app.data.database.ImageWithTags>> searchImagesByType(@org.jetbrains.annotations.NotNull()
    java.lang.String query, boolean isTextBased) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getImageById(long id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.mlens.app.data.database.ImageWithTags> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getImageCount(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getTextImageCount(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getVisualImageCount(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion) {
        return null;
    }
    
    private final java.lang.Object processImageWithML(long imageId, java.lang.String imagePath, kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    private final java.lang.String generateSearchKeywords(com.mlens.app.ml.MLProcessor.MLResult mlResult) {
        return null;
    }
    
    private final com.mlens.app.data.database.ImageWithTags toImageWithTags(com.mlens.app.data.database.ImageEntity $this$toImageWithTags) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\t\u00a2\u0006\u0002\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0013\u001a\u00020\u0005H\u00c6\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\tH\u00c6\u0003JE\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\tH\u00c6\u0001J\u0013\u0010\u0018\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001a\u001a\u00020\u001bH\u00d6\u0001J\t\u0010\u001c\u001a\u00020\u0003H\u00d6\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u001d"}, d2 = {"Lcom/mlens/app/data/repository/ImageRepository$ProcessedImageData;", "", "imagePath", "", "isTextBased", "", "extractedText", "summary", "tags", "", "(Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getExtractedText", "()Ljava/lang/String;", "getImagePath", "()Z", "getSummary", "getTags", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "app_debug"})
    public static final class ProcessedImageData {
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String imagePath = null;
        private final boolean isTextBased = false;
        @org.jetbrains.annotations.Nullable()
        private final java.lang.String extractedText = null;
        @org.jetbrains.annotations.Nullable()
        private final java.lang.String summary = null;
        @org.jetbrains.annotations.NotNull()
        private final java.util.List<java.lang.String> tags = null;
        
        public ProcessedImageData(@org.jetbrains.annotations.NotNull()
        java.lang.String imagePath, boolean isTextBased, @org.jetbrains.annotations.Nullable()
        java.lang.String extractedText, @org.jetbrains.annotations.Nullable()
        java.lang.String summary, @org.jetbrains.annotations.NotNull()
        java.util.List<java.lang.String> tags) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getImagePath() {
            return null;
        }
        
        public final boolean isTextBased() {
            return false;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getExtractedText() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getSummary() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<java.lang.String> getTags() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component1() {
            return null;
        }
        
        public final boolean component2() {
            return false;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String component3() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String component4() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<java.lang.String> component5() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.mlens.app.data.repository.ImageRepository.ProcessedImageData copy(@org.jetbrains.annotations.NotNull()
        java.lang.String imagePath, boolean isTextBased, @org.jetbrains.annotations.Nullable()
        java.lang.String extractedText, @org.jetbrains.annotations.Nullable()
        java.lang.String summary, @org.jetbrains.annotations.NotNull()
        java.util.List<java.lang.String> tags) {
            return null;
        }
        
        @java.lang.Override()
        public boolean equals(@org.jetbrains.annotations.Nullable()
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override()
        public int hashCode() {
            return 0;
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public java.lang.String toString() {
            return null;
        }
    }
}