package com.mlens.app.ml;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 W2\u00020\u0001:\u0007TUVWXYZB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0016\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0016\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0016\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0086@\u00a2\u0006\u0002\u0010 J\u001c\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00160\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0082@\u00a2\u0006\u0002\u0010 J\u001c\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00160\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0082@\u00a2\u0006\u0002\u0010 J\u001c\u0010#\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0082@\u00a2\u0006\u0002\u0010 J\u0010\u0010$\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020\u000bH\u0002J\u0006\u0010&\u001a\u00020\'J \u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020)2\u0006\u0010-\u001a\u00020)H\u0002J \u0010.\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020)2\u0006\u0010-\u001a\u00020)H\u0002J\u0010\u0010/\u001a\u00020\u00132\u0006\u0010*\u001a\u00020+H\u0002J\u0010\u00100\u001a\u00020\u00132\u0006\u0010*\u001a\u00020+H\u0002J\u001c\u00101\u001a\b\u0012\u0004\u0012\u00020\u00160\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0082@\u00a2\u0006\u0002\u0010 J\u0010\u00102\u001a\u00020\u00132\u0006\u0010*\u001a\u00020+H\u0002J \u00103\u001a\u00020\u00132\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020)2\u0006\u0010-\u001a\u00020)H\u0002J \u00104\u001a\u00020\u00132\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020)2\u0006\u0010-\u001a\u00020)H\u0002J\u0010\u00105\u001a\u00020\u00132\u0006\u0010*\u001a\u00020+H\u0002J \u00106\u001a\u00020\u00132\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020)2\u0006\u0010-\u001a\u00020)H\u0002J \u00107\u001a\u00020\u00132\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020)2\u0006\u0010-\u001a\u00020)H\u0002J\u0016\u00108\u001a\b\u0012\u0004\u0012\u00020\u00160\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u001c\u00109\u001a\b\u0012\u0004\u0012\u00020\u00160\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0082@\u00a2\u0006\u0002\u0010 J$\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00160\n2\f\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00160\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010<\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J$\u0010=\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\f\u0010>\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J$\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00160\n2\f\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00160\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010@\u001a\u00020\u001f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u001e\u0010A\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010B\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010C\u001a\u00020)2\u0006\u0010D\u001a\u00020)H\u0002J\u0016\u0010E\u001a\b\u0012\u0004\u0012\u00020\u00160\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\b\u0010F\u001a\u00020\'H\u0002J\u000e\u0010G\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002J\b\u0010H\u001a\u00020IH\u0002J\u0010\u0010J\u001a\u00020\u000b2\u0006\u0010K\u001a\u00020\u000bH\u0002J\u0010\u0010L\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0016\u0010M\u001a\b\u0012\u0004\u0012\u00020\u00160\n2\u0006\u0010N\u001a\u00020OH\u0002J\u0010\u0010P\u001a\u00020Q2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010R\u001a\u00020O2\u0006\u0010S\u001a\u00020QH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006["}, d2 = {"Lcom/mlens/app/ml/ImageClassificationProcessor;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "imageProcessor", "Lorg/tensorflow/lite/support/image/ImageProcessor;", "interpreter", "Lorg/tensorflow/lite/Interpreter;", "labels", "", "", "analyzeAdvancedContext", "Lcom/mlens/app/ml/ImageClassificationProcessor$ContextAnalysis;", "bitmap", "Landroid/graphics/Bitmap;", "analyzeBasicImageProperties", "Lcom/mlens/app/ml/ImageClassificationProcessor$BasicImageAnalysis;", "analyzeColorDistribution", "", "analyzeImageColors", "analyzeImageContext", "Lcom/mlens/app/ml/ImageClassificationProcessor$ClassificationLabel;", "analyzeImageFeatures", "Lcom/mlens/app/ml/ImageClassificationProcessor$ImageFeatureAnalysis;", "analyzeShapes", "Lcom/mlens/app/ml/ImageClassificationProcessor$ShapeAnalysis;", "analyzeVisualProperties", "calculateImageBrightness", "", "classifyImage", "Lcom/mlens/app/ml/ImageClassificationProcessor$ClassificationResult;", "(Landroid/graphics/Bitmap;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "classifyWithDifferentSettings", "classifyWithEnhancedMLKit", "classifyWithMLKit", "cleanLabelText", "text", "cleanup", "", "countCircularShapes", "", "pixels", "", "width", "height", "countRectangularShapes", "detectAutomotiveColorScheme", "detectAutomotiveColors", "detectAutomotiveElements", "detectBacklighting", "detectCircularPatterns", "detectDigitalDisplay", "detectLEDCharacteristics", "detectNeedlePattern", "detectRadialPattern", "detectShapesAndPatterns", "detectTextElements", "enhanceAndFilterResults", "results", "enhanceImageContrast", "enhanceMLKitResults", "mlKitLabels", "enhanceResultsIntelligently", "fallbackClassification", "generateSmartContextualTags", "labelText", "getPixelBrightness", "pixel", "improvedFallbackClassification", "initializeModel", "loadLabels", "loadModelFile", "Ljava/nio/MappedByteBuffer;", "normalizeLabel", "label", "optimizeImageForML", "postprocessResults", "predictions", "", "preprocessImage", "Lorg/tensorflow/lite/support/image/TensorImage;", "runInference", "tensorImage", "BasicImageAnalysis", "ClassificationLabel", "ClassificationResult", "Companion", "ContextAnalysis", "ImageFeatureAnalysis", "ShapeAnalysis", "app_debug"})
public final class ImageClassificationProcessor {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.Nullable()
    private org.tensorflow.lite.Interpreter interpreter;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<java.lang.String> labels;
    @org.jetbrains.annotations.Nullable()
    private org.tensorflow.lite.support.image.ImageProcessor imageProcessor;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String TAG = "ImageClassificationProcessor";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String MODEL_PATH = "mobilenet_v1_1.0_224.tflite";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String LABELS_PATH = "labels.txt";
    private static final int IMAGE_SIZE = 224;
    private static final int MAX_RESULTS = 5;
    private static final float CONFIDENCE_THRESHOLD = 0.1F;
    @org.jetbrains.annotations.NotNull()
    public static final com.mlens.app.ml.ImageClassificationProcessor.Companion Companion = null;
    
    public ImageClassificationProcessor(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    private final void initializeModel() {
    }
    
    private final java.nio.MappedByteBuffer loadModelFile() {
        return null;
    }
    
    private final java.util.List<java.lang.String> loadLabels() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object classifyImage(@org.jetbrains.annotations.NotNull()
    android.graphics.Bitmap bitmap, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.mlens.app.ml.ImageClassificationProcessor.ClassificationResult> $completion) {
        return null;
    }
    
    private final android.graphics.Bitmap optimizeImageForML(android.graphics.Bitmap bitmap) {
        return null;
    }
    
    private final android.graphics.Bitmap enhanceImageContrast(android.graphics.Bitmap bitmap) {
        return null;
    }
    
    private final java.lang.Object classifyWithEnhancedMLKit(android.graphics.Bitmap bitmap, kotlin.coroutines.Continuation<? super java.util.List<com.mlens.app.ml.ImageClassificationProcessor.ClassificationLabel>> $completion) {
        return null;
    }
    
    private final java.util.List<com.mlens.app.ml.ImageClassificationProcessor.ClassificationLabel> enhanceResultsIntelligently(java.util.List<com.mlens.app.ml.ImageClassificationProcessor.ClassificationLabel> results, android.graphics.Bitmap bitmap) {
        return null;
    }
    
    private final java.util.List<com.mlens.app.ml.ImageClassificationProcessor.ClassificationLabel> improvedFallbackClassification(android.graphics.Bitmap bitmap) {
        return null;
    }
    
    private final java.lang.String cleanLabelText(java.lang.String text) {
        return null;
    }
    
    private final java.lang.String normalizeLabel(java.lang.String label) {
        return null;
    }
    
    private final com.mlens.app.ml.ImageClassificationProcessor.BasicImageAnalysis analyzeBasicImageProperties(android.graphics.Bitmap bitmap) {
        return null;
    }
    
    private final java.lang.Object classifyWithDifferentSettings(android.graphics.Bitmap bitmap, kotlin.coroutines.Continuation<? super java.util.List<com.mlens.app.ml.ImageClassificationProcessor.ClassificationLabel>> $completion) {
        return null;
    }
    
    private final java.lang.Object classifyWithMLKit(android.graphics.Bitmap bitmap, kotlin.coroutines.Continuation<? super java.util.List<java.lang.String>> $completion) {
        return null;
    }
    
    private final java.util.List<java.lang.String> enhanceMLKitResults(java.util.List<java.lang.String> mlKitLabels, android.graphics.Bitmap bitmap) {
        return null;
    }
    
    private final java.util.List<java.lang.String> generateSmartContextualTags(java.lang.String labelText, android.graphics.Bitmap bitmap) {
        return null;
    }
    
    private final java.util.List<java.lang.String> analyzeVisualProperties(android.graphics.Bitmap bitmap) {
        return null;
    }
    
    private final java.util.List<java.lang.String> analyzeImageColors(android.graphics.Bitmap bitmap) {
        return null;
    }
    
    private final float calculateImageBrightness(android.graphics.Bitmap bitmap) {
        return 0.0F;
    }
    
    private final com.mlens.app.ml.ImageClassificationProcessor.ImageFeatureAnalysis analyzeImageFeatures(android.graphics.Bitmap bitmap) {
        return null;
    }
    
    private final com.mlens.app.ml.ImageClassificationProcessor.ShapeAnalysis analyzeShapes(android.graphics.Bitmap bitmap) {
        return null;
    }
    
    private final com.mlens.app.ml.ImageClassificationProcessor.ContextAnalysis analyzeAdvancedContext(android.graphics.Bitmap bitmap) {
        return null;
    }
    
    private final boolean detectCircularPatterns(int[] pixels, int width, int height) {
        return false;
    }
    
    private final boolean detectDigitalDisplay(int[] pixels, int width, int height) {
        return false;
    }
    
    private final boolean detectNeedlePattern(int[] pixels, int width, int height) {
        return false;
    }
    
    private final boolean detectAutomotiveColors(int[] pixels) {
        return false;
    }
    
    private final int getPixelBrightness(int pixel) {
        return 0;
    }
    
    private final int countCircularShapes(int[] pixels, int width, int height) {
        return 0;
    }
    
    private final int countRectangularShapes(int[] pixels, int width, int height) {
        return 0;
    }
    
    private final boolean detectRadialPattern(int[] pixels, int width, int height) {
        return false;
    }
    
    private final boolean detectBacklighting(int[] pixels) {
        return false;
    }
    
    private final boolean detectLEDCharacteristics(int[] pixels) {
        return false;
    }
    
    private final boolean detectAutomotiveColorScheme(int[] pixels) {
        return false;
    }
    
    private final java.lang.Object detectAutomotiveElements(android.graphics.Bitmap bitmap, kotlin.coroutines.Continuation<? super java.util.List<com.mlens.app.ml.ImageClassificationProcessor.ClassificationLabel>> $completion) {
        return null;
    }
    
    private final java.lang.Object detectTextElements(android.graphics.Bitmap bitmap, kotlin.coroutines.Continuation<? super java.util.List<com.mlens.app.ml.ImageClassificationProcessor.ClassificationLabel>> $completion) {
        return null;
    }
    
    private final java.util.List<com.mlens.app.ml.ImageClassificationProcessor.ClassificationLabel> detectShapesAndPatterns(android.graphics.Bitmap bitmap) {
        return null;
    }
    
    private final java.util.List<com.mlens.app.ml.ImageClassificationProcessor.ClassificationLabel> analyzeImageContext(android.graphics.Bitmap bitmap) {
        return null;
    }
    
    private final java.util.List<com.mlens.app.ml.ImageClassificationProcessor.ClassificationLabel> enhanceAndFilterResults(java.util.List<com.mlens.app.ml.ImageClassificationProcessor.ClassificationLabel> results, android.graphics.Bitmap bitmap) {
        return null;
    }
    
    private final org.tensorflow.lite.support.image.TensorImage preprocessImage(android.graphics.Bitmap bitmap) {
        return null;
    }
    
    private final float[] runInference(org.tensorflow.lite.support.image.TensorImage tensorImage) {
        return null;
    }
    
    private final java.util.List<com.mlens.app.ml.ImageClassificationProcessor.ClassificationLabel> postprocessResults(float[] predictions) {
        return null;
    }
    
    private final com.mlens.app.ml.ImageClassificationProcessor.ClassificationResult fallbackClassification(android.graphics.Bitmap bitmap) {
        return null;
    }
    
    private final boolean analyzeColorDistribution(android.graphics.Bitmap bitmap) {
        return false;
    }
    
    public final void cleanup() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000e\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000f\u001a\u00020\u0006H\u00c6\u0003J\'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u00c6\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0014\u001a\u00020\u0015H\u00d6\u0001J\t\u0010\u0016\u001a\u00020\u0006H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0017"}, d2 = {"Lcom/mlens/app/ml/ImageClassificationProcessor$BasicImageAnalysis;", "", "aspectRatio", "", "brightness", "dominantColor", "", "(FFLjava/lang/String;)V", "getAspectRatio", "()F", "getBrightness", "getDominantColor", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"})
    public static final class BasicImageAnalysis {
        private final float aspectRatio = 0.0F;
        private final float brightness = 0.0F;
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String dominantColor = null;
        
        public BasicImageAnalysis(float aspectRatio, float brightness, @org.jetbrains.annotations.NotNull()
        java.lang.String dominantColor) {
            super();
        }
        
        public final float getAspectRatio() {
            return 0.0F;
        }
        
        public final float getBrightness() {
            return 0.0F;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getDominantColor() {
            return null;
        }
        
        public final float component1() {
            return 0.0F;
        }
        
        public final float component2() {
            return 0.0F;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component3() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.mlens.app.ml.ImageClassificationProcessor.BasicImageAnalysis copy(float aspectRatio, float brightness, @org.jetbrains.annotations.NotNull()
        java.lang.String dominantColor) {
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
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0011\u001a\u00020\u0012H\u00d6\u0001J\t\u0010\u0013\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0014"}, d2 = {"Lcom/mlens/app/ml/ImageClassificationProcessor$ClassificationLabel;", "", "label", "", "confidence", "", "(Ljava/lang/String;F)V", "getConfidence", "()F", "getLabel", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"})
    public static final class ClassificationLabel {
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String label = null;
        private final float confidence = 0.0F;
        
        public ClassificationLabel(@org.jetbrains.annotations.NotNull()
        java.lang.String label, float confidence) {
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
        public final java.lang.String component1() {
            return null;
        }
        
        public final float component2() {
            return 0.0F;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.mlens.app.ml.ImageClassificationProcessor.ClassificationLabel copy(@org.jetbrains.annotations.NotNull()
        java.lang.String label, float confidence) {
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
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u0011"}, d2 = {"Lcom/mlens/app/ml/ImageClassificationProcessor$ClassificationResult;", "", "labels", "", "Lcom/mlens/app/ml/ImageClassificationProcessor$ClassificationLabel;", "(Ljava/util/List;)V", "getLabels", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_debug"})
    public static final class ClassificationResult {
        @org.jetbrains.annotations.NotNull()
        private final java.util.List<com.mlens.app.ml.ImageClassificationProcessor.ClassificationLabel> labels = null;
        
        public ClassificationResult(@org.jetbrains.annotations.NotNull()
        java.util.List<com.mlens.app.ml.ImageClassificationProcessor.ClassificationLabel> labels) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<com.mlens.app.ml.ImageClassificationProcessor.ClassificationLabel> getLabels() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<com.mlens.app.ml.ImageClassificationProcessor.ClassificationLabel> component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.mlens.app.ml.ImageClassificationProcessor.ClassificationResult copy(@org.jetbrains.annotations.NotNull()
        java.util.List<com.mlens.app.ml.ImageClassificationProcessor.ClassificationLabel> labels) {
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
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/mlens/app/ml/ImageClassificationProcessor$Companion;", "", "()V", "CONFIDENCE_THRESHOLD", "", "IMAGE_SIZE", "", "LABELS_PATH", "", "MAX_RESULTS", "MODEL_PATH", "TAG", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0011\u001a\u00020\u0012H\u00d6\u0001J\t\u0010\u0013\u001a\u00020\u0014H\u00d6\u0001R\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b\u00a8\u0006\u0015"}, d2 = {"Lcom/mlens/app/ml/ImageClassificationProcessor$ContextAnalysis;", "", "hasBacklighting", "", "hasLEDCharacteristics", "hasAutomotiveColorScheme", "(ZZZ)V", "getHasAutomotiveColorScheme", "()Z", "getHasBacklighting", "getHasLEDCharacteristics", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "app_debug"})
    public static final class ContextAnalysis {
        private final boolean hasBacklighting = false;
        private final boolean hasLEDCharacteristics = false;
        private final boolean hasAutomotiveColorScheme = false;
        
        public ContextAnalysis(boolean hasBacklighting, boolean hasLEDCharacteristics, boolean hasAutomotiveColorScheme) {
            super();
        }
        
        public final boolean getHasBacklighting() {
            return false;
        }
        
        public final boolean getHasLEDCharacteristics() {
            return false;
        }
        
        public final boolean getHasAutomotiveColorScheme() {
            return false;
        }
        
        public final boolean component1() {
            return false;
        }
        
        public final boolean component2() {
            return false;
        }
        
        public final boolean component3() {
            return false;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.mlens.app.ml.ImageClassificationProcessor.ContextAnalysis copy(boolean hasBacklighting, boolean hasLEDCharacteristics, boolean hasAutomotiveColorScheme) {
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
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000e\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0003H\u00c6\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u0012\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0014\u001a\u00020\u0015H\u00d6\u0001J\t\u0010\u0016\u001a\u00020\u0017H\u00d6\u0001R\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t\u00a8\u0006\u0018"}, d2 = {"Lcom/mlens/app/ml/ImageClassificationProcessor$ImageFeatureAnalysis;", "", "hasCircularPatterns", "", "hasDigitalDisplay", "hasNeedlePattern", "hasAutomotiveColors", "(ZZZZ)V", "getHasAutomotiveColors", "()Z", "getHasCircularPatterns", "getHasDigitalDisplay", "getHasNeedlePattern", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "", "app_debug"})
    public static final class ImageFeatureAnalysis {
        private final boolean hasCircularPatterns = false;
        private final boolean hasDigitalDisplay = false;
        private final boolean hasNeedlePattern = false;
        private final boolean hasAutomotiveColors = false;
        
        public ImageFeatureAnalysis(boolean hasCircularPatterns, boolean hasDigitalDisplay, boolean hasNeedlePattern, boolean hasAutomotiveColors) {
            super();
        }
        
        public final boolean getHasCircularPatterns() {
            return false;
        }
        
        public final boolean getHasDigitalDisplay() {
            return false;
        }
        
        public final boolean getHasNeedlePattern() {
            return false;
        }
        
        public final boolean getHasAutomotiveColors() {
            return false;
        }
        
        public final boolean component1() {
            return false;
        }
        
        public final boolean component2() {
            return false;
        }
        
        public final boolean component3() {
            return false;
        }
        
        public final boolean component4() {
            return false;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.mlens.app.ml.ImageClassificationProcessor.ImageFeatureAnalysis copy(boolean hasCircularPatterns, boolean hasDigitalDisplay, boolean hasNeedlePattern, boolean hasAutomotiveColors) {
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
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000e\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000f\u001a\u00020\u0006H\u00c6\u0003J\'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u00c6\u0001J\u0013\u0010\u0011\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0013\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0014\u001a\u00020\u0015H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t\u00a8\u0006\u0016"}, d2 = {"Lcom/mlens/app/ml/ImageClassificationProcessor$ShapeAnalysis;", "", "circularShapes", "", "rectangularShapes", "hasRadialPattern", "", "(IIZ)V", "getCircularShapes", "()I", "getHasRadialPattern", "()Z", "getRectangularShapes", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "", "app_debug"})
    public static final class ShapeAnalysis {
        private final int circularShapes = 0;
        private final int rectangularShapes = 0;
        private final boolean hasRadialPattern = false;
        
        public ShapeAnalysis(int circularShapes, int rectangularShapes, boolean hasRadialPattern) {
            super();
        }
        
        public final int getCircularShapes() {
            return 0;
        }
        
        public final int getRectangularShapes() {
            return 0;
        }
        
        public final boolean getHasRadialPattern() {
            return false;
        }
        
        public final int component1() {
            return 0;
        }
        
        public final int component2() {
            return 0;
        }
        
        public final boolean component3() {
            return false;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.mlens.app.ml.ImageClassificationProcessor.ShapeAnalysis copy(int circularShapes, int rectangularShapes, boolean hasRadialPattern) {
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