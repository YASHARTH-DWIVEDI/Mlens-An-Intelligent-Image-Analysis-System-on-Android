package com.mlens.app.ml;

/**
 * Flagship Image Captioning using state-of-the-art models
 * Generates natural language descriptions like "a cat sitting on grass"
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 &2\u00020\u0001:\b#$%&\'()*B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\r\u001a\u00020\u000eJ\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0082@\u00a2\u0006\u0002\u0010\u0013J,\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\f0\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u00152\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0016\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0011\u001a\u00020\u0012H\u0086@\u00a2\u0006\u0002\u0010\u0013J&\u0010\u001e\u001a\u00020\u001f2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u00152\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u001e\u0010 \u001a\u00020\f2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u00152\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u0010!\u001a\u00020\u000eH\u0002J\u0014\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nH\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006+"}, d2 = {"Lcom/mlens/app/ml/FlagshipImageCaptioner;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "captionInterpreter", "Lorg/tensorflow/lite/Interpreter;", "imageProcessor", "Lorg/tensorflow/lite/support/image/ImageProcessor;", "vocabularyMap", "", "", "", "cleanup", "", "generateAdvancedCaption", "Lcom/mlens/app/ml/FlagshipImageCaptioner$AdvancedCaptionResult;", "bitmap", "Landroid/graphics/Bitmap;", "(Landroid/graphics/Bitmap;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "generateAlternativeCaptions", "", "objects", "Lcom/mlens/app/ml/FlagshipImageCaptioner$DetectedObjectAdvanced;", "scene", "Lcom/mlens/app/ml/FlagshipImageCaptioner$SceneContext;", "relationships", "Lcom/mlens/app/ml/FlagshipImageCaptioner$SpatialRelationships;", "generateCaption", "Lcom/mlens/app/ml/FlagshipImageCaptioner$CaptionResult;", "generateNaturalLanguageCaption", "Lcom/mlens/app/ml/FlagshipImageCaptioner$CaptionGeneration;", "inferActivity", "initializeModel", "loadVocabulary", "AdvancedCaptionResult", "CaptionGeneration", "CaptionResult", "Companion", "DetectedObjectAdvanced", "Relationship", "SceneContext", "SpatialRelationships", "app_debug"})
public final class FlagshipImageCaptioner {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.Nullable()
    private org.tensorflow.lite.Interpreter captionInterpreter;
    @org.jetbrains.annotations.NotNull()
    private java.util.Map<java.lang.Integer, java.lang.String> vocabularyMap;
    @org.jetbrains.annotations.Nullable()
    private org.tensorflow.lite.support.image.ImageProcessor imageProcessor;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String TAG = "FlagshipImageCaptioner";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String CAPTION_MODEL_PATH = "image_captioning_model.tflite";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String VOCAB_PATH = "vocab.txt";
    private static final int IMAGE_SIZE = 299;
    private static final int MAX_CAPTION_LENGTH = 20;
    private static final int BEAM_WIDTH = 3;
    @org.jetbrains.annotations.NotNull()
    public static final com.mlens.app.ml.FlagshipImageCaptioner.Companion Companion = null;
    
    public FlagshipImageCaptioner(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    private final void initializeModel() {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object generateCaption(@org.jetbrains.annotations.NotNull()
    android.graphics.Bitmap bitmap, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.mlens.app.ml.FlagshipImageCaptioner.CaptionResult> $completion) {
        return null;
    }
    
    private final java.lang.Object generateAdvancedCaption(android.graphics.Bitmap bitmap, kotlin.coroutines.Continuation<? super com.mlens.app.ml.FlagshipImageCaptioner.AdvancedCaptionResult> $completion) {
        return null;
    }
    
    private final com.mlens.app.ml.FlagshipImageCaptioner.CaptionGeneration generateNaturalLanguageCaption(java.util.List<com.mlens.app.ml.FlagshipImageCaptioner.DetectedObjectAdvanced> objects, com.mlens.app.ml.FlagshipImageCaptioner.SceneContext scene, com.mlens.app.ml.FlagshipImageCaptioner.SpatialRelationships relationships) {
        return null;
    }
    
    private final java.util.List<java.lang.String> generateAlternativeCaptions(java.util.List<com.mlens.app.ml.FlagshipImageCaptioner.DetectedObjectAdvanced> objects, com.mlens.app.ml.FlagshipImageCaptioner.SceneContext scene, com.mlens.app.ml.FlagshipImageCaptioner.SpatialRelationships relationships) {
        return null;
    }
    
    private final java.lang.String inferActivity(java.util.List<com.mlens.app.ml.FlagshipImageCaptioner.DetectedObjectAdvanced> objects, com.mlens.app.ml.FlagshipImageCaptioner.SceneContext scene) {
        return null;
    }
    
    private final java.util.Map<java.lang.Integer, java.lang.String> loadVocabulary() {
        return null;
    }
    
    public final void cleanup() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005H\u00c6\u0003J\t\u0010\u0011\u001a\u00020\u0007H\u00c6\u0003J-\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u00c6\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0016\u001a\u00020\u0017H\u00d6\u0001J\t\u0010\u0018\u001a\u00020\u0003H\u00d6\u0001R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0019"}, d2 = {"Lcom/mlens/app/ml/FlagshipImageCaptioner$AdvancedCaptionResult;", "", "primary", "", "alternatives", "", "confidence", "", "(Ljava/lang/String;Ljava/util/List;F)V", "getAlternatives", "()Ljava/util/List;", "getConfidence", "()F", "getPrimary", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"})
    public static final class AdvancedCaptionResult {
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String primary = null;
        @org.jetbrains.annotations.NotNull()
        private final java.util.List<java.lang.String> alternatives = null;
        private final float confidence = 0.0F;
        
        public AdvancedCaptionResult(@org.jetbrains.annotations.NotNull()
        java.lang.String primary, @org.jetbrains.annotations.NotNull()
        java.util.List<java.lang.String> alternatives, float confidence) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getPrimary() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<java.lang.String> getAlternatives() {
            return null;
        }
        
        public final float getConfidence() {
            return 0.0F;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<java.lang.String> component2() {
            return null;
        }
        
        public final float component3() {
            return 0.0F;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.mlens.app.ml.FlagshipImageCaptioner.AdvancedCaptionResult copy(@org.jetbrains.annotations.NotNull()
        java.lang.String primary, @org.jetbrains.annotations.NotNull()
        java.util.List<java.lang.String> alternatives, float confidence) {
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
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005H\u00c6\u0003J\t\u0010\u0011\u001a\u00020\u0007H\u00c6\u0003J-\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u00c6\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0016\u001a\u00020\u0017H\u00d6\u0001J\t\u0010\u0018\u001a\u00020\u0003H\u00d6\u0001R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0019"}, d2 = {"Lcom/mlens/app/ml/FlagshipImageCaptioner$CaptionGeneration;", "", "primary", "", "alternatives", "", "confidence", "", "(Ljava/lang/String;Ljava/util/List;F)V", "getAlternatives", "()Ljava/util/List;", "getConfidence", "()F", "getPrimary", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"})
    public static final class CaptionGeneration {
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String primary = null;
        @org.jetbrains.annotations.NotNull()
        private final java.util.List<java.lang.String> alternatives = null;
        private final float confidence = 0.0F;
        
        public CaptionGeneration(@org.jetbrains.annotations.NotNull()
        java.lang.String primary, @org.jetbrains.annotations.NotNull()
        java.util.List<java.lang.String> alternatives, float confidence) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getPrimary() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<java.lang.String> getAlternatives() {
            return null;
        }
        
        public final float getConfidence() {
            return 0.0F;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<java.lang.String> component2() {
            return null;
        }
        
        public final float component3() {
            return 0.0F;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.mlens.app.ml.FlagshipImageCaptioner.CaptionGeneration copy(@org.jetbrains.annotations.NotNull()
        java.lang.String primary, @org.jetbrains.annotations.NotNull()
        java.util.List<java.lang.String> alternatives, float confidence) {
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
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\u0005H\u00c6\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\tH\u00c6\u0003J7\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u00c6\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001b\u001a\u00020\u001cH\u00d6\u0001J\t\u0010\u001d\u001a\u00020\u0003H\u00d6\u0001R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u001e"}, d2 = {"Lcom/mlens/app/ml/FlagshipImageCaptioner$CaptionResult;", "", "caption", "", "confidence", "", "alternativeCaptions", "", "processingTime", "", "(Ljava/lang/String;FLjava/util/List;J)V", "getAlternativeCaptions", "()Ljava/util/List;", "getCaption", "()Ljava/lang/String;", "getConfidence", "()F", "getProcessingTime", "()J", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"})
    public static final class CaptionResult {
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String caption = null;
        private final float confidence = 0.0F;
        @org.jetbrains.annotations.NotNull()
        private final java.util.List<java.lang.String> alternativeCaptions = null;
        private final long processingTime = 0L;
        
        public CaptionResult(@org.jetbrains.annotations.NotNull()
        java.lang.String caption, float confidence, @org.jetbrains.annotations.NotNull()
        java.util.List<java.lang.String> alternativeCaptions, long processingTime) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getCaption() {
            return null;
        }
        
        public final float getConfidence() {
            return 0.0F;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<java.lang.String> getAlternativeCaptions() {
            return null;
        }
        
        public final long getProcessingTime() {
            return 0L;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component1() {
            return null;
        }
        
        public final float component2() {
            return 0.0F;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<java.lang.String> component3() {
            return null;
        }
        
        public final long component4() {
            return 0L;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.mlens.app.ml.FlagshipImageCaptioner.CaptionResult copy(@org.jetbrains.annotations.NotNull()
        java.lang.String caption, float confidence, @org.jetbrains.annotations.NotNull()
        java.util.List<java.lang.String> alternativeCaptions, long processingTime) {
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
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/mlens/app/ml/FlagshipImageCaptioner$Companion;", "", "()V", "BEAM_WIDTH", "", "CAPTION_MODEL_PATH", "", "IMAGE_SIZE", "MAX_CAPTION_LENGTH", "TAG", "VOCAB_PATH", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0012\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0013\u001a\u00020\u0007H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\u0003H\u00c6\u0003J1\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0019\u001a\u00020\u001aH\u00d6\u0001J\t\u0010\u001b\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b\u00a8\u0006\u001c"}, d2 = {"Lcom/mlens/app/ml/FlagshipImageCaptioner$DetectedObjectAdvanced;", "", "name", "", "confidence", "", "boundingBox", "Landroid/graphics/Rect;", "article", "(Ljava/lang/String;FLandroid/graphics/Rect;Ljava/lang/String;)V", "getArticle", "()Ljava/lang/String;", "getBoundingBox", "()Landroid/graphics/Rect;", "getConfidence", "()F", "getName", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"})
    public static final class DetectedObjectAdvanced {
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String name = null;
        private final float confidence = 0.0F;
        @org.jetbrains.annotations.NotNull()
        private final android.graphics.Rect boundingBox = null;
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String article = null;
        
        public DetectedObjectAdvanced(@org.jetbrains.annotations.NotNull()
        java.lang.String name, float confidence, @org.jetbrains.annotations.NotNull()
        android.graphics.Rect boundingBox, @org.jetbrains.annotations.NotNull()
        java.lang.String article) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getName() {
            return null;
        }
        
        public final float getConfidence() {
            return 0.0F;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.graphics.Rect getBoundingBox() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getArticle() {
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
        public final android.graphics.Rect component3() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component4() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.mlens.app.ml.FlagshipImageCaptioner.DetectedObjectAdvanced copy(@org.jetbrains.annotations.NotNull()
        java.lang.String name, float confidence, @org.jetbrains.annotations.NotNull()
        android.graphics.Rect boundingBox, @org.jetbrains.annotations.NotNull()
        java.lang.String article) {
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
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\t\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\n\u001a\u00020\u0005H\u00c2\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\f\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u000e\u001a\u00020\u000fH\u00d6\u0001J\u0006\u0010\u0010\u001a\u00020\u0005J\t\u0010\u0011\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/mlens/app/ml/FlagshipImageCaptioner$Relationship;", "", "preposition", "", "valid", "", "(Ljava/lang/String;Z)V", "getPreposition", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "other", "hashCode", "", "isValid", "toString", "app_debug"})
    public static final class Relationship {
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String preposition = null;
        private final boolean valid = false;
        
        public Relationship(@org.jetbrains.annotations.NotNull()
        java.lang.String preposition, boolean valid) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getPreposition() {
            return null;
        }
        
        public final boolean isValid() {
            return false;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component1() {
            return null;
        }
        
        private final boolean component2() {
            return false;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.mlens.app.ml.FlagshipImageCaptioner.Relationship copy(@org.jetbrains.annotations.NotNull()
        java.lang.String preposition, boolean valid) {
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
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010 \n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\t\u00a2\u0006\u0002\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0013\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\u0007H\u00c6\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\tH\u00c6\u0003J7\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\tH\u00c6\u0001J\u0013\u0010\u0017\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\u0006\u0010\u0019\u001a\u00020\u0003J\t\u0010\u001a\u001a\u00020\u001bH\u00d6\u0001J\t\u0010\u001c\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u001d"}, d2 = {"Lcom/mlens/app/ml/FlagshipImageCaptioner$SceneContext;", "", "primaryScene", "", "isOutdoor", "", "confidence", "", "dominantColors", "", "(Ljava/lang/String;ZFLjava/util/List;)V", "getConfidence", "()F", "getDominantColors", "()Ljava/util/List;", "()Z", "getPrimaryScene", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "getLocationContext", "hashCode", "", "toString", "app_debug"})
    public static final class SceneContext {
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String primaryScene = null;
        private final boolean isOutdoor = false;
        private final float confidence = 0.0F;
        @org.jetbrains.annotations.NotNull()
        private final java.util.List<java.lang.String> dominantColors = null;
        
        public SceneContext(@org.jetbrains.annotations.NotNull()
        java.lang.String primaryScene, boolean isOutdoor, float confidence, @org.jetbrains.annotations.NotNull()
        java.util.List<java.lang.String> dominantColors) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getPrimaryScene() {
            return null;
        }
        
        public final boolean isOutdoor() {
            return false;
        }
        
        public final float getConfidence() {
            return 0.0F;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<java.lang.String> getDominantColors() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getLocationContext() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component1() {
            return null;
        }
        
        public final boolean component2() {
            return false;
        }
        
        public final float component3() {
            return 0.0F;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<java.lang.String> component4() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.mlens.app.ml.FlagshipImageCaptioner.SceneContext copy(@org.jetbrains.annotations.NotNull()
        java.lang.String primaryScene, boolean isOutdoor, float confidence, @org.jetbrains.annotations.NotNull()
        java.util.List<java.lang.String> dominantColors) {
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
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u001e\u0010\u0002\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u00a2\u0006\u0002\u0010\u0006J!\u0010\t\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u00c6\u0003J+\u0010\n\u001a\u00020\u00002 \b\u0002\u0010\u0002\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u00c6\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011J\t\u0010\u0013\u001a\u00020\u0014H\u00d6\u0001J\u0018\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\t\u0010\u0016\u001a\u00020\u0005H\u00d6\u0001R)\u0010\u0002\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u0017"}, d2 = {"Lcom/mlens/app/ml/FlagshipImageCaptioner$SpatialRelationships;", "", "relationships", "", "Lkotlin/Pair;", "", "(Ljava/util/Map;)V", "getRelationships", "()Ljava/util/Map;", "component1", "copy", "equals", "", "other", "getRelationship", "Lcom/mlens/app/ml/FlagshipImageCaptioner$Relationship;", "obj1", "Lcom/mlens/app/ml/FlagshipImageCaptioner$DetectedObjectAdvanced;", "obj2", "hashCode", "", "inferSpatialRelationship", "toString", "app_debug"})
    public static final class SpatialRelationships {
        @org.jetbrains.annotations.NotNull()
        private final java.util.Map<kotlin.Pair<java.lang.String, java.lang.String>, java.lang.String> relationships = null;
        
        public SpatialRelationships(@org.jetbrains.annotations.NotNull()
        java.util.Map<kotlin.Pair<java.lang.String, java.lang.String>, java.lang.String> relationships) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.Map<kotlin.Pair<java.lang.String, java.lang.String>, java.lang.String> getRelationships() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.mlens.app.ml.FlagshipImageCaptioner.Relationship getRelationship(@org.jetbrains.annotations.NotNull()
        com.mlens.app.ml.FlagshipImageCaptioner.DetectedObjectAdvanced obj1, @org.jetbrains.annotations.NotNull()
        com.mlens.app.ml.FlagshipImageCaptioner.DetectedObjectAdvanced obj2) {
            return null;
        }
        
        private final java.lang.String inferSpatialRelationship(com.mlens.app.ml.FlagshipImageCaptioner.DetectedObjectAdvanced obj1, com.mlens.app.ml.FlagshipImageCaptioner.DetectedObjectAdvanced obj2) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.Map<kotlin.Pair<java.lang.String, java.lang.String>, java.lang.String> component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.mlens.app.ml.FlagshipImageCaptioner.SpatialRelationships copy(@org.jetbrains.annotations.NotNull()
        java.util.Map<kotlin.Pair<java.lang.String, java.lang.String>, java.lang.String> relationships) {
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