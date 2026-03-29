package com.mlens.app.ml;

/**
 * Advanced Scene Analysis for comprehensive scene understanding
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 $2\u00020\u0001:\u0003#$%B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J*\u0010\u000b\u001a\u00020\f2\u0018\u0010\r\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000f0\u000e2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\nH\u0086@\u00a2\u0006\u0002\u0010\u0014J \u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0017H\u0002J\u0006\u0010\u001a\u001a\u00020\u001bJ*\u0010\u001c\u001a\u00020\u00102\u0018\u0010\r\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000f0\u000e2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J(\u0010\u001f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000f0\u000e2\u0006\u0010 \u001a\u00020!H\u0082@\u00a2\u0006\u0002\u0010\"R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006&"}, d2 = {"Lcom/mlens/app/ml/AdvancedSceneAnalyzer;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "sceneLabeler", "Lcom/google/mlkit/vision/label/ImageLabeler;", "analyzeColors", "Lcom/mlens/app/ml/AdvancedSceneAnalyzer$ColorAnalysis;", "bitmap", "Landroid/graphics/Bitmap;", "analyzeEnvironment", "Lcom/mlens/app/ml/AdvancedSceneAnalyzer$EnvironmentAnalysis;", "sceneLabels", "", "Lkotlin/Pair;", "", "", "analyzeScene", "Lcom/mlens/app/ml/FlagshipImageCaptioner$SceneContext;", "(Landroid/graphics/Bitmap;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "categorizeColor", "red", "", "green", "blue", "cleanup", "", "determinePrimaryScene", "isOutdoor", "", "getSceneLabels", "image", "Lcom/google/mlkit/vision/common/InputImage;", "(Lcom/google/mlkit/vision/common/InputImage;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ColorAnalysis", "Companion", "EnvironmentAnalysis", "app_debug"})
public final class AdvancedSceneAnalyzer {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private final com.google.mlkit.vision.label.ImageLabeler sceneLabeler = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String TAG = "AdvancedSceneAnalyzer";
    @org.jetbrains.annotations.NotNull()
    public static final com.mlens.app.ml.AdvancedSceneAnalyzer.Companion Companion = null;
    
    public AdvancedSceneAnalyzer(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object analyzeScene(@org.jetbrains.annotations.NotNull()
    android.graphics.Bitmap bitmap, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.mlens.app.ml.FlagshipImageCaptioner.SceneContext> $completion) {
        return null;
    }
    
    private final java.lang.Object getSceneLabels(com.google.mlkit.vision.common.InputImage image, kotlin.coroutines.Continuation<? super java.util.List<kotlin.Pair<java.lang.String, java.lang.Float>>> $completion) {
        return null;
    }
    
    private final com.mlens.app.ml.AdvancedSceneAnalyzer.EnvironmentAnalysis analyzeEnvironment(java.util.List<kotlin.Pair<java.lang.String, java.lang.Float>> sceneLabels, android.graphics.Bitmap bitmap) {
        return null;
    }
    
    private final java.lang.String determinePrimaryScene(java.util.List<kotlin.Pair<java.lang.String, java.lang.Float>> sceneLabels, boolean isOutdoor) {
        return null;
    }
    
    private final com.mlens.app.ml.AdvancedSceneAnalyzer.ColorAnalysis analyzeColors(android.graphics.Bitmap bitmap) {
        return null;
    }
    
    private final java.lang.String categorizeColor(int red, int green, int blue) {
        return null;
    }
    
    public final void cleanup() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0004H\u00d6\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u0010"}, d2 = {"Lcom/mlens/app/ml/AdvancedSceneAnalyzer$ColorAnalysis;", "", "dominantColors", "", "", "(Ljava/util/List;)V", "getDominantColors", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"})
    static final class ColorAnalysis {
        @org.jetbrains.annotations.NotNull()
        private final java.util.List<java.lang.String> dominantColors = null;
        
        public ColorAnalysis(@org.jetbrains.annotations.NotNull()
        java.util.List<java.lang.String> dominantColors) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<java.lang.String> getDominantColors() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<java.lang.String> component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.mlens.app.ml.AdvancedSceneAnalyzer.ColorAnalysis copy(@org.jetbrains.annotations.NotNull()
        java.util.List<java.lang.String> dominantColors) {
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
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/mlens/app/ml/AdvancedSceneAnalyzer$Companion;", "", "()V", "TAG", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000f\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0007H\u00c6\u0003J\'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u00c6\u0001J\u0013\u0010\u0012\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0014\u001a\u00020\u0015H\u00d6\u0001J\t\u0010\u0016\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0017"}, d2 = {"Lcom/mlens/app/ml/AdvancedSceneAnalyzer$EnvironmentAnalysis;", "", "primaryScene", "", "isOutdoor", "", "confidence", "", "(Ljava/lang/String;ZF)V", "getConfidence", "()F", "()Z", "getPrimaryScene", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "app_debug"})
    static final class EnvironmentAnalysis {
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String primaryScene = null;
        private final boolean isOutdoor = false;
        private final float confidence = 0.0F;
        
        public EnvironmentAnalysis(@org.jetbrains.annotations.NotNull()
        java.lang.String primaryScene, boolean isOutdoor, float confidence) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getPrimaryScene() {
            return null;
        }
        
        public final boolean isOutdoor() {
            return false;
        }
        
        public final float getConfidence() {
            return 0.0F;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component1() {
            return null;
        }
        
        public final boolean component2() {
            return false;
        }
        
        public final float component3() {
            return 0.0F;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.mlens.app.ml.AdvancedSceneAnalyzer.EnvironmentAnalysis copy(@org.jetbrains.annotations.NotNull()
        java.lang.String primaryScene, boolean isOutdoor, float confidence) {
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