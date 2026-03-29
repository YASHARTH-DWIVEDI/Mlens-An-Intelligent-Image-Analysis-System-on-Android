package com.mlens.app.ml;

/**
 * Analyzes spatial relationships between detected objects
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tJ \u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002J\u0018\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0007H\u0002J\u0018\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0007H\u0002J\u0018\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0007H\u0002J\u0018\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0007H\u0002J\u0010\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u000bH\u0002\u00a8\u0006\u0014"}, d2 = {"Lcom/mlens/app/ml/SpatialRelationshipAnalyzer;", "", "()V", "analyzeRelationships", "Lcom/mlens/app/ml/FlagshipImageCaptioner$SpatialRelationships;", "objects", "", "Lcom/mlens/app/ml/FlagshipImageCaptioner$DetectedObjectAdvanced;", "bitmap", "Landroid/graphics/Bitmap;", "calculateSpatialRelationship", "", "obj1", "obj2", "determineAboveRelationship", "determineBelowRelationship", "determineOverlapRelationship", "determineProximityRelationship", "getReverseRelationship", "relationship", "app_debug"})
public final class SpatialRelationshipAnalyzer {
    
    public SpatialRelationshipAnalyzer() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.mlens.app.ml.FlagshipImageCaptioner.SpatialRelationships analyzeRelationships(@org.jetbrains.annotations.NotNull()
    java.util.List<com.mlens.app.ml.FlagshipImageCaptioner.DetectedObjectAdvanced> objects, @org.jetbrains.annotations.NotNull()
    android.graphics.Bitmap bitmap) {
        return null;
    }
    
    private final java.lang.String calculateSpatialRelationship(com.mlens.app.ml.FlagshipImageCaptioner.DetectedObjectAdvanced obj1, com.mlens.app.ml.FlagshipImageCaptioner.DetectedObjectAdvanced obj2, android.graphics.Bitmap bitmap) {
        return null;
    }
    
    private final java.lang.String determineOverlapRelationship(com.mlens.app.ml.FlagshipImageCaptioner.DetectedObjectAdvanced obj1, com.mlens.app.ml.FlagshipImageCaptioner.DetectedObjectAdvanced obj2) {
        return null;
    }
    
    private final java.lang.String determineAboveRelationship(com.mlens.app.ml.FlagshipImageCaptioner.DetectedObjectAdvanced obj1, com.mlens.app.ml.FlagshipImageCaptioner.DetectedObjectAdvanced obj2) {
        return null;
    }
    
    private final java.lang.String determineBelowRelationship(com.mlens.app.ml.FlagshipImageCaptioner.DetectedObjectAdvanced obj1, com.mlens.app.ml.FlagshipImageCaptioner.DetectedObjectAdvanced obj2) {
        return null;
    }
    
    private final java.lang.String determineProximityRelationship(com.mlens.app.ml.FlagshipImageCaptioner.DetectedObjectAdvanced obj1, com.mlens.app.ml.FlagshipImageCaptioner.DetectedObjectAdvanced obj2) {
        return null;
    }
    
    private final java.lang.String getReverseRelationship(java.lang.String relationship) {
        return null;
    }
}