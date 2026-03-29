package com.mlens.app.utils;

/**
 * Utility class for exporting and importing MLens database with password protection
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 )2\u00020\u0001:\u0003)*+B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J \u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000eJ\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\u000eH\u0086@\u00a2\u0006\u0002\u0010\u0015J\u0016\u0010\u0016\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\u000eH\u0086@\u00a2\u0006\u0002\u0010\u0015J \u0010\u0017\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\b0\u001cJ\u001e\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000eH\u0086@\u00a2\u0006\u0002\u0010 J\u001e\u0010!\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020#2\u0006\u0010\r\u001a\u00020\u000eH\u0086@\u00a2\u0006\u0002\u0010$J\u0010\u0010%\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010&\u001a\u00020\'2\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010(\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006,"}, d2 = {"Lcom/mlens/app/utils/DatabaseExporter;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "copyDatabaseFiles", "", "tempDir", "Ljava/io/File;", "copyImageFiles", "createEncryptedZip", "sourceDir", "zipFile", "password", "", "createMetadataFile", "deleteExport", "", "filePath", "exportDatabase", "Lcom/mlens/app/utils/DatabaseExporter$ExportResult;", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "exportDatabaseForSharing", "extractEncryptedZip", "destDir", "generateKeyFromPassword", "Ljavax/crypto/spec/SecretKeySpec;", "getAvailableExports", "", "importDatabase", "Lcom/mlens/app/utils/DatabaseExporter$ImportResult;", "zipFilePath", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "importDatabaseFromUri", "zipFileUri", "Landroid/net/Uri;", "(Landroid/net/Uri;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "restoreDatabaseFiles", "restoreImageFiles", "", "validateExportStructure", "Companion", "ExportResult", "ImportResult", "app_debug"})
public final class DatabaseExporter {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String TAG = "DatabaseExporter";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String EXPORT_FOLDER = "mlens_exports";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String DATABASE_NAME = "mlens_database";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String IMAGES_FOLDER = "images";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String METADATA_FILE = "export_metadata.json";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String ALGORITHM = "AES";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String TRANSFORMATION = "AES/ECB/PKCS5Padding";
    @org.jetbrains.annotations.NotNull()
    public static final com.mlens.app.utils.DatabaseExporter.Companion Companion = null;
    
    public DatabaseExporter(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    /**
     * Export entire database as password-protected ZIP file for sharing
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object exportDatabaseForSharing(@org.jetbrains.annotations.NotNull()
    java.lang.String password, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.mlens.app.utils.DatabaseExporter.ExportResult> $completion) {
        return null;
    }
    
    /**
     * Export entire database as password-protected ZIP file
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object exportDatabase(@org.jetbrains.annotations.NotNull()
    java.lang.String password, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.mlens.app.utils.DatabaseExporter.ExportResult> $completion) {
        return null;
    }
    
    /**
     * Import database from password-protected ZIP file using URI
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object importDatabaseFromUri(@org.jetbrains.annotations.NotNull()
    android.net.Uri zipFileUri, @org.jetbrains.annotations.NotNull()
    java.lang.String password, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.mlens.app.utils.DatabaseExporter.ImportResult> $completion) {
        return null;
    }
    
    /**
     * Import database from password-protected ZIP file
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object importDatabase(@org.jetbrains.annotations.NotNull()
    java.lang.String zipFilePath, @org.jetbrains.annotations.NotNull()
    java.lang.String password, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.mlens.app.utils.DatabaseExporter.ImportResult> $completion) {
        return null;
    }
    
    private final void copyDatabaseFiles(java.io.File tempDir) {
    }
    
    private final void copyImageFiles(java.io.File tempDir) {
    }
    
    private final void createMetadataFile(java.io.File tempDir) {
    }
    
    private final void createEncryptedZip(java.io.File sourceDir, java.io.File zipFile, java.lang.String password) {
    }
    
    private final void extractEncryptedZip(java.io.File zipFile, java.io.File destDir, java.lang.String password) {
    }
    
    private final boolean validateExportStructure(java.io.File tempDir) {
        return false;
    }
    
    private final void restoreDatabaseFiles(java.io.File tempDir) {
    }
    
    private final int restoreImageFiles(java.io.File tempDir) {
        return 0;
    }
    
    private final javax.crypto.spec.SecretKeySpec generateKeyFromPassword(java.lang.String password) {
        return null;
    }
    
    /**
     * Get list of available export files
     */
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.io.File> getAvailableExports() {
        return null;
    }
    
    /**
     * Delete export file
     */
    public final boolean deleteExport(@org.jetbrains.annotations.NotNull()
    java.lang.String filePath) {
        return false;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/mlens/app/utils/DatabaseExporter$Companion;", "", "()V", "ALGORITHM", "", "DATABASE_NAME", "EXPORT_FOLDER", "IMAGES_FOLDER", "METADATA_FILE", "TAG", "TRANSFORMATION", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J+\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u00c6\u0001J\u0013\u0010\u0011\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0013\u001a\u00020\u0014H\u00d6\u0001J\t\u0010\u0015\u001a\u00020\u0005H\u00d6\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0016"}, d2 = {"Lcom/mlens/app/utils/DatabaseExporter$ExportResult;", "", "success", "", "filePath", "", "error", "(ZLjava/lang/String;Ljava/lang/String;)V", "getError", "()Ljava/lang/String;", "getFilePath", "getSuccess", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "app_debug"})
    public static final class ExportResult {
        private final boolean success = false;
        @org.jetbrains.annotations.Nullable()
        private final java.lang.String filePath = null;
        @org.jetbrains.annotations.Nullable()
        private final java.lang.String error = null;
        
        public ExportResult(boolean success, @org.jetbrains.annotations.Nullable()
        java.lang.String filePath, @org.jetbrains.annotations.Nullable()
        java.lang.String error) {
            super();
        }
        
        public final boolean getSuccess() {
            return false;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getFilePath() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getError() {
            return null;
        }
        
        public final boolean component1() {
            return false;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String component2() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String component3() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.mlens.app.utils.DatabaseExporter.ExportResult copy(boolean success, @org.jetbrains.annotations.Nullable()
        java.lang.String filePath, @org.jetbrains.annotations.Nullable()
        java.lang.String error) {
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
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0005H\u00c6\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J)\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u00c6\u0001J\u0013\u0010\u0013\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0015\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\u0016\u001a\u00020\u0007H\u00d6\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0017"}, d2 = {"Lcom/mlens/app/utils/DatabaseExporter$ImportResult;", "", "success", "", "importedImages", "", "error", "", "(ZILjava/lang/String;)V", "getError", "()Ljava/lang/String;", "getImportedImages", "()I", "getSuccess", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "app_debug"})
    public static final class ImportResult {
        private final boolean success = false;
        private final int importedImages = 0;
        @org.jetbrains.annotations.Nullable()
        private final java.lang.String error = null;
        
        public ImportResult(boolean success, int importedImages, @org.jetbrains.annotations.Nullable()
        java.lang.String error) {
            super();
        }
        
        public final boolean getSuccess() {
            return false;
        }
        
        public final int getImportedImages() {
            return 0;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getError() {
            return null;
        }
        
        public final boolean component1() {
            return false;
        }
        
        public final int component2() {
            return 0;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String component3() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.mlens.app.utils.DatabaseExporter.ImportResult copy(boolean success, int importedImages, @org.jetbrains.annotations.Nullable()
        java.lang.String error) {
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