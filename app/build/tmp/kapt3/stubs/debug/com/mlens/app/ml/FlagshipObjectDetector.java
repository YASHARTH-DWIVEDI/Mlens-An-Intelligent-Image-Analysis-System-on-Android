package com.mlens.app.ml;

/**
 * Flagship Object Detection using latest ML Kit models and advanced processing
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 .2\u00020\u0001:\u0003./0B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0006\u0010\u0013\u001a\u00020\u0014J\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\u0006\u0010\u0018\u001a\u00020\u0019H\u0086@\u00a2\u0006\u0002\u0010\u001aJ\u001c\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00162\u0006\u0010\u001d\u001a\u00020\u001eH\u0082@\u00a2\u0006\u0002\u0010\u001fJ\u0016\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001c0\u00162\u0006\u0010\u0018\u001a\u00020\u0019H\u0002JX\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00162\u0018\u0010#\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020%0$0\u00162\u0018\u0010&\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020%0$0\u00162\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J6\u0010\'\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\u0018\u0010&\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020%0$0\u00162\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0002J(\u0010)\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020%0$0\u00162\u0006\u0010\u001d\u001a\u00020\u001eH\u0082@\u00a2\u0006\u0002\u0010\u001fJ(\u0010*\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020%0$0\u00162\u0006\u0010\u001d\u001a\u00020\u001eH\u0082@\u00a2\u0006\u0002\u0010\u001fJ\u001e\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u00112\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\r\u00a8\u00061"}, d2 = {"Lcom/mlens/app/ml/FlagshipObjectDetector;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "broadLabeler", "Lcom/google/mlkit/vision/label/ImageLabeler;", "highAccuracyLabeler", "objectDetector", "Lcom/google/mlkit/vision/objects/ObjectDetector;", "yolo", "Lcom/mlens/app/ml/FlagshipYoloDetector;", "getYolo", "()Lcom/mlens/app/ml/FlagshipYoloDetector;", "yolo$delegate", "Lkotlin/Lazy;", "cleanObjectName", "", "rawName", "cleanup", "", "detectObjectsAdvanced", "", "Lcom/mlens/app/ml/FlagshipImageCaptioner$DetectedObjectAdvanced;", "bitmap", "Landroid/graphics/Bitmap;", "(Landroid/graphics/Bitmap;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "detectObjectsWithBounds", "Lcom/mlens/app/ml/FlagshipObjectDetector$ObjectWithBounds;", "image", "Lcom/google/mlkit/vision/common/InputImage;", "(Lcom/google/mlkit/vision/common/InputImage;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "detectWithYolo", "enhanceObjectDetection", "objects", "highAccuracyLabels", "Lkotlin/Pair;", "", "broadLabels", "extractContextualObjects", "existingObjects", "getBroadLabels", "getHighAccuracyLabels", "isContextuallyRelevant", "", "objectName", "Companion", "FlagshipDetectionResult", "ObjectWithBounds", "app_debug"})
public final class FlagshipObjectDetector {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy yolo$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final com.google.mlkit.vision.objects.ObjectDetector objectDetector = null;
    @org.jetbrains.annotations.NotNull()
    private final com.google.mlkit.vision.label.ImageLabeler highAccuracyLabeler = null;
    @org.jetbrains.annotations.NotNull()
    private final com.google.mlkit.vision.label.ImageLabeler broadLabeler = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String TAG = "FlagshipObjectDetector";
    @org.jetbrains.annotations.NotNull()
    public static final com.mlens.app.ml.FlagshipObjectDetector.Companion Companion = null;
    
    public FlagshipObjectDetector(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    private final com.mlens.app.ml.FlagshipYoloDetector getYolo() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object detectObjectsAdvanced(@org.jetbrains.annotations.NotNull()
    android.graphics.Bitmap bitmap, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.mlens.app.ml.FlagshipImageCaptioner.DetectedObjectAdvanced>> $completion) {
        return null;
    }
    
    private final java.lang.Object detectObjectsWithBounds(com.google.mlkit.vision.common.InputImage image, kotlin.coroutines.Continuation<? super java.util.List<com.mlens.app.ml.FlagshipObjectDetector.ObjectWithBounds>> $completion) {
        return null;
    }
    
    private final java.util.List<com.mlens.app.ml.FlagshipObjectDetector.ObjectWithBounds> detectWithYolo(android.graphics.Bitmap bitmap) {
        return null;
    }
    
    private final java.lang.Object getHighAccuracyLabels(com.google.mlkit.vision.common.InputImage image, kotlin.coroutines.Continuation<? super java.util.List<kotlin.Pair<java.lang.String, java.lang.Float>>> $completion) {
        return null;
    }
    
    private final java.lang.Object getBroadLabels(com.google.mlkit.vision.common.InputImage image, kotlin.coroutines.Continuation<? super java.util.List<kotlin.Pair<java.lang.String, java.lang.Float>>> $completion) {
        return null;
    }
    
    private final java.util.List<com.mlens.app.ml.FlagshipImageCaptioner.DetectedObjectAdvanced> enhanceObjectDetection(java.util.List<com.mlens.app.ml.FlagshipObjectDetector.ObjectWithBounds> objects, java.util.List<kotlin.Pair<java.lang.String, java.lang.Float>> highAccuracyLabels, java.util.List<kotlin.Pair<java.lang.String, java.lang.Float>> broadLabels, android.graphics.Bitmap bitmap) {
        return null;
    }
    
    private final java.util.List<com.mlens.app.ml.FlagshipImageCaptioner.DetectedObjectAdvanced> extractContextualObjects(java.util.List<kotlin.Pair<java.lang.String, java.lang.Float>> broadLabels, java.util.List<com.mlens.app.ml.FlagshipImageCaptioner.DetectedObjectAdvanced> existingObjects) {
        return null;
    }
    
    private final boolean isContextuallyRelevant(java.lang.String objectName, java.util.List<com.mlens.app.ml.FlagshipImageCaptioner.DetectedObjectAdvanced> existingObjects) {
        return false;
    }
    
    private final java.lang.String cleanObjectName(java.lang.String rawName) {
        return null;
    }
    
    public final void cleanup() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/mlens/app/ml/FlagshipObjectDetector$Companion;", "", "()V", "TAG", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u00a2\u0006\u0002\u0010\u000bJ\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\bH\u00c6\u0003J\t\u0010\u0016\u001a\u00020\nH\u00c6\u0003J=\u0010\u0017\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nH\u00c6\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001b\u001a\u00020\u001cH\u00d6\u0001J\t\u0010\u001d\u001a\u00020\u0006H\u00d6\u0001R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000f\u00a8\u0006\u001e"}, d2 = {"Lcom/mlens/app/ml/FlagshipObjectDetector$FlagshipDetectionResult;", "", "objects", "", "Lcom/mlens/app/ml/FlagshipImageCaptioner$DetectedObjectAdvanced;", "sceneLabels", "", "confidence", "", "processingTime", "", "(Ljava/util/List;Ljava/util/List;FJ)V", "getConfidence", "()F", "getObjects", "()Ljava/util/List;", "getProcessingTime", "()J", "getSceneLabels", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"})
    public static final class FlagshipDetectionResult {
        @org.jetbrains.annotations.NotNull()
        private final java.util.List<com.mlens.app.ml.FlagshipImageCaptioner.DetectedObjectAdvanced> objects = null;
        @org.jetbrains.annotations.NotNull()
        private final java.util.List<java.lang.String> sceneLabels = null;
        private final float confidence = 0.0F;
        private final long processingTime = 0L;
        
        public FlagshipDetectionResult(@org.jetbrains.annotations.NotNull()
        java.util.List<com.mlens.app.ml.FlagshipImageCaptioner.DetectedObjectAdvanced> objects, @org.jetbrains.annotations.NotNull()
        java.util.List<java.lang.String> sceneLabels, float confidence, long processingTime) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<com.mlens.app.ml.FlagshipImageCaptioner.DetectedObjectAdvanced> getObjects() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<java.lang.String> getSceneLabels() {
            return null;
        }
        
        public final float getConfidence() {
            return 0.0F;
        }
        
        public final long getProcessingTime() {
            return 0L;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<com.mlens.app.ml.FlagshipImageCaptioner.DetectedObjectAdvanced> component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<java.lang.String> component2() {
            return null;
        }
        
        public final float component3() {
            return 0.0F;
        }
        
        public final long component4() {
            return 0L;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.mlens.app.ml.FlagshipObjectDetector.FlagshipDetectionResult copy(@org.jetbrains.annotations.NotNull()
        java.util.List<com.mlens.app.ml.FlagshipImageCaptioner.DetectedObjectAdvanced> objects, @org.jetbrains.annotations.NotNull()
        java.util.List<java.lang.String> sceneLabels, float confidence, long processingTime) {
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
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0082\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0018\u0010\u0004\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00060\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u00a2\u0006\u0002\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003H\u00c6\u0003J\u001b\u0010\u0014\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00060\u0005H\u00c6\u0003J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\nH\u00c6\u0003\u00a2\u0006\u0002\u0010\u0011J@\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u001a\b\u0002\u0010\u0004\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00060\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nH\u00c6\u0001\u00a2\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001b\u001a\u00020\nH\u00d6\u0001J\t\u0010\u001c\u001a\u00020\u0007H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR#\u0010\u0004\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\t\u001a\u0004\u0018\u00010\n\u00a2\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u001d"}, d2 = {"Lcom/mlens/app/ml/FlagshipObjectDetector$ObjectWithBounds;", "", "boundingBox", "Landroid/graphics/Rect;", "labels", "", "Lkotlin/Pair;", "", "", "trackingId", "", "(Landroid/graphics/Rect;Ljava/util/List;Ljava/lang/Integer;)V", "getBoundingBox", "()Landroid/graphics/Rect;", "getLabels", "()Ljava/util/List;", "getTrackingId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "copy", "(Landroid/graphics/Rect;Ljava/util/List;Ljava/lang/Integer;)Lcom/mlens/app/ml/FlagshipObjectDetector$ObjectWithBounds;", "equals", "", "other", "hashCode", "toString", "app_debug"})
    static final class ObjectWithBounds {
        @org.jetbrains.annotations.NotNull()
        private final android.graphics.Rect boundingBox = null;
        @org.jetbrains.annotations.NotNull()
        private final java.util.List<kotlin.Pair<java.lang.String, java.lang.Float>> labels = null;
        @org.jetbrains.annotations.Nullable()
        private final java.lang.Integer trackingId = null;
        
        public ObjectWithBounds(@org.jetbrains.annotations.NotNull()
        android.graphics.Rect boundingBox, @org.jetbrains.annotations.NotNull()
        java.util.List<kotlin.Pair<java.lang.String, java.lang.Float>> labels, @org.jetbrains.annotations.Nullable()
        java.lang.Integer trackingId) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.graphics.Rect getBoundingBox() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<kotlin.Pair<java.lang.String, java.lang.Float>> getLabels() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Integer getTrackingId() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.graphics.Rect component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<kotlin.Pair<java.lang.String, java.lang.Float>> component2() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Integer component3() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.mlens.app.ml.FlagshipObjectDetector.ObjectWithBounds copy(@org.jetbrains.annotations.NotNull()
        android.graphics.Rect boundingBox, @org.jetbrains.annotations.NotNull()
        java.util.List<kotlin.Pair<java.lang.String, java.lang.Float>> labels, @org.jetbrains.annotations.Nullable()
        java.lang.Integer trackingId) {
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