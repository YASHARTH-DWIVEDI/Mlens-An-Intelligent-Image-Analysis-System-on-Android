# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.kts.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# ============================================
# DEBUGGING
# ============================================
# Keep line numbers for better crash reports
-keepattributes SourceFile,LineNumberTable
-renamesourcefileattribute SourceFile

# Keep annotations
-keepattributes *Annotation*
-keepattributes Signature
-keepattributes Exceptions
-keepattributes InnerClasses
-keepattributes EnclosingMethod

# ============================================
# KOTLIN
# ============================================
# Keep Kotlin metadata
-keep class kotlin.Metadata { *; }
-keepclassmembers class **$WhenMappings {
    <fields>;
}
-keepclassmembers class kotlin.Metadata {
    public <methods>;
}

# Keep Kotlin Coroutines
-keepnames class kotlinx.coroutines.internal.MainDispatcherFactory {}
-keepnames class kotlinx.coroutines.CoroutineExceptionHandler {}
-keepclassmembers class kotlinx.coroutines.** {
    volatile <fields>;
}
-dontwarn kotlinx.coroutines.**

# Keep Kotlin serialization (if used)
-keepattributes RuntimeVisibleAnnotations,AnnotationDefault
-dontwarn kotlinx.serialization.**
-keep,includedescriptorclasses class com.mlens.app.**$$serializer { *; }
-keepclassmembers class com.mlens.app.** {
    *** Companion;
}
-keepclasseswithmembers class com.mlens.app.** {
    kotlinx.serialization.KSerializer serializer(...);
}

# ============================================
# JETPACK COMPOSE
# ============================================
# Keep Compose classes
-keep class androidx.compose.** { *; }
-keep class androidx.compose.runtime.** { *; }
-keep class androidx.compose.ui.** { *; }
-keep class androidx.compose.foundation.** { *; }
-keep class androidx.compose.material.** { *; }
-keep class androidx.compose.material3.** { *; }

# Keep Compose compiler generated classes
-keep class **.*ComposableSingletons* { *; }
-keepclassmembers class ** {
    @androidx.compose.runtime.Composable <methods>;
}

# ============================================
# ANDROIDX & NAVIGATION
# ============================================
# Keep ViewModel classes
-keep class * extends androidx.lifecycle.ViewModel {
    <init>(...);
}
-keep class * extends androidx.lifecycle.AndroidViewModel {
    <init>(...);
}

# Keep Navigation arguments
-keep class androidx.navigation.** { *; }
-keepnames class * extends android.os.Parcelable
-keepnames class * extends java.io.Serializable

# ============================================
# ROOM DATABASE
# ============================================
-keep class * extends androidx.room.RoomDatabase
-keep @androidx.room.Entity class *
-keep @androidx.room.Dao class * { *; }
-keep class androidx.room.** { *; }

# Keep Room generated classes
-keep class * extends androidx.room.RoomDatabase
-keep @androidx.room.Entity class * { *; }
-keepclassmembers class * {
    @androidx.room.* <fields>;
    @androidx.room.* <methods>;
}

# ============================================
# ML KIT
# ============================================
-keep class com.google.mlkit.** { *; }
-keep interface com.google.mlkit.** { *; }
-keep class com.google.android.gms.** { *; }
-dontwarn com.google.android.gms.**
-dontwarn com.google.mlkit.**

# ML Kit Vision
-keep class com.google.mlkit.vision.** { *; }
-keep class com.google.android.gms.vision.** { *; }

# ============================================
# TENSORFLOW LITE
# ============================================
-keep class org.tensorflow.lite.** { *; }
-keep interface org.tensorflow.lite.** { *; }
-keep class org.tensorflow.lite.support.** { *; }
-keepclassmembers class org.tensorflow.lite.** {
    native <methods>;
}

# TensorFlow Lite Task API
-keep class org.tensorflow.lite.task.** { *; }
-keep class org.tensorflow.lite.support.** { *; }

# Keep TFLite model metadata
-keepclassmembers class * {
    @org.tensorflow.lite.** *;
}

# ============================================
# APPLICATION CLASSES
# ============================================
# Keep all data classes
-keep class com.mlens.app.data.** { *; }
-keepclassmembers class com.mlens.app.data.** { *; }

# Keep ML processor classes
-keep class com.mlens.app.ml.** { *; }
-keepclassmembers class com.mlens.app.ml.** { *; }

# Keep ViewModels
-keep class com.mlens.app.viewmodels.** { *; }

# Keep Application class
-keep class com.mlens.app.MLensApplication { *; }

# Keep all data class members (for reflection)
-keepclassmembers class com.mlens.app.** {
    public <init>(...);
}

# Keep companion objects
-keepclassmembers class * {
    public static **$Companion *;
}

# ============================================
# IMAGE LOADING (COIL)
# ============================================
-keep class coil.** { *; }
-keep interface coil.** { *; }
-dontwarn coil.**

# ============================================
# CAMERA X
# ============================================
-keep class androidx.camera.** { *; }
-dontwarn androidx.camera.**

# ============================================
# GENERAL RULES
# ============================================
# Keep native methods
-keepclasseswithmembernames class * {
    native <methods>;
}

# Keep custom views
-keep public class * extends android.view.View {
    public <init>(android.content.Context);
    public <init>(android.content.Context, android.util.AttributeSet);
    public <init>(android.content.Context, android.util.AttributeSet, int);
    public void set*(...);
}

# Keep Parcelables
-keep class * implements android.os.Parcelable {
    public static final android.os.Parcelable$Creator *;
}

# Keep enums
-keepclassmembers enum * {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}

# ============================================
# SUPPRESS WARNINGS
# ============================================
-dontwarn javax.annotation.**
-dontwarn org.checkerframework.**
-dontwarn com.google.errorprone.annotations.**