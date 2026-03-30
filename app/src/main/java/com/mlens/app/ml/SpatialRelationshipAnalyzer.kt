package com.mlens.app.ml

import android.graphics.Bitmap
import android.graphics.Rect

/**
 * Analyzes spatial relationships between detected objects
 */
class SpatialRelationshipAnalyzer {
    
    fun analyzeRelationships(
        objects: List<FlagshipImageCaptioner.DetectedObjectAdvanced>,
        bitmap: Bitmap
    ): FlagshipImageCaptioner.SpatialRelationships {
        
        val relationships = mutableMapOf<Pair<String, String>, String>()
        
        // Analyze pairwise relationships
        for (i in objects.indices) {
            for (j in i + 1 until objects.size) {
                val obj1 = objects[i]
                val obj2 = objects[j]
                
                val relationship = calculateSpatialRelationship(obj1, obj2, bitmap)
                if (relationship.isNotEmpty()) {
                    relationships[obj1.name to obj2.name] = relationship
                    // Add reverse relationship
                    val reverseRelationship = getReverseRelationship(relationship)
                    if (reverseRelationship.isNotEmpty()) {
                        relationships[obj2.name to obj1.name] = reverseRelationship
                    }
                }
            }
        }
        
        return FlagshipImageCaptioner.SpatialRelationships(relationships)
    }
    
    private fun calculateSpatialRelationship(
        obj1: FlagshipImageCaptioner.DetectedObjectAdvanced,
        obj2: FlagshipImageCaptioner.DetectedObjectAdvanced,
        bitmap: Bitmap
    ): String {
        
        val box1 = obj1.boundingBox
        val box2 = obj2.boundingBox
        
        // Calculate centers
        val center1X = box1.centerX()
        val center1Y = box1.centerY()
        val center2X = box2.centerX()
        val center2Y = box2.centerY()
        
        // Calculate relative positions
        val horizontalDistance = center2X - center1X
        val verticalDistance = center2Y - center1Y
        
        val imageWidth = bitmap.width
        val imageHeight = bitmap.height
        
        // Normalize distances
        val normalizedHorizontal = horizontalDistance.toFloat() / imageWidth
        val normalizedVertical = verticalDistance.toFloat() / imageHeight
        
        // Determine relationship based on object types and positions
        return when {
            // Containment relationships
            box1.contains(box2) -> "containing"
            box2.contains(box1) -> "inside"
            
            // Overlapping
            Rect.intersects(box1, box2) -> determineOverlapRelationship(obj1, obj2)
            
            // Vertical relationships
            Math.abs(normalizedVertical) > 0.2f -> {
                when {
                    normalizedVertical < -0.2f -> determineAboveRelationship(obj1, obj2)
                    normalizedVertical > 0.2f -> determineBelowRelationship(obj1, obj2)
                    else -> ""
                }
            }
            
            // Horizontal relationships
            Math.abs(normalizedHorizontal) > 0.3f -> {
                when {
                    normalizedHorizontal < -0.3f -> "to the left of"
                    normalizedHorizontal > 0.3f -> "to the right of"
                    else -> ""
                }
            }
            
            // Close proximity
            else -> determineProximityRelationship(obj1, obj2)
        }
    }
    
    private fun determineOverlapRelationship(
        obj1: FlagshipImageCaptioner.DetectedObjectAdvanced,
        obj2: FlagshipImageCaptioner.DetectedObjectAdvanced
    ): String {
        val name1 = obj1.name.lowercase()
        val name2 = obj2.name.lowercase()
        
        return when {
            name1.contains("person") && name2.contains("chair") -> "sitting on"
            name1.contains("person") && name2.contains("bed") -> "lying on"
            name1.contains("person") && name2.contains("table") -> "at"
            name1.contains("cat") && name2.contains("chair") -> "sitting on"
            name1.contains("dog") && name2.contains("grass") -> "on"
            name1.contains("car") && name2.contains("road") -> "on"
            else -> "with"
        }
    }
    
    private fun determineAboveRelationship(
        obj1: FlagshipImageCaptioner.DetectedObjectAdvanced,
        obj2: FlagshipImageCaptioner.DetectedObjectAdvanced
    ): String {
        val name1 = obj1.name.lowercase()
        val name2 = obj2.name.lowercase()
        
        return when {
            name2.contains("table") || name2.contains("surface") -> "on"
            name2.contains("ground") || name2.contains("floor") -> "on"
            name2.contains("grass") || name2.contains("field") -> "on"
            name2.contains("water") -> "above"
            else -> "above"
        }
    }
    
    private fun determineBelowRelationship(
        obj1: FlagshipImageCaptioner.DetectedObjectAdvanced,
        obj2: FlagshipImageCaptioner.DetectedObjectAdvanced
    ): String {
        val name1 = obj1.name.lowercase()
        val name2 = obj2.name.lowercase()
        
        return when {
            name1.contains("table") || name1.contains("surface") -> "under"
            name1.contains("tree") || name1.contains("roof") -> "under"
            else -> "below"
        }
    }
    
    private fun determineProximityRelationship(
        obj1: FlagshipImageCaptioner.DetectedObjectAdvanced,
        obj2: FlagshipImageCaptioner.DetectedObjectAdvanced
    ): String {
        val name1 = obj1.name.lowercase()
        val name2 = obj2.name.lowercase()
        
        return when {
            (name1.contains("person") || name1.contains("animal")) && 
            (name2.contains("person") || name2.contains("animal")) -> "with"
            
            name1.contains("person") && name2.contains("food") -> "eating"
            name1.contains("person") && name2.contains("book") -> "reading"
            name1.contains("person") && name2.contains("phone") -> "using"
            
            else -> "near"
        }
    }
    
    private fun getReverseRelationship(relationship: String): String {
        return when (relationship) {
            "above" -> "below"
            "below" -> "above"
            "to the left of" -> "to the right of"
            "to the right of" -> "to the left of"
            "on" -> "under"
            "under" -> "on"
            "inside" -> "containing"
            "containing" -> "inside"
            "sitting on" -> "being sat on by"
            "lying on" -> "being lied on by"
            else -> ""
        }
    }
}