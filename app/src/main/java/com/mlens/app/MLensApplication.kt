package com.mlens.app

import android.app.Application
import androidx.room.Room
import com.mlens.app.data.database.MLensDatabase
import com.mlens.app.data.repository.ImageRepository
import com.mlens.app.ml.MLProcessor

class MLensApplication : Application() {
    
    // Database instance
    val database by lazy {
        Room.databaseBuilder(
            applicationContext,
            MLensDatabase::class.java,
            "mlens_database"
        ).build()
    }
    
    // Repository instance
    val repository by lazy {
        ImageRepository(
            database.imageDao(),
            MLProcessor(applicationContext)
        )
    }
    
    override fun onCreate() {
        super.onCreate()
        // Initialize ML models on app startup
        MLProcessor.initialize(applicationContext)
    }
}