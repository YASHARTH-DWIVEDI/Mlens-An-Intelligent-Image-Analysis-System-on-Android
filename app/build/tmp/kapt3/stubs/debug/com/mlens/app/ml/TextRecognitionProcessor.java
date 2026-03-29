package com.mlens.app.ml;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0002\u0010\u0011B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0006\u0010\t\u001a\u00020\nJ\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0086@\u00a2\u0006\u0002\u0010\u000fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/mlens/app/ml/TextRecognitionProcessor;", "", "()V", "recognizer", "Lcom/google/mlkit/vision/text/TextRecognizer;", "calculateBlockConfidence", "", "block", "Lcom/google/mlkit/vision/text/Text$TextBlock;", "cleanup", "", "recognizeText", "Lcom/mlens/app/ml/TextRecognitionProcessor$OCRResult;", "bitmap", "Landroid/graphics/Bitmap;", "(Landroid/graphics/Bitmap;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "OCRResult", "TextBlock", "app_debug"})
public final class TextRecognitionProcessor {
    @org.jetbrains.annotations.NotNull()
    private final com.google.mlkit.vision.text.TextRecognizer recognizer = null;
    
    public TextRecognitionProcessor() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object recognizeText(@org.jetbrains.annotations.NotNull()
    android.graphics.Bitmap bitmap, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.mlens.app.ml.TextRecognitionProcessor.OCRResult> $completion) {
        return null;
    }
    
    private final float calculateBlockConfidence(com.google.mlkit.vision.text.Text.TextBlock block) {
        return 0.0F;
    }
    
    public final void cleanup() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0011\u001a\u00020\u0005H\u00c6\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u00c6\u0003J-\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u00c6\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0017\u001a\u00020\u0018H\u00d6\u0001J\t\u0010\u0019\u001a\u00020\u0003H\u00d6\u0001R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u001a"}, d2 = {"Lcom/mlens/app/ml/TextRecognitionProcessor$OCRResult;", "", "text", "", "confidence", "", "blocks", "", "Lcom/mlens/app/ml/TextRecognitionProcessor$TextBlock;", "(Ljava/lang/String;FLjava/util/List;)V", "getBlocks", "()Ljava/util/List;", "getConfidence", "()F", "getText", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"})
    public static final class OCRResult {
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String text = null;
        private final float confidence = 0.0F;
        @org.jetbrains.annotations.NotNull()
        private final java.util.List<com.mlens.app.ml.TextRecognitionProcessor.TextBlock> blocks = null;
        
        public OCRResult(@org.jetbrains.annotations.NotNull()
        java.lang.String text, float confidence, @org.jetbrains.annotations.NotNull()
        java.util.List<com.mlens.app.ml.TextRecognitionProcessor.TextBlock> blocks) {
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
        public final java.util.List<com.mlens.app.ml.TextRecognitionProcessor.TextBlock> getBlocks() {
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
        public final java.util.List<com.mlens.app.ml.TextRecognitionProcessor.TextBlock> component3() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.mlens.app.ml.TextRecognitionProcessor.OCRResult copy(@org.jetbrains.annotations.NotNull()
        java.lang.String text, float confidence, @org.jetbrains.annotations.NotNull()
        java.util.List<com.mlens.app.ml.TextRecognitionProcessor.TextBlock> blocks) {
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
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\t\u0010\u0011\u001a\u00020\u0007H\u00c6\u0003J)\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u00c6\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0016\u001a\u00020\u0017H\u00d6\u0001J\t\u0010\u0018\u001a\u00020\u0003H\u00d6\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0019"}, d2 = {"Lcom/mlens/app/ml/TextRecognitionProcessor$TextBlock;", "", "text", "", "boundingBox", "Landroid/graphics/Rect;", "confidence", "", "(Ljava/lang/String;Landroid/graphics/Rect;F)V", "getBoundingBox", "()Landroid/graphics/Rect;", "getConfidence", "()F", "getText", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"})
    public static final class TextBlock {
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String text = null;
        @org.jetbrains.annotations.Nullable()
        private final android.graphics.Rect boundingBox = null;
        private final float confidence = 0.0F;
        
        public TextBlock(@org.jetbrains.annotations.NotNull()
        java.lang.String text, @org.jetbrains.annotations.Nullable()
        android.graphics.Rect boundingBox, float confidence) {
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
        
        @org.jetbrains.annotations.NotNull()
        public final com.mlens.app.ml.TextRecognitionProcessor.TextBlock copy(@org.jetbrains.annotations.NotNull()
        java.lang.String text, @org.jetbrains.annotations.Nullable()
        android.graphics.Rect boundingBox, float confidence) {
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