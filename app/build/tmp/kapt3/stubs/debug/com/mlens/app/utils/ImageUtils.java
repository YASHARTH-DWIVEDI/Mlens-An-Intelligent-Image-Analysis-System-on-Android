package com.mlens.app.utils;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007J\u0006\u0010\u000b\u001a\u00020\u0007J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u0007J\u000e\u0010\u000e\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007J\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\n\u001a\u00020\u0007J\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\u0018\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00102\b\b\u0002\u0010\u0018\u001a\u00020\u0004J\u0018\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u0004H\u0002J$\u0010\u001b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00102\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001d"}, d2 = {"Lcom/mlens/app/utils/ImageUtils;", "", "()V", "JPEG_QUALITY", "", "MAX_IMAGE_SIZE", "TAG", "", "deleteImageFile", "", "imagePath", "generateImageFilename", "getImageFileSize", "", "imageFileExists", "loadBitmapFromPath", "Landroid/graphics/Bitmap;", "loadBitmapFromUri", "context", "Landroid/content/Context;", "uri", "Landroid/net/Uri;", "resizeForMLProcessing", "bitmap", "maxSize", "rotateBitmap", "orientation", "saveBitmapToInternalStorage", "filename", "app_debug"})
public final class ImageUtils {
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String TAG = "ImageUtils";
    private static final int MAX_IMAGE_SIZE = 1024;
    private static final int JPEG_QUALITY = 85;
    @org.jetbrains.annotations.NotNull()
    public static final com.mlens.app.utils.ImageUtils INSTANCE = null;
    
    private ImageUtils() {
        super();
    }
    
    /**
     * Resize bitmap for ML processing to optimize performance
     */
    @org.jetbrains.annotations.NotNull()
    public final android.graphics.Bitmap resizeForMLProcessing(@org.jetbrains.annotations.NotNull()
    android.graphics.Bitmap bitmap, int maxSize) {
        return null;
    }
    
    /**
     * Save bitmap to app's private storage
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String saveBitmapToInternalStorage(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    android.graphics.Bitmap bitmap, @org.jetbrains.annotations.Nullable()
    java.lang.String filename) {
        return null;
    }
    
    /**
     * Load bitmap from file path with proper orientation
     */
    @org.jetbrains.annotations.Nullable()
    public final android.graphics.Bitmap loadBitmapFromPath(@org.jetbrains.annotations.NotNull()
    java.lang.String imagePath) {
        return null;
    }
    
    /**
     * Load bitmap from URI with proper orientation (no auto-rotation)
     */
    @org.jetbrains.annotations.Nullable()
    public final android.graphics.Bitmap loadBitmapFromUri(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    android.net.Uri uri) {
        return null;
    }
    
    /**
     * Rotate bitmap based on EXIF orientation
     */
    private final android.graphics.Bitmap rotateBitmap(android.graphics.Bitmap bitmap, int orientation) {
        return null;
    }
    
    /**
     * Generate unique filename for images
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String generateImageFilename() {
        return null;
    }
    
    /**
     * Delete image file
     */
    public final boolean deleteImageFile(@org.jetbrains.annotations.NotNull()
    java.lang.String imagePath) {
        return false;
    }
    
    /**
     * Get image file size in bytes
     */
    public final long getImageFileSize(@org.jetbrains.annotations.NotNull()
    java.lang.String imagePath) {
        return 0L;
    }
    
    /**
     * Check if file exists
     */
    public final boolean imageFileExists(@org.jetbrains.annotations.NotNull()
    java.lang.String imagePath) {
        return false;
    }
}