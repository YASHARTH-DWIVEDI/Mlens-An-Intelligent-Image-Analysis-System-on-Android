package com.mlens.app.data.database

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import android.content.Context

@Database(
    entities = [ImageEntity::class],
    version = 1,
    exportSchema = false
)
abstract class MLensDatabase : RoomDatabase() {
    
    abstract fun imageDao(): ImageDao
    
    companion object {
        @Volatile
        private var INSTANCE: MLensDatabase? = null
        
        fun getDatabase(context: Context): MLensDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MLensDatabase::class.java,
                    "mlens_database"
                )
                .addCallback(DatabaseCallback())
                .build()
                INSTANCE = instance
                instance
            }
        }
        
        private class DatabaseCallback : RoomDatabase.Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                // Database created - can add initial data here if needed
            }
        }
        
        // Example migration for future database updates
        val MIGRATION_1_2 = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                // Migration logic for version 1 to 2
                // Example: database.execSQL("ALTER TABLE images ADD COLUMN new_column TEXT")
            }
        }
    }
}