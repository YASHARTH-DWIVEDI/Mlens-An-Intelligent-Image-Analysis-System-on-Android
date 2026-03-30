package com.mlens.app.utils

import android.content.Context
import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.util.zip.ZipEntry
import java.util.zip.ZipInputStream
import java.util.zip.ZipOutputStream
import javax.crypto.Cipher
import javax.crypto.KeyGenerator
import javax.crypto.spec.SecretKeySpec
import java.security.MessageDigest
import java.text.SimpleDateFormat
import java.util.*

/**
 * Utility class for exporting and importing MLens database with password protection
 */
class DatabaseExporter(private val context: Context) {
    
    companion object {
        private const val TAG = "DatabaseExporter"
        private const val EXPORT_FOLDER = "mlens_exports"
        private const val DATABASE_NAME = "mlens_database"
        private const val IMAGES_FOLDER = "images"
        private const val METADATA_FILE = "export_metadata.json"
        private const val ALGORITHM = "AES"
        private const val TRANSFORMATION = "AES/ECB/PKCS5Padding"
    }
    
    data class ExportResult(
        val success: Boolean,
        val filePath: String? = null,
        val error: String? = null
    )
    
    data class ImportResult(
        val success: Boolean,
        val importedImages: Int = 0,
        val error: String? = null
    )
    
    /**
     * Export entire database as password-protected ZIP file for sharing
     */
    suspend fun exportDatabaseForSharing(password: String): ExportResult = withContext(Dispatchers.IO) {
        try {
            Log.d(TAG, "Starting database export for sharing")
            
            // Create export in external cache directory for sharing
            val exportDir = File(context.externalCacheDir, "exports")
            if (!exportDir.exists()) {
                exportDir.mkdirs()
            }
            
            // Generate export filename with timestamp
            val timestamp = SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(Date())
            val exportFile = File(exportDir, "mlens_backup_$timestamp.zip")
            
            // Create temporary directory for staging files
            val tempDir = File(context.cacheDir, "export_temp_$timestamp")
            if (tempDir.exists()) {
                tempDir.deleteRecursively()
            }
            tempDir.mkdirs()
            
            try {
                // Copy database files
                copyDatabaseFiles(tempDir)
                
                // Copy image files
                copyImageFiles(tempDir)
                
                // Create metadata file
                createMetadataFile(tempDir)
                
                // Create encrypted ZIP
                createEncryptedZip(tempDir, exportFile, password)
                
                Log.d(TAG, "Database export completed for sharing: ${exportFile.absolutePath}")
                ExportResult(true, exportFile.absolutePath)
                
            } finally {
                // Clean up temporary directory
                tempDir.deleteRecursively()
            }
            
        } catch (e: Exception) {
            Log.e(TAG, "Database export failed", e)
            ExportResult(false, error = e.message)
        }
    }

    /**
     * Export entire database as password-protected ZIP file
     */
    suspend fun exportDatabase(password: String): ExportResult = withContext(Dispatchers.IO) {
        try {
            Log.d(TAG, "Starting database export")
            
            // Create export directory
            val exportDir = File(context.getExternalFilesDir(null), EXPORT_FOLDER)
            if (!exportDir.exists()) {
                exportDir.mkdirs()
            }
            
            // Generate export filename with timestamp
            val timestamp = SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(Date())
            val exportFile = File(exportDir, "mlens_backup_$timestamp.zip")
            
            // Create temporary directory for staging files
            val tempDir = File(context.cacheDir, "export_temp_$timestamp")
            if (tempDir.exists()) {
                tempDir.deleteRecursively()
            }
            tempDir.mkdirs()
            
            try {
                // Copy database files
                copyDatabaseFiles(tempDir)
                
                // Copy image files
                copyImageFiles(tempDir)
                
                // Create metadata file
                createMetadataFile(tempDir)
                
                // Create encrypted ZIP
                createEncryptedZip(tempDir, exportFile, password)
                
                Log.d(TAG, "Database export completed: ${exportFile.absolutePath}")
                ExportResult(true, exportFile.absolutePath)
                
            } finally {
                // Clean up temporary directory
                tempDir.deleteRecursively()
            }
            
        } catch (e: Exception) {
            Log.e(TAG, "Database export failed", e)
            ExportResult(false, error = e.message)
        }
    }
    
    /**
     * Import database from password-protected ZIP file using URI
     */
    suspend fun importDatabaseFromUri(zipFileUri: android.net.Uri, password: String): ImportResult = withContext(Dispatchers.IO) {
        try {
            Log.d(TAG, "Starting database import from URI: $zipFileUri")
            
            // Create temporary directory for extraction
            val timestamp = SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(Date())
            val tempDir = File(context.cacheDir, "import_temp_$timestamp")
            if (tempDir.exists()) {
                tempDir.deleteRecursively()
            }
            tempDir.mkdirs()
            
            // Copy URI content to temporary file
            val tempZipFile = File(tempDir, "import.zip")
            context.contentResolver.openInputStream(zipFileUri)?.use { inputStream ->
                tempZipFile.outputStream().use { outputStream ->
                    inputStream.copyTo(outputStream)
                }
            } ?: return@withContext ImportResult(false, error = "Could not read selected file")
            
            try {
                // Extract encrypted ZIP
                extractEncryptedZip(tempZipFile, tempDir, password)
                
                // Validate export structure
                if (!validateExportStructure(tempDir)) {
                    return@withContext ImportResult(false, error = "Invalid MLens backup file structure")
                }
                
                // Import database
                restoreDatabaseFiles(tempDir)
                
                // Import images
                val importedCount = restoreImageFiles(tempDir)
                
                Log.d(TAG, "Database import completed. Imported $importedCount images")
                ImportResult(true, importedCount)
                
            } finally {
                // Clean up temporary directory
                tempDir.deleteRecursively()
            }
            
        } catch (e: Exception) {
            Log.e(TAG, "Database import failed", e)
            when {
                e.message?.contains("BadPaddingException") == true || 
                e.message?.contains("AEADBadTagException") == true -> {
                    ImportResult(false, error = "Invalid password or corrupted backup file")
                }
                e.message?.contains("ZipException") == true -> {
                    ImportResult(false, error = "Invalid or corrupted ZIP file")
                }
                else -> ImportResult(false, error = e.message)
            }
        }
    }

    /**
     * Import database from password-protected ZIP file
     */
    suspend fun importDatabase(zipFilePath: String, password: String): ImportResult = withContext(Dispatchers.IO) {
        try {
            Log.d(TAG, "Starting database import from: $zipFilePath")
            
            val zipFile = File(zipFilePath)
            if (!zipFile.exists()) {
                return@withContext ImportResult(false, error = "Export file not found")
            }
            
            // Create temporary directory for extraction
            val timestamp = SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(Date())
            val tempDir = File(context.cacheDir, "import_temp_$timestamp")
            if (tempDir.exists()) {
                tempDir.deleteRecursively()
            }
            tempDir.mkdirs()
            
            try {
                // Extract encrypted ZIP
                extractEncryptedZip(zipFile, tempDir, password)
                
                // Validate export structure
                if (!validateExportStructure(tempDir)) {
                    return@withContext ImportResult(false, error = "Invalid export file structure")
                }
                
                // Import database
                restoreDatabaseFiles(tempDir)
                
                // Import images
                val importedCount = restoreImageFiles(tempDir)
                
                Log.d(TAG, "Database import completed. Imported $importedCount images")
                ImportResult(true, importedCount)
                
            } finally {
                // Clean up temporary directory
                tempDir.deleteRecursively()
            }
            
        } catch (e: Exception) {
            Log.e(TAG, "Database import failed", e)
            ImportResult(false, error = e.message)
        }
    }
    
    private fun copyDatabaseFiles(tempDir: File) {
        val dbDir = File(tempDir, "database")
        dbDir.mkdirs()
        
        // Copy main database file
        val dbPath = context.getDatabasePath(DATABASE_NAME)
        if (dbPath.exists()) {
            dbPath.copyTo(File(dbDir, DATABASE_NAME), overwrite = true)
        }
        
        // Copy WAL and SHM files if they exist
        val walFile = File(dbPath.parent, "${DATABASE_NAME}-wal")
        if (walFile.exists()) {
            walFile.copyTo(File(dbDir, "${DATABASE_NAME}-wal"), overwrite = true)
        }
        
        val shmFile = File(dbPath.parent, "${DATABASE_NAME}-shm")
        if (shmFile.exists()) {
            shmFile.copyTo(File(dbDir, "${DATABASE_NAME}-shm"), overwrite = true)
        }
    }
    
    private fun copyImageFiles(tempDir: File) {
        val imagesDir = File(tempDir, IMAGES_FOLDER)
        imagesDir.mkdirs()
        
        val sourceImagesDir = File(context.filesDir, IMAGES_FOLDER)
        if (sourceImagesDir.exists()) {
            sourceImagesDir.copyRecursively(imagesDir, overwrite = true)
        }
    }
    
    private fun createMetadataFile(tempDir: File) {
        val metadata = """
            {
                "export_version": "1.0",
                "app_version": "${context.packageManager.getPackageInfo(context.packageName, 0).versionName}",
                "export_date": "${SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(Date())}",
                "device_model": "${android.os.Build.MODEL}",
                "android_version": "${android.os.Build.VERSION.RELEASE}"
            }
        """.trimIndent()
        
        File(tempDir, METADATA_FILE).writeText(metadata)
    }
    
    private fun createEncryptedZip(sourceDir: File, zipFile: File, password: String) {
        val key = generateKeyFromPassword(password)
        val cipher = Cipher.getInstance(TRANSFORMATION)
        cipher.init(Cipher.ENCRYPT_MODE, key)
        
        ZipOutputStream(FileOutputStream(zipFile)).use { zipOut ->
            sourceDir.walkTopDown().forEach { file ->
                if (file.isFile) {
                    val relativePath = sourceDir.toURI().relativize(file.toURI()).path
                    val zipEntry = ZipEntry(relativePath)
                    zipOut.putNextEntry(zipEntry)
                    
                    // Encrypt file content
                    val fileBytes = file.readBytes()
                    val encryptedBytes = cipher.doFinal(fileBytes)
                    zipOut.write(encryptedBytes)
                    
                    zipOut.closeEntry()
                }
            }
        }
    }
    
    private fun extractEncryptedZip(zipFile: File, destDir: File, password: String) {
        val key = generateKeyFromPassword(password)
        val cipher = Cipher.getInstance(TRANSFORMATION)
        cipher.init(Cipher.DECRYPT_MODE, key)
        
        ZipInputStream(FileInputStream(zipFile)).use { zipIn ->
            var entry = zipIn.nextEntry
            while (entry != null) {
                val file = File(destDir, entry.name)
                file.parentFile?.mkdirs()
                
                if (!entry.isDirectory) {
                    // Read encrypted content
                    val encryptedBytes = zipIn.readBytes()
                    
                    // Decrypt content
                    val decryptedBytes = cipher.doFinal(encryptedBytes)
                    
                    // Write to file
                    file.writeBytes(decryptedBytes)
                }
                
                zipIn.closeEntry()
                entry = zipIn.nextEntry
            }
        }
    }
    
    private fun validateExportStructure(tempDir: File): Boolean {
        val requiredFiles = listOf(
            File(tempDir, "database/$DATABASE_NAME"),
            File(tempDir, METADATA_FILE)
        )
        
        return requiredFiles.all { it.exists() }
    }
    
    private fun restoreDatabaseFiles(tempDir: File) {
        val dbDir = File(tempDir, "database")
        val targetDbPath = context.getDatabasePath(DATABASE_NAME)
        
        Log.d(TAG, "Restoring database files from: ${dbDir.absolutePath}")
        Log.d(TAG, "Target database path: ${targetDbPath.absolutePath}")
        
        // Ensure target directory exists
        targetDbPath.parentFile?.mkdirs()
        
        // Close any existing database connections first
        try {
            // Force close any open database connections
            android.database.sqlite.SQLiteDatabase.releaseMemory()
        } catch (e: Exception) {
            Log.w(TAG, "Could not release database memory", e)
        }
        
        // Delete existing database files first
        targetDbPath.delete()
        File(targetDbPath.parent, "${DATABASE_NAME}-wal").delete()
        File(targetDbPath.parent, "${DATABASE_NAME}-shm").delete()
        
        // Copy database files
        val sourceDb = File(dbDir, DATABASE_NAME)
        if (sourceDb.exists()) {
            sourceDb.copyTo(targetDbPath, overwrite = true)
            Log.d(TAG, "Copied main database file: ${sourceDb.length()} bytes")
        } else {
            throw Exception("Source database file not found: ${sourceDb.absolutePath}")
        }
        
        val walFile = File(dbDir, "${DATABASE_NAME}-wal")
        if (walFile.exists()) {
            walFile.copyTo(File(targetDbPath.parent, "${DATABASE_NAME}-wal"), overwrite = true)
            Log.d(TAG, "Copied WAL file: ${walFile.length()} bytes")
        }
        
        val shmFile = File(dbDir, "${DATABASE_NAME}-shm")
        if (shmFile.exists()) {
            shmFile.copyTo(File(targetDbPath.parent, "${DATABASE_NAME}-shm"), overwrite = true)
            Log.d(TAG, "Copied SHM file: ${shmFile.length()} bytes")
        }
        
        // Verify the restored database
        try {
            val db = android.database.sqlite.SQLiteDatabase.openDatabase(
                targetDbPath.absolutePath, 
                null, 
                android.database.sqlite.SQLiteDatabase.OPEN_READONLY
            )
            val cursor = db.rawQuery("SELECT COUNT(*) FROM images", null)
            cursor.moveToFirst()
            val count = cursor.getInt(0)
            cursor.close()
            db.close()
            Log.d(TAG, "Verified restored database: $count images found")
        } catch (e: Exception) {
            Log.e(TAG, "Failed to verify restored database", e)
            throw Exception("Database restoration verification failed: ${e.message}")
        }
    }
    
    private fun restoreImageFiles(tempDir: File): Int {
        val sourceImagesDir = File(tempDir, IMAGES_FOLDER)
        val targetImagesDir = File(context.filesDir, IMAGES_FOLDER)
        
        if (!sourceImagesDir.exists()) {
            return 0
        }
        
        targetImagesDir.mkdirs()
        var count = 0
        
        sourceImagesDir.walkTopDown().forEach { file ->
            if (file.isFile && file.extension.lowercase() in listOf("jpg", "jpeg", "png")) {
                val targetFile = File(targetImagesDir, file.name)
                file.copyTo(targetFile, overwrite = true)
                count++
            }
        }
        
        return count
    }
    
    private fun generateKeyFromPassword(password: String): SecretKeySpec {
        val digest = MessageDigest.getInstance("SHA-256")
        val keyBytes = digest.digest(password.toByteArray())
        return SecretKeySpec(keyBytes, ALGORITHM)
    }
    
    /**
     * Get list of available export files
     */
    fun getAvailableExports(): List<File> {
        val exportDir = File(context.getExternalFilesDir(null), EXPORT_FOLDER)
        if (!exportDir.exists()) {
            return emptyList()
        }
        
        return exportDir.listFiles { file ->
            file.isFile && file.extension == "zip" && file.name.startsWith("mlens_backup_")
        }?.sortedByDescending { it.lastModified() } ?: emptyList()
    }
    
    /**
     * Delete export file
     */
    fun deleteExport(filePath: String): Boolean {
        return try {
            File(filePath).delete()
        } catch (e: Exception) {
            Log.e(TAG, "Failed to delete export file", e)
            false
        }
    }
}
