package com.mlens.app.ml;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001:\u0004+,-.B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0002J$\u0010\u0010\u001a\u00020\n2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u000e2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0002J\u0018\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\u0010\u0010\u0017\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0006\u0010\u0018\u001a\u00020\u0019J\u0016\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0086@\u00a2\u0006\u0002\u0010\u001eJ\u001c\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00120\u000e2\u0006\u0010 \u001a\u00020!H\u0082@\u00a2\u0006\u0002\u0010\"J*\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00120\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u000e2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0002J*\u0010$\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u000eH\u0002J \u0010%\u001a\u0004\u0018\u00010\u000f2\u0006\u0010&\u001a\u00020\f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u000eH\u0002J\u000e\u0010\'\u001a\u00020\f2\u0006\u0010(\u001a\u00020\u001bJ\u001c\u0010)\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010 \u001a\u00020!H\u0082@\u00a2\u0006\u0002\u0010\"J\u0010\u0010*\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006/"}, d2 = {"Lcom/mlens/app/ml/ObjectDetectionProcessor;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "imageLabeler", "Lcom/google/mlkit/vision/label/ImageLabeler;", "objectDetector", "Lcom/google/mlkit/vision/objects/ObjectDetector;", "calculateContextualBonus", "", "objectLabel", "", "sceneLabels", "", "Lcom/mlens/app/ml/ObjectDetectionProcessor$SceneLabel;", "calculateOverallConfidence", "objects", "Lcom/mlens/app/ml/ObjectDetectionProcessor$DetectedObjectInfo;", "calculateOverlap", "rect1", "Landroid/graphics/Rect;", "rect2", "categorizeObject", "cleanup", "", "detectObjects", "Lcom/mlens/app/ml/ObjectDetectionProcessor$ObjectDetectionResult;", "bitmap", "Landroid/graphics/Bitmap;", "(Landroid/graphics/Bitmap;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "detectObjectsInImage", "image", "Lcom/google/mlkit/vision/common/InputImage;", "(Lcom/google/mlkit/vision/common/InputImage;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "enhanceObjectDetection", "enhanceSceneLabeling", "generateContextualSceneLabel", "category", "generateDescriptiveText", "result", "labelScene", "optimizeBitmapForDetection", "DetectedObjectInfo", "ObjectDetectionResult", "ObjectLabel", "SceneLabel", "app_debug"})
public final class ObjectDetectionProcessor {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private final com.google.mlkit.vision.objects.ObjectDetector objectDetector = null;
    @org.jetbrains.annotations.NotNull()
    private final com.google.mlkit.vision.label.ImageLabeler imageLabeler = null;
    
    public ObjectDetectionProcessor(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object detectObjects(@org.jetbrains.annotations.NotNull()
    android.graphics.Bitmap bitmap, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.mlens.app.ml.ObjectDetectionProcessor.ObjectDetectionResult> $completion) {
        return null;
    }
    
    private final java.lang.Object detectObjectsInImage(com.google.mlkit.vision.common.InputImage image, kotlin.coroutines.Continuation<? super java.util.List<com.mlens.app.ml.ObjectDetectionProcessor.DetectedObjectInfo>> $completion) {
        return null;
    }
    
    private final java.lang.Object labelScene(com.google.mlkit.vision.common.InputImage image, kotlin.coroutines.Continuation<? super java.util.List<com.mlens.app.ml.ObjectDetectionProcessor.SceneLabel>> $completion) {
        return null;
    }
    
    private final java.util.List<com.mlens.app.ml.ObjectDetectionProcessor.DetectedObjectInfo> enhanceObjectDetection(java.util.List<com.mlens.app.ml.ObjectDetectionProcessor.DetectedObjectInfo> objects, java.util.List<com.mlens.app.ml.ObjectDetectionProcessor.SceneLabel> sceneLabels) {
        return null;
    }
    
    private final java.util.List<com.mlens.app.ml.ObjectDetectionProcessor.SceneLabel> enhanceSceneLabeling(java.util.List<com.mlens.app.ml.ObjectDetectionProcessor.SceneLabel> sceneLabels, java.util.List<com.mlens.app.ml.ObjectDetectionProcessor.DetectedObjectInfo> objects) {
        return null;
    }
    
    private final java.lang.String categorizeObject(java.lang.String objectLabel) {
        return null;
    }
    
    private final float calculateContextualBonus(java.lang.String objectLabel, java.util.List<com.mlens.app.ml.ObjectDetectionProcessor.SceneLabel> sceneLabels) {
        return 0.0F;
    }
    
    private final com.mlens.app.ml.ObjectDetectionProcessor.SceneLabel generateContextualSceneLabel(java.lang.String category, java.util.List<com.mlens.app.ml.ObjectDetectionProcessor.DetectedObjectInfo> objects) {
        return null;
    }
    
    private final float calculateOverallConfidence(java.util.List<com.mlens.app.ml.ObjectDetectionProcessor.DetectedObjectInfo> objects, java.util.List<com.mlens.app.ml.ObjectDetectionProcessor.SceneLabel> sceneLabels) {
        return 0.0F;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String generateDescriptiveText(@org.jetbrains.annotations.NotNull()
    com.mlens.app.ml.ObjectDetectionProcessor.ObjectDetectionResult result) {
        return null;
    }
    
    private final android.graphics.Bitmap optimizeBitmapForDetection(android.graphics.Bitmap bitmap) {
        return null;
    }
    
    private final float calculateOverlap(android.graphics.Rect rect1, android.graphics.Rect rect2) {
        return 0.0F;
    }
    
    public final void cleanup() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u00c6\u0003J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\bH\u00c6\u0003\u00a2\u0006\u0002\u0010\u000fJ4\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH\u00c6\u0001\u00a2\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0019\u001a\u00020\bH\u00d6\u0001J\t\u0010\u001a\u001a\u00020\u001bH\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u001c"}, d2 = {"Lcom/mlens/app/ml/ObjectDetectionProcessor$DetectedObjectInfo;", "", "boundingBox", "Landroid/graphics/Rect;", "labels", "", "Lcom/mlens/app/ml/ObjectDetectionProcessor$ObjectLabel;", "trackingId", "", "(Landroid/graphics/Rect;Ljava/util/List;Ljava/lang/Integer;)V", "getBoundingBox", "()Landroid/graphics/Rect;", "getLabels", "()Ljava/util/List;", "getTrackingId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "copy", "(Landroid/graphics/Rect;Ljava/util/List;Ljava/lang/Integer;)Lcom/mlens/app/ml/ObjectDetectionProcessor$DetectedObjectInfo;", "equals", "", "other", "hashCode", "toString", "", "app_debug"})
    public static final class DetectedObjectInfo {
        @org.jetbrains.annotations.NotNull()
        private final android.graphics.Rect boundingBox = null;
        @org.jetbrains.annotations.NotNull()
        private final java.util.List<com.mlens.app.ml.ObjectDetectionProcessor.ObjectLabel> labels = null;
        @org.jetbrains.annotations.Nullable()
        private final java.lang.Integer trackingId = null;
        
        public DetectedObjectInfo(@org.jetbrains.annotations.NotNull()
        android.graphics.Rect boundingBox, @org.jetbrains.annotations.NotNull()
        java.util.List<com.mlens.app.ml.ObjectDetectionProcessor.ObjectLabel> labels, @org.jetbrains.annotations.Nullable()
        java.lang.Integer trackingId) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.graphics.Rect getBoundingBox() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<com.mlens.app.ml.ObjectDetectionProcessor.ObjectLabel> getLabels() {
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
        public final java.util.List<com.mlens.app.ml.ObjectDetectionProcessor.ObjectLabel> component2() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Integer component3() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.mlens.app.ml.ObjectDetectionProcessor.DetectedObjectInfo copy(@org.jetbrains.annotations.NotNull()
        android.graphics.Rect boundingBox, @org.jetbrains.annotations.NotNull()
        java.util.List<com.mlens.app.ml.ObjectDetectionProcessor.ObjectLabel> labels, @org.jetbrains.annotations.Nullable()
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
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003H\u00c6\u0003J\t\u0010\u0011\u001a\u00020\bH\u00c6\u0003J3\u0010\u0012\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bH\u00c6\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0016\u001a\u00020\u0017H\u00d6\u0001J\t\u0010\u0018\u001a\u00020\u0019H\u00d6\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000b\u00a8\u0006\u001a"}, d2 = {"Lcom/mlens/app/ml/ObjectDetectionProcessor$ObjectDetectionResult;", "", "objects", "", "Lcom/mlens/app/ml/ObjectDetectionProcessor$DetectedObjectInfo;", "sceneLabels", "Lcom/mlens/app/ml/ObjectDetectionProcessor$SceneLabel;", "overallConfidence", "", "(Ljava/util/List;Ljava/util/List;F)V", "getObjects", "()Ljava/util/List;", "getOverallConfidence", "()F", "getSceneLabels", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_debug"})
    public static final class ObjectDetectionResult {
        @org.jetbrains.annotations.NotNull()
        private final java.util.List<com.mlens.app.ml.ObjectDetectionProcessor.DetectedObjectInfo> objects = null;
        @org.jetbrains.annotations.NotNull()
        private final java.util.List<com.mlens.app.ml.ObjectDetectionProcessor.SceneLabel> sceneLabels = null;
        private final float overallConfidence = 0.0F;
        
        public ObjectDetectionResult(@org.jetbrains.annotations.NotNull()
        java.util.List<com.mlens.app.ml.ObjectDetectionProcessor.DetectedObjectInfo> objects, @org.jetbrains.annotations.NotNull()
        java.util.List<com.mlens.app.ml.ObjectDetectionProcessor.SceneLabel> sceneLabels, float overallConfidence) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<com.mlens.app.ml.ObjectDetectionProcessor.DetectedObjectInfo> getObjects() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<com.mlens.app.ml.ObjectDetectionProcessor.SceneLabel> getSceneLabels() {
            return null;
        }
        
        public final float getOverallConfidence() {
            return 0.0F;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<com.mlens.app.ml.ObjectDetectionProcessor.DetectedObjectInfo> component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<com.mlens.app.ml.ObjectDetectionProcessor.SceneLabel> component2() {
            return null;
        }
        
        public final float component3() {
            return 0.0F;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.mlens.app.ml.ObjectDetectionProcessor.ObjectDetectionResult copy(@org.jetbrains.annotations.NotNull()
        java.util.List<com.mlens.app.ml.ObjectDetectionProcessor.DetectedObjectInfo> objects, @org.jetbrains.annotations.NotNull()
        java.util.List<com.mlens.app.ml.ObjectDetectionProcessor.SceneLabel> sceneLabels, float overallConfidence) {
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
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000e\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0014\u001a\u00020\u0015H\u00d6\u0001J\t\u0010\u0016\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t\u00a8\u0006\u0017"}, d2 = {"Lcom/mlens/app/ml/ObjectDetectionProcessor$ObjectLabel;", "", "text", "", "confidence", "", "category", "(Ljava/lang/String;FLjava/lang/String;)V", "getCategory", "()Ljava/lang/String;", "getConfidence", "()F", "getText", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"})
    public static final class ObjectLabel {
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String text = null;
        private final float confidence = 0.0F;
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String category = null;
        
        public ObjectLabel(@org.jetbrains.annotations.NotNull()
        java.lang.String text, float confidence, @org.jetbrains.annotations.NotNull()
        java.lang.String category) {
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
        public final java.lang.String getCategory() {
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
        public final com.mlens.app.ml.ObjectDetectionProcessor.ObjectLabel copy(@org.jetbrains.annotations.NotNull()
        java.lang.String text, float confidence, @org.jetbrains.annotations.NotNull()
        java.lang.String category) {
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
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0011\u001a\u00020\u0012H\u00d6\u0001J\t\u0010\u0013\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0014"}, d2 = {"Lcom/mlens/app/ml/ObjectDetectionProcessor$SceneLabel;", "", "text", "", "confidence", "", "(Ljava/lang/String;F)V", "getConfidence", "()F", "getText", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"})
    public static final class SceneLabel {
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String text = null;
        private final float confidence = 0.0F;
        
        public SceneLabel(@org.jetbrains.annotations.NotNull()
        java.lang.String text, float confidence) {
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
        public final java.lang.String component1() {
            return null;
        }
        
        public final float component2() {
            return 0.0F;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.mlens.app.ml.ObjectDetectionProcessor.SceneLabel copy(@org.jetbrains.annotations.NotNull()
        java.lang.String text, float confidence) {
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