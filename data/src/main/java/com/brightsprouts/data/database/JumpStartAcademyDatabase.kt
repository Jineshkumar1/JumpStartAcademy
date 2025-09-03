package com.brightsprouts.data.database

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import android.content.Context
import com.brightsprouts.data.database.converters.DomainConverters
import com.brightsprouts.data.database.dao.ProgressDao
import com.brightsprouts.data.database.entity.LessonProgressEntity
import com.brightsprouts.data.database.entity.UserProgressEntity

@Database(
    entities = [
        LessonProgressEntity::class,
        UserProgressEntity::class
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(DomainConverters::class)
abstract class JumpStartAcademyDatabase : RoomDatabase() {
    abstract fun progressDao(): ProgressDao
    
    companion object {
        @Volatile
        private var INSTANCE: JumpStartAcademyDatabase? = null
        
        fun getDatabase(context: Context): JumpStartAcademyDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    JumpStartAcademyDatabase::class.java,
                    "jumpstartacademy_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
