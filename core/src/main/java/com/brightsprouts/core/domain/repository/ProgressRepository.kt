package com.brightsprouts.core.domain.repository

import com.brightsprouts.core.domain.model.LessonProgress
import com.brightsprouts.core.domain.model.UserProgress
import kotlinx.coroutines.flow.Flow

interface ProgressRepository {
    suspend fun getLessonProgress(lessonId: String): LessonProgress?
    suspend fun saveLessonProgress(progress: LessonProgress)
    fun observeUserProgress(): Flow<UserProgress>
    suspend fun getUserProgress(): UserProgress
    suspend fun unlockSticker(stickerId: String)
    suspend fun updateStreak()
    suspend fun resetProgress()
}
