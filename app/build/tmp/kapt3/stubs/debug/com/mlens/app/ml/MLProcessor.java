package com.mlens.app.ml;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u0000 \u001c2\u00020\u0001:\u0002\u001c\u001dB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0010H\u0086@\u00a2\u0006\u0002\u0010\u0015J\u001e\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0082@\u00a2\u0006\u0002\u0010\u001bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001e"}, d2 = {"Lcom/mlens/app/ml/MLProcessor;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "enhancedTextProcessor", "Lcom/mlens/app/ml/EnhancedTextProcessor;", "imageClassificationProcessor", "Lcom/mlens/app/ml/ImageClassificationProcessor;", "objectDetectionProcessor", "Lcom/mlens/app/ml/ObjectDetectionProcessor;", "textRecognitionProcessor", "Lcom/mlens/app/ml/TextRecognitionProcessor;", "textSummarizer", "Lcom/mlens/app/ml/TextSummarizer;", "cleanAndValidateOCRText", "", "rawText", "processImage", "Lcom/mlens/app/ml/MLProcessor$MLResult;", "imagePath", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processImageComprehensively", "bitmap", "Landroid/graphics/Bitmap;", "startTime", "", "(Landroid/graphics/Bitmap;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "MLResult", "app_debug"})
public final class MLProcessor {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private final com.mlens.app.ml.TextRecognitionProcessor textRecognitionProcessor = null;
    @org.jetbrains.annotations.NotNull()
    private final com.mlens.app.ml.EnhancedTextProcessor enhancedTextProcessor = null;
    @org.jetbrains.annotations.NotNull()
    private final com.mlens.app.ml.ImageClassificationProcessor imageClassificationProcessor = null;
    @org.jetbrains.annotations.NotNull()
    private final com.mlens.app.ml.ObjectDetectionProcessor objectDetectionProcessor = null;
    @org.jetbrains.annotations.NotNull()
    private final com.mlens.app.ml.TextSummarizer textSummarizer = null;
    @kotlin.jvm.Volatile()
    private static volatile boolean isInitialized = false;
    @org.jetbrains.annotations.NotNull()
    public static final com.mlens.app.ml.MLProcessor.Companion Companion = null;
    
    public MLProcessor(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object processImage(@org.jetbrains.annotations.NotNull()
    java.lang.String imagePath, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.mlens.app.ml.MLProcessor.MLResult> $completion) {
        return null;
    }
    
    private final java.lang.Object processImageComprehensively(android.graphics.Bitmap bitmap, long startTime, kotlin.coroutines.Continuation<? super com.mlens.app.ml.MLProcessor.MLResult> $completion) {
        return null;
    }
    
    private final java.lang.String cleanAndValidateOCRText(java.lang.String rawText) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/mlens/app/ml/MLProcessor$Companion;", "", "()V", "isInitialized", "", "initialize", "", "context", "Landroid/content/Context;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        public final void initialize(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b#\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0093\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\b\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u00a2\u0006\u0002\u0010\u0013J\t\u0010%\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000f\u0010\'\u001a\b\u0012\u0004\u0012\u00020\u00050\bH\u00c6\u0003J\t\u0010(\u001a\u00020\u0012H\u00c6\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00050\bH\u00c6\u0003J\u0010\u0010,\u001a\u0004\u0018\u00010\nH\u00c6\u0003\u00a2\u0006\u0002\u0010\u0017J\u000f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00050\bH\u00c6\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u00a6\u0001\u00101\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\b2\b\b\u0002\u0010\u0011\u001a\u00020\u0012H\u00c6\u0001\u00a2\u0006\u0002\u00102J\u0013\u00103\u001a\u00020\u00032\b\u00104\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u00105\u001a\u000206H\u00d6\u0001J\t\u00107\u001a\u00020\u0005H\u00d6\u0001R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0015\u0010\t\u001a\u0004\u0018\u00010\n\u00a2\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u001cR\u0013\u0010\r\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001bR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001bR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001bR\u0011\u0010\u0011\u001a\u00020\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001bR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\b\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0015\u00a8\u00068"}, d2 = {"Lcom/mlens/app/ml/MLProcessor$MLResult;", "", "isTextBased", "", "extractedText", "", "summary", "tags", "", "confidence", "", "detectedObjects", "sceneDescription", "language", "processingMethod", "naturalLanguageDescription", "alternativeDescriptions", "processingTime", "", "(ZLjava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/Float;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;J)V", "getAlternativeDescriptions", "()Ljava/util/List;", "getConfidence", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getDetectedObjects", "getExtractedText", "()Ljava/lang/String;", "()Z", "getLanguage", "getNaturalLanguageDescription", "getProcessingMethod", "getProcessingTime", "()J", "getSceneDescription", "getSummary", "getTags", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(ZLjava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/Float;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;J)Lcom/mlens/app/ml/MLProcessor$MLResult;", "equals", "other", "hashCode", "", "toString", "app_debug"})
    public static final class MLResult {
        private final boolean isTextBased = false;
        @org.jetbrains.annotations.Nullable()
        private final java.lang.String extractedText = null;
        @org.jetbrains.annotations.Nullable()
        private final java.lang.String summary = null;
        @org.jetbrains.annotations.NotNull()
        private final java.util.List<java.lang.String> tags = null;
        @org.jetbrains.annotations.Nullable()
        private final java.lang.Float confidence = null;
        @org.jetbrains.annotations.NotNull()
        private final java.util.List<java.lang.String> detectedObjects = null;
        @org.jetbrains.annotations.Nullable()
        private final java.lang.String sceneDescription = null;
        @org.jetbrains.annotations.Nullable()
        private final java.lang.String language = null;
        @org.jetbrains.annotations.Nullable()
        private final java.lang.String processingMethod = null;
        @org.jetbrains.annotations.Nullable()
        private final java.lang.String naturalLanguageDescription = null;
        @org.jetbrains.annotations.NotNull()
        private final java.util.List<java.lang.String> alternativeDescriptions = null;
        private final long processingTime = 0L;
        
        public MLResult(boolean isTextBased, @org.jetbrains.annotations.Nullable()
        java.lang.String extractedText, @org.jetbrains.annotations.Nullable()
        java.lang.String summary, @org.jetbrains.annotations.NotNull()
        java.util.List<java.lang.String> tags, @org.jetbrains.annotations.Nullable()
        java.lang.Float confidence, @org.jetbrains.annotations.NotNull()
        java.util.List<java.lang.String> detectedObjects, @org.jetbrains.annotations.Nullable()
        java.lang.String sceneDescription, @org.jetbrains.annotations.Nullable()
        java.lang.String language, @org.jetbrains.annotations.Nullable()
        java.lang.String processingMethod, @org.jetbrains.annotations.Nullable()
        java.lang.String naturalLanguageDescription, @org.jetbrains.annotations.NotNull()
        java.util.List<java.lang.String> alternativeDescriptions, long processingTime) {
            super();
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
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Float getConfidence() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<java.lang.String> getDetectedObjects() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getSceneDescription() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getLanguage() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getProcessingMethod() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getNaturalLanguageDescription() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<java.lang.String> getAlternativeDescriptions() {
            return null;
        }
        
        public final long getProcessingTime() {
            return 0L;
        }
        
        public final boolean component1() {
            return false;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String component10() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<java.lang.String> component11() {
            return null;
        }
        
        public final long component12() {
            return 0L;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String component2() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String component3() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<java.lang.String> component4() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Float component5() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<java.lang.String> component6() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String component7() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String component8() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String component9() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.mlens.app.ml.MLProcessor.MLResult copy(boolean isTextBased, @org.jetbrains.annotations.Nullable()
        java.lang.String extractedText, @org.jetbrains.annotations.Nullable()
        java.lang.String summary, @org.jetbrains.annotations.NotNull()
        java.util.List<java.lang.String> tags, @org.jetbrains.annotations.Nullable()
        java.lang.Float confidence, @org.jetbrains.annotations.NotNull()
        java.util.List<java.lang.String> detectedObjects, @org.jetbrains.annotations.Nullable()
        java.lang.String sceneDescription, @org.jetbrains.annotations.Nullable()
        java.lang.String language, @org.jetbrains.annotations.Nullable()
        java.lang.String processingMethod, @org.jetbrains.annotations.Nullable()
        java.lang.String naturalLanguageDescription, @org.jetbrains.annotations.NotNull()
        java.util.List<java.lang.String> alternativeDescriptions, long processingTime) {
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