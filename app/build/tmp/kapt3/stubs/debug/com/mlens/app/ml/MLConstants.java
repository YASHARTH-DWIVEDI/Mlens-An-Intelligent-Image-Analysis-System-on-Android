package com.mlens.app.ml;

/**
 * Centralized constants for ML processing
 * Makes it easier to tune and maintain ML parameters
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u000b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000bX\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/mlens/app/ml/MLConstants;", "", "()V", "BITMAP_QUALITY", "", "DOCUMENT_KEYWORDS", "", "", "getDOCUMENT_KEYWORDS", "()Ljava/util/List;", "HIGH_CONFIDENCE_THRESHOLD", "", "MAX_IMAGE_DIMENSION", "MIN_CLASSIFICATION_CONFIDENCE", "MIN_OBJECT_CONFIDENCE", "MIN_OCR_CONFIDENCE", "MIN_SCENE_CONFIDENCE", "MIN_SUMMARY_TEXT_LENGTH", "MIN_VALID_TEXT_LENGTH", "YOLO_CONFIDENCE_THRESHOLD", "YOLO_INPUT_SIZE", "YOLO_IOU_THRESHOLD", "app_debug"})
public final class MLConstants {
    public static final float MIN_OCR_CONFIDENCE = 0.5F;
    public static final float MIN_OBJECT_CONFIDENCE = 0.6F;
    public static final float MIN_CLASSIFICATION_CONFIDENCE = 0.5F;
    public static final float MIN_SCENE_CONFIDENCE = 0.5F;
    public static final float HIGH_CONFIDENCE_THRESHOLD = 0.7F;
    public static final int MIN_SUMMARY_TEXT_LENGTH = 50;
    public static final int MIN_VALID_TEXT_LENGTH = 5;
    @org.jetbrains.annotations.NotNull()
    private static final java.util.List<java.lang.String> DOCUMENT_KEYWORDS = null;
    public static final int MAX_IMAGE_DIMENSION = 1024;
    public static final int BITMAP_QUALITY = 90;
    public static final int YOLO_INPUT_SIZE = 640;
    public static final float YOLO_CONFIDENCE_THRESHOLD = 0.45F;
    public static final float YOLO_IOU_THRESHOLD = 0.45F;
    @org.jetbrains.annotations.NotNull()
    public static final com.mlens.app.ml.MLConstants INSTANCE = null;
    
    private MLConstants() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getDOCUMENT_KEYWORDS() {
        return null;
    }
}