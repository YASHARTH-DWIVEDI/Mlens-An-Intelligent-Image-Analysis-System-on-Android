package com.mlens.app.viewmodels;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001:\u0002+,B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010\u0014\u001a\u00020\u0015J\u0006\u0010\u0016\u001a\u00020\u0015J\u000e\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0019J$\u0010\u001a\u001a\u00020\u00152\b\b\u0002\u0010\u001b\u001a\u00020\u000b2\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00150\u001dJ&\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010\u001b\u001a\u00020\u000b2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00150\"J\u0018\u0010#\u001a\u00020\u00152\u0006\u0010$\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020\tH\u0002J\b\u0010&\u001a\u00020\u0015H\u0002J\b\u0010\'\u001a\u00020\u0015H\u0002J\u0006\u0010(\u001a\u00020\u0015J\u000e\u0010)\u001a\u00020\u00152\u0006\u0010%\u001a\u00020\tJ\u000e\u0010*\u001a\u00020\u00152\u0006\u0010$\u001a\u00020\u000bR\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006-"}, d2 = {"Lcom/mlens/app/viewmodels/MainViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/mlens/app/data/repository/ImageRepository;", "context", "Landroid/content/Context;", "(Lcom/mlens/app/data/repository/ImageRepository;Landroid/content/Context;)V", "_filterType", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/mlens/app/viewmodels/MainViewModel$FilterType;", "_searchQuery", "", "_uiState", "Lcom/mlens/app/viewmodels/MainViewModel$MainUiState;", "databaseExporter", "Lcom/mlens/app/utils/DatabaseExporter;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "clearError", "", "clearMessages", "deleteImage", "imageId", "", "exportDatabase", "password", "onExportReady", "Lkotlin/Function1;", "importDatabaseFromUri", "zipFileUri", "Landroid/net/Uri;", "onImportSuccess", "Lkotlin/Function0;", "loadFilteredImages", "query", "filterType", "loadImages", "observeSearchAndFilter", "refreshData", "updateFilter", "updateSearchQuery", "FilterType", "MainUiState", "app_debug"})
public final class MainViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.mlens.app.data.repository.ImageRepository repository = null;
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private final com.mlens.app.utils.DatabaseExporter databaseExporter = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.mlens.app.viewmodels.MainViewModel.MainUiState> _uiState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.mlens.app.viewmodels.MainViewModel.MainUiState> uiState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> _searchQuery = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.mlens.app.viewmodels.MainViewModel.FilterType> _filterType = null;
    
    public MainViewModel(@org.jetbrains.annotations.NotNull()
    com.mlens.app.data.repository.ImageRepository repository, @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.mlens.app.viewmodels.MainViewModel.MainUiState> getUiState() {
        return null;
    }
    
    private final void loadImages() {
    }
    
    private final void observeSearchAndFilter() {
    }
    
    private final void loadFilteredImages(java.lang.String query, com.mlens.app.viewmodels.MainViewModel.FilterType filterType) {
    }
    
    public final void updateSearchQuery(@org.jetbrains.annotations.NotNull()
    java.lang.String query) {
    }
    
    public final void updateFilter(@org.jetbrains.annotations.NotNull()
    com.mlens.app.viewmodels.MainViewModel.FilterType filterType) {
    }
    
    public final void deleteImage(long imageId) {
    }
    
    public final void clearError() {
    }
    
    public final void refreshData() {
    }
    
    public final void exportDatabase(@org.jetbrains.annotations.NotNull()
    java.lang.String password, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onExportReady) {
    }
    
    public final void importDatabaseFromUri(@org.jetbrains.annotations.NotNull()
    android.net.Uri zipFileUri, @org.jetbrains.annotations.NotNull()
    java.lang.String password, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onImportSuccess) {
    }
    
    public final void clearMessages() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/mlens/app/viewmodels/MainViewModel$FilterType;", "", "(Ljava/lang/String;I)V", "ALL", "TEXT", "VISUAL", "app_debug"})
    public static enum FilterType {
        /*public static final*/ ALL /* = new ALL() */,
        /*public static final*/ TEXT /* = new TEXT() */,
        /*public static final*/ VISUAL /* = new VISUAL() */;
        
        FilterType() {
        }
        
        @org.jetbrains.annotations.NotNull()
        public static kotlin.enums.EnumEntries<com.mlens.app.viewmodels.MainViewModel.FilterType> getEntries() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b \b\u0086\b\u0018\u00002\u00020\u0001Bu\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\r\u001a\u00020\n\u0012\b\b\u0002\u0010\u000e\u001a\u00020\n\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\f\u00a2\u0006\u0002\u0010\u0011J\u000f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\fH\u00c6\u0003J\t\u0010\u001f\u001a\u00020\u0006H\u00c6\u0003J\t\u0010 \u001a\u00020\u0006H\u00c6\u0003J\t\u0010!\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\"\u001a\u00020\nH\u00c6\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\fH\u00c6\u0003J\t\u0010$\u001a\u00020\nH\u00c6\u0003J\t\u0010%\u001a\u00020\nH\u00c6\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\fH\u00c6\u0003Jy\u0010\'\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\n2\b\b\u0002\u0010\u000e\u001a\u00020\n2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\fH\u00c6\u0001J\u0013\u0010(\u001a\u00020\n2\b\u0010)\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010*\u001a\u00020\u0006H\u00d6\u0001J\t\u0010+\u001a\u00020\fH\u00d6\u0001R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0011\u0010\r\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0018R\u0011\u0010\u000e\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0018R\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0018R\u0011\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0011\u0010\b\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001a\u00a8\u0006,"}, d2 = {"Lcom/mlens/app/viewmodels/MainViewModel$MainUiState;", "", "images", "", "Lcom/mlens/app/data/database/ImageWithTags;", "totalImages", "", "textImages", "visualImages", "isLoading", "", "error", "", "isExporting", "isImporting", "exportSuccess", "importSuccess", "(Ljava/util/List;IIIZLjava/lang/String;ZZLjava/lang/String;Ljava/lang/String;)V", "getError", "()Ljava/lang/String;", "getExportSuccess", "getImages", "()Ljava/util/List;", "getImportSuccess", "()Z", "getTextImages", "()I", "getTotalImages", "getVisualImages", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "app_debug"})
    public static final class MainUiState {
        @org.jetbrains.annotations.NotNull()
        private final java.util.List<com.mlens.app.data.database.ImageWithTags> images = null;
        private final int totalImages = 0;
        private final int textImages = 0;
        private final int visualImages = 0;
        private final boolean isLoading = false;
        @org.jetbrains.annotations.Nullable()
        private final java.lang.String error = null;
        private final boolean isExporting = false;
        private final boolean isImporting = false;
        @org.jetbrains.annotations.Nullable()
        private final java.lang.String exportSuccess = null;
        @org.jetbrains.annotations.Nullable()
        private final java.lang.String importSuccess = null;
        
        public MainUiState(@org.jetbrains.annotations.NotNull()
        java.util.List<com.mlens.app.data.database.ImageWithTags> images, int totalImages, int textImages, int visualImages, boolean isLoading, @org.jetbrains.annotations.Nullable()
        java.lang.String error, boolean isExporting, boolean isImporting, @org.jetbrains.annotations.Nullable()
        java.lang.String exportSuccess, @org.jetbrains.annotations.Nullable()
        java.lang.String importSuccess) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<com.mlens.app.data.database.ImageWithTags> getImages() {
            return null;
        }
        
        public final int getTotalImages() {
            return 0;
        }
        
        public final int getTextImages() {
            return 0;
        }
        
        public final int getVisualImages() {
            return 0;
        }
        
        public final boolean isLoading() {
            return false;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getError() {
            return null;
        }
        
        public final boolean isExporting() {
            return false;
        }
        
        public final boolean isImporting() {
            return false;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getExportSuccess() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getImportSuccess() {
            return null;
        }
        
        public MainUiState() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<com.mlens.app.data.database.ImageWithTags> component1() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String component10() {
            return null;
        }
        
        public final int component2() {
            return 0;
        }
        
        public final int component3() {
            return 0;
        }
        
        public final int component4() {
            return 0;
        }
        
        public final boolean component5() {
            return false;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String component6() {
            return null;
        }
        
        public final boolean component7() {
            return false;
        }
        
        public final boolean component8() {
            return false;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String component9() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.mlens.app.viewmodels.MainViewModel.MainUiState copy(@org.jetbrains.annotations.NotNull()
        java.util.List<com.mlens.app.data.database.ImageWithTags> images, int totalImages, int textImages, int visualImages, boolean isLoading, @org.jetbrains.annotations.Nullable()
        java.lang.String error, boolean isExporting, boolean isImporting, @org.jetbrains.annotations.Nullable()
        java.lang.String exportSuccess, @org.jetbrains.annotations.Nullable()
        java.lang.String importSuccess) {
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