package com.mlens.app.utils

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Matrix
import android.media.ExifInterface
import android.net.Uri
import android.util.Log
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*

object ImageUtils {
    
    private const val TAG = "ImageUtils"
    private const val MAX_IMAGE_SIZE = 1024
    private const val JPEG_QUALITY = 85
    
    /**
     * Resize bitmap for ML processing to optimize performance
     */
    fun resizeForMLProcessing(bitmap: Bitmap, maxSize: Int = MAX_IMAGE_SIZE): Bitmap {
        val width = bitmap.width
        val height = bitmap.height
        
        if (width <= maxSize && height <= maxSize) {
            return bitmap
        }
        
        val ratio = if (width > height) {
            maxSize.toFloat() / width
        } else {
            maxSize.toFloat() / height
        }
        
        val newWidth = (width * ratio).toInt()
        val newHeight = (height * ratio).toInt()
        
        return Bitmap.createScaledBitmap(bitmap, newWidth, newHeight, true)
    }
    
    /**
     * Save bitmap to app's private storage
     */
    fun saveBitmapToInternalStorage(
        context: Context,
        bitmap: Bitmap,
        filename: String? = null
    ): String? {
        return try {
            val actualFilename = filename ?: generateImageFilename()
            val file = File(context.filesDir, "images")
            if (!file.exists()) {
                file.mkdirs()
            }
            
            val imageFile = File(file, actualFilename)
            val outputStream = FileOutputStream(imageFile)
            
            bitmap.compress(Bitmap.CompressFormat.JPEG, JPEG_QUALITY, outputStream)
            outputStream.flush()
            outputStream.close()
            
            imageFile.absolutePath
        } catch (e: IOException) {
            Log.e(TAG, "Failed to save bitmap to internal storage", e)
            null
        }
    }
    
    /**
     * Load bitmap from file path with proper orientation
     */
    fun loadBitmapFromPath(imagePath: String): Bitmap? {
        return try {
            val bitmap = BitmapFactory.decodeFile(imagePath) ?: return null
            
            // Handle image rotation based on EXIF data
            val exif = ExifInterface(imagePath)
            val orientation = exif.getAttributeInt(
                ExifInterface.TAG_ORIENTATION,
                ExifInterface.ORIENTATION_UNDEFINED
            )
            
            rotateBitmap(bitmap, orientation)
        } catch (e: Exception) {
            Log.e(TAG, "Failed to load bitmap from path: $imagePath", e)
            null
        }
    }
    
    /**
     * Load bitmap from URI with proper orientation (no auto-rotation)
     */
    fun loadBitmapFromUri(context: Context, uri: Uri): Bitmap? {
        return try {
            val inputStream = context.contentResolver.openInputStream(uri)
            val bitmap = BitmapFactory.decodeStream(inputStream)
            inputStream?.close()
            
            // Return bitmap as-is without any rotation correction
            // This preserves the original orientation as captured/selected
            bitmap
        } catch (e: Exception) {
            Log.e(TAG, "Failed to load bitmap from URI: $uri", e)
            null
        }
    }
    
    /**
     * Rotate bitmap based on EXIF orientation
     */
    private fun rotateBitmap(bitmap: Bitmap, orientation: Int): Bitmap {
        val matrix = Matrix()
        
        when (orientation) {
            ExifInterface.ORIENTATION_ROTATE_90 -> matrix.postRotate(90f)
            ExifInterface.ORIENTATION_ROTATE_180 -> matrix.postRotate(180f)
            ExifInterface.ORIENTATION_ROTATE_270 -> matrix.postRotate(270f)
            ExifInterface.ORIENTATION_FLIP_HORIZONTAL -> matrix.preScale(-1f, 1f)
            ExifInterface.ORIENTATION_FLIP_VERTICAL -> matrix.preScale(1f, -1f)
            else -> return bitmap
        }
        
        return try {
            val rotatedBitmap = Bitmap.createBitmap(
                bitmap, 0, 0, bitmap.width, bitmap.height, matrix, true
            )
            if (rotatedBitmap != bitmap) {
                bitmap.recycle()
            }
            rotatedBitmap
        } catch (e: OutOfMemoryError) {
            Log.e(TAG, "OutOfMemoryError while rotating bitmap", e)
            bitmap
        }
    }
    
    /**
     * Generate unique filename for images
     */
    fun generateImageFilename(): String {
        val timestamp = SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault())
            .format(Date())
        return "IMG_${timestamp}.jpg"
    }
    
    /**
     * Delete image file
     */
    fun deleteImageFile(imagePath: String): Boolean {
        return try {
            val file = File(imagePath)
            file.delete()
        } catch (e: Exception) {
            Log.e(TAG, "Failed to delete image file: $imagePath", e)
            false
        }
    }
    
    /**
     * Get image file size in bytes
     */
    fun getImageFileSize(imagePath: String): Long {
        return try {
            File(imagePath).length()
        } catch (e: Exception) {
            0L
        }
    }
    
    /**
     * Check if file exists
     */
    fun imageFileExists(imagePath: String): Boolean {
        return try {
            File(imagePath).exists()
        } catch (e: Exception) {
            false
        }
    }
}