package com.mlens.app.ml;

/**
 * Enhanced TensorFlow Lite object detector using the latest EfficientDet models
 * and optimized post-processing for high-quality object detection
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 )2\u00020\u0001:\u0002)*B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J$\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\n2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0018\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u0006\u0010\u0015\u001a\u00020\u0016J\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\r0\n2\u0006\u0010\u0018\u001a\u00020\u0019J\b\u0010\u001a\u001a\u00020\u0016H\u0002J\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002JI\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\r0\n2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 2\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020!2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020%2\u0006\u0010\'\u001a\u00020%H\u0002\u00a2\u0006\u0002\u0010(R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006+"}, d2 = {"Lcom/mlens/app/ml/EnhancedTensorFlowDetector;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "imageProcessor", "Lorg/tensorflow/lite/support/image/ImageProcessor;", "interpreter", "Lorg/tensorflow/lite/Interpreter;", "labels", "", "", "applyNMS", "Lcom/mlens/app/ml/EnhancedTensorFlowDetector$Detection;", "detections", "iouThreshold", "", "calculateIoU", "box1", "Landroid/graphics/Rect;", "box2", "cleanup", "", "detect", "bitmap", "Landroid/graphics/Bitmap;", "initializeModel", "isAvailable", "", "loadLabels", "processDetections", "boxes", "", "", "classes", "scores", "numDetections", "", "originalWidth", "originalHeight", "([[F[F[FIII)Ljava/util/List;", "Companion", "Detection", "app_debug"})
public final class EnhancedTensorFlowDetector {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.Nullable()
    private org.tensorflow.lite.Interpreter interpreter;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<java.lang.String> labels;
    @org.jetbrains.annotations.Nullable()
    private org.tensorflow.lite.support.image.ImageProcessor imageProcessor;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String TAG = "EnhancedTFDetector";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String MODEL_PATH = "efficientdet_d0.tflite";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String LABELS_PATH = "coco_labels.txt";
    private static final int INPUT_SIZE = 512;
    private static final int MAX_DETECTIONS = 100;
    private static final float SCORE_THRESHOLD = 0.3F;
    private static final float NMS_THRESHOLD = 0.5F;
    @org.jetbrains.annotations.NotNull()
    public static final com.mlens.app.ml.EnhancedTensorFlowDetector.Companion Companion = null;
    
    public EnhancedTensorFlowDetector(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    public final boolean isAvailable() {
        return false;
    }
    
    private final void initializeModel() {
    }
    
    private final java.util.List<java.lang.String> loadLabels() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.mlens.app.ml.EnhancedTensorFlowDetector.Detection> detect(@org.jetbrains.annotations.NotNull()
    android.graphics.Bitmap bitmap) {
        return null;
    }
    
    private final java.util.List<com.mlens.app.ml.EnhancedTensorFlowDetector.Detection> processDetections(float[][] boxes, float[] classes, float[] scores, int numDetections, int originalWidth, int originalHeight) {
        return null;
    }
    
    private final java.util.List<com.mlens.app.ml.EnhancedTensorFlowDetector.Detection> applyNMS(java.util.List<com.mlens.app.ml.EnhancedTensorFlowDetector.Detection> detections, float iouThreshold) {
        return null;
    }
    
    private final float calculateIoU(android.graphics.Rect box1, android.graphics.Rect box2) {
        return 0.0F;
    }
    
    public final void cleanup() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/mlens/app/ml/EnhancedTensorFlowDetector$Companion;", "", "()V", "INPUT_SIZE", "", "LABELS_PATH", "", "MAX_DETECTIONS", "MODEL_PATH", "NMS_THRESHOLD", "", "SCORE_THRESHOLD", "TAG", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\u0007H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\tH\u00c6\u0003J1\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u00c6\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001b\u001a\u00020\tH\u00d6\u0001J\t\u0010\u001c\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u001d"}, d2 = {"Lcom/mlens/app/ml/EnhancedTensorFlowDetector$Detection;", "", "label", "", "confidence", "", "boundingBox", "Landroid/graphics/Rect;", "classId", "", "(Ljava/lang/String;FLandroid/graphics/Rect;I)V", "getBoundingBox", "()Landroid/graphics/Rect;", "getClassId", "()I", "getConfidence", "()F", "getLabel", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "app_debug"})
    public static final class Detection {
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String label = null;
        private final float confidence = 0.0F;
        @org.jetbrains.annotations.NotNull()
        private final android.graphics.Rect boundingBox = null;
        private final int classId = 0;
        
        public Detection(@org.jetbrains.annotations.NotNull()
        java.lang.String label, float confidence, @org.jetbrains.annotations.NotNull()
        android.graphics.Rect boundingBox, int classId) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getLabel() {
            return null;
        }
        
        public final float getConfidence() {
            return 0.0F;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.graphics.Rect getBoundingBox() {
            return null;
        }
        
        public final int getClassId() {
            return 0;
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
        
        public final int component4() {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.mlens.app.ml.EnhancedTensorFlowDetector.Detection copy(@org.jetbrains.annotations.NotNull()
        java.lang.String label, float confidence, @org.jetbrains.annotations.NotNull()
        android.graphics.Rect boundingBox, int classId) {
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