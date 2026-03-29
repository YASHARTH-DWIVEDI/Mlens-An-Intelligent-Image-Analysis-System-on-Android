package com.mlens.app.ml;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0002\u001c\u001dB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0006\u0010\r\u001a\u00020\u000eJ\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0018\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\bH\u0002J\u0016\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\u0010H\u0086@\u00a2\u0006\u0002\u0010\u0016J&\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0082@\u00a2\u0006\u0002\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0010\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001e"}, d2 = {"Lcom/mlens/app/ml/EnhancedTextProcessor;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "latinRecognizer", "Lcom/google/mlkit/vision/text/TextRecognizer;", "calculateAdvancedBlockConfidence", "", "block", "Lcom/google/mlkit/vision/text/Text$TextBlock;", "language", "", "cleanup", "", "convertToOptimalGrayscale", "Landroid/graphics/Bitmap;", "bitmap", "enhanceContrast", "factor", "recognizeTextEnhanced", "Lcom/mlens/app/ml/EnhancedTextProcessor$EnhancedOCRResult;", "(Landroid/graphics/Bitmap;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "recognizeWithSpecificRecognizer", "recognizer", "(Landroid/graphics/Bitmap;Lcom/google/mlkit/vision/text/TextRecognizer;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "reduceNoise", "sharpenImage", "EnhancedOCRResult", "TextBlock", "app_debug"})
public final class EnhancedTextProcessor {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private final com.google.mlkit.vision.text.TextRecognizer latinRecognizer = null;
    
    public EnhancedTextProcessor(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object recognizeTextEnhanced(@org.jetbrains.annotations.NotNull()
    android.graphics.Bitmap bitmap, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.mlens.app.ml.EnhancedTextProcessor.EnhancedOCRResult> $completion) {
        return null;
    }
    
    private final java.lang.Object recognizeWithSpecificRecognizer(android.graphics.Bitmap bitmap, com.google.mlkit.vision.text.TextRecognizer recognizer, java.lang.String language, kotlin.coroutines.Continuation<? super com.mlens.app.ml.EnhancedTextProcessor.EnhancedOCRResult> $completion) {
        return null;
    }
    
    private final android.graphics.Bitmap enhanceContrast(android.graphics.Bitmap bitmap, float factor) {
        return null;
    }
    
    private final android.graphics.Bitmap convertToOptimalGrayscale(android.graphics.Bitmap bitmap) {
        return null;
    }
    
    private final android.graphics.Bitmap sharpenImage(android.graphics.Bitmap bitmap) {
        return null;
    }
    
    private final android.graphics.Bitmap reduceNoise(android.graphics.Bitmap bitmap) {
        return null;
    }
    
    private final float calculateAdvancedBlockConfidence(com.google.mlkit.vision.text.Text.TextBlock block, java.lang.String language) {
        return 0.0F;
    }
    
    public final void cleanup() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\b\u00a2\u0006\u0002\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u00c6\u0003J\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\bH\u00c6\u0003JG\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\bH\u00c6\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001d\u001a\u00020\u001eH\u00d6\u0001J\t\u0010\u001f\u001a\u00020\u0003H\u00d6\u0001R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011\u00a8\u0006 "}, d2 = {"Lcom/mlens/app/ml/EnhancedTextProcessor$EnhancedOCRResult;", "", "text", "", "confidence", "", "language", "blocks", "", "Lcom/mlens/app/ml/EnhancedTextProcessor$TextBlock;", "preprocessingApplied", "(Ljava/lang/String;FLjava/lang/String;Ljava/util/List;Ljava/util/List;)V", "getBlocks", "()Ljava/util/List;", "getConfidence", "()F", "getLanguage", "()Ljava/lang/String;", "getPreprocessingApplied", "getText", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"})
    public static final class EnhancedOCRResult {
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String text = null;
        private final float confidence = 0.0F;
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String language = null;
        @org.jetbrains.annotations.NotNull()
        private final java.util.List<com.mlens.app.ml.EnhancedTextProcessor.TextBlock> blocks = null;
        @org.jetbrains.annotations.NotNull()
        private final java.util.List<java.lang.String> preprocessingApplied = null;
        
        public EnhancedOCRResult(@org.jetbrains.annotations.NotNull()
        java.lang.String text, float confidence, @org.jetbrains.annotations.NotNull()
        java.lang.String language, @org.jetbrains.annotations.NotNull()
        java.util.List<com.mlens.app.ml.EnhancedTextProcessor.TextBlock> blocks, @org.jetbrains.annotations.NotNull()
        java.util.List<java.lang.String> preprocessingApplied) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getText() {
            return null;
        }
        
        public final float getConfidence() {
            return 0.0F;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getLanguage() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<com.mlens.app.ml.EnhancedTextProcessor.TextBlock> getBlocks() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<java.lang.String> getPreprocessingApplied() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component1() {
            return null;
        }
        
        public final float component2() {
            return 0.0F;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component3() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<com.mlens.app.ml.EnhancedTextProcessor.TextBlock> component4() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<java.lang.String> component5() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.mlens.app.ml.EnhancedTextProcessor.EnhancedOCRResult copy(@org.jetbrains.annotations.NotNull()
        java.lang.String text, float confidence, @org.jetbrains.annotations.NotNull()
        java.lang.String language, @org.jetbrains.annotations.NotNull()
        java.util.List<com.mlens.app.ml.EnhancedTextProcessor.TextBlock> blocks, @org.jetbrains.annotations.NotNull()
        java.util.List<java.lang.String> preprocessingApplied) {
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
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\t\u0010\u0013\u001a\u00020\u0007H\u00c6\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J5\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0019\u001a\u00020\u001aH\u00d6\u0001J\t\u0010\u001b\u001a\u00020\u0003H\u00d6\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000f\u00a8\u0006\u001c"}, d2 = {"Lcom/mlens/app/ml/EnhancedTextProcessor$TextBlock;", "", "text", "", "boundingBox", "Landroid/graphics/Rect;", "confidence", "", "language", "(Ljava/lang/String;Landroid/graphics/Rect;FLjava/lang/String;)V", "getBoundingBox", "()Landroid/graphics/Rect;", "getConfidence", "()F", "getLanguage", "()Ljava/lang/String;", "getText", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"})
    public static final class TextBlock {
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String text = null;
        @org.jetbrains.annotations.Nullable()
        private final android.graphics.Rect boundingBox = null;
        private final float confidence = 0.0F;
        @org.jetbrains.annotations.Nullable()
        private final java.lang.String language = null;
        
        public TextBlock(@org.jetbrains.annotations.NotNull()
        java.lang.String text, @org.jetbrains.annotations.Nullable()
        android.graphics.Rect boundingBox, float confidence, @org.jetbrains.annotations.Nullable()
        java.lang.String language) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getText() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final android.graphics.Rect getBoundingBox() {
            return null;
        }
        
        public final float getConfidence() {
            return 0.0F;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getLanguage() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component1() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final android.graphics.Rect component2() {
            return null;
        }
        
        public final float component3() {
            return 0.0F;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String component4() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.mlens.app.ml.EnhancedTextProcessor.TextBlock copy(@org.jetbrains.annotations.NotNull()
        java.lang.String text, @org.jetbrains.annotations.Nullable()
        android.graphics.Rect boundingBox, float confidence, @org.jetbrains.annotations.Nullable()
        java.lang.String language) {
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