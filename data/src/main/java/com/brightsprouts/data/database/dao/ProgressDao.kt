package com.brightsprouts.data.database.dao

import androidx.room.*
import com.brightsprouts.data.database.entity.LessonProgressEntity
import com.brightsprouts.data.database.entity.UserProgressEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ProgressDao {
    @Query("SELECT * FROM lesson_progress WHERE lessonId = :lessonId")
    suspend fun getLessonProgress(lessonId: String): LessonProgressEntity?
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLessonProgress(progress: LessonProgressEntity)
    
    @Query("SELECT * FROM user_progress WHERE id = 1")
    suspend fun getUserProgress(): UserProgressEntity?
    
    @Query("SELECT * FROM user_progress WHERE id = 1")
    fun observeUserProgress(): Flow<UserProgressEntity?>
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUserProgress(progress: UserProgressEntity)
    
    @Query("DELETE FROM lesson_progress")
    suspend fun clearLessonProgress()
    
    @Query("DELETE FROM user_progress")
    suspend fun clearUserProgress()
}
