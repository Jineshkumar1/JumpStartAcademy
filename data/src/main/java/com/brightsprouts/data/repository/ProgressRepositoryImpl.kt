package com.brightsprouts.data.repository

import com.brightsprouts.core.domain.model.LessonProgress
import com.brightsprouts.core.domain.model.UserProgress
import com.brightsprouts.core.domain.repository.ProgressRepository
import com.brightsprouts.data.database.dao.ProgressDao
import com.brightsprouts.data.database.entity.LessonProgressEntity
import com.brightsprouts.data.database.entity.UserProgressEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import java.time.LocalDateTime
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProgressRepositoryImpl @Inject constructor(
    private val progressDao: ProgressDao
) : ProgressRepository {
    
    override suspend fun getLessonProgress(lessonId: String): LessonProgress? {
        return progressDao.getLessonProgress(lessonId)?.toDomain()
    }
    
    override suspend fun saveLessonProgress(progress: LessonProgress) {
        progressDao.insertLessonProgress(progress.toEntity())
    }
    
    override fun observeUserProgress(): Flow<UserProgress> {
        return progressDao.observeUserProgress().map { entity ->
            entity?.toDomain() ?: UserProgress(
                totalLessonsCompleted = 0,
                totalStarsEarned = 0,
                currentStreak = 0,
                longestStreak = 0,
                lastActivityDate = null,
                stickersUnlocked = emptyList()
            )
        }
    }
    
    override suspend fun getUserProgress(): UserProgress {
        return progressDao.getUserProgress()?.toDomain() ?: UserProgress(
            totalLessonsCompleted = 0,
            totalStarsEarned = 0,
            currentStreak = 0,
            longestStreak = 0,
            lastActivityDate = null,
            stickersUnlocked = emptyList()
        )
    }
    
    override suspend fun unlockSticker(stickerId: String) {
        val currentProgress = getUserProgress()
        val updatedStickers = currentProgress.stickersUnlocked + stickerId
        val updatedProgress = currentProgress.copy(stickersUnlocked = updatedStickers)
        progressDao.insertUserProgress(updatedProgress.toEntity())
    }
    
    override suspend fun updateStreak() {
        val currentProgress = getUserProgress()
        val today = LocalDateTime.now().toLocalDate()
        val lastActivity = currentProgress.lastActivityDate?.toLocalDate()
        
        val newStreak = if (lastActivity == today) {
            currentProgress.currentStreak
        } else if (lastActivity == today.minusDays(1)) {
            currentProgress.currentStreak + 1
        } else {
            1
        }
        
        val updatedProgress = currentProgress.copy(
            currentStreak = newStreak,
            longestStreak = maxOf(currentProgress.longestStreak, newStreak),
            lastActivityDate = LocalDateTime.now()
        )
        
        progressDao.insertUserProgress(updatedProgress.toEntity())
    }
    
    override suspend fun resetProgress() {
        progressDao.clearLessonProgress()
        progressDao.clearUserProgress()
    }
    
    private fun LessonProgress.toEntity() = LessonProgressEntity(
        lessonId = lessonId,
        completed = completed,
        score = score,
        starsEarned = starsEarned,
        completedAt = completedAt,
        attempts = attempts
    )
    
    private fun LessonProgressEntity.toDomain() = LessonProgress(
        lessonId = lessonId,
        completed = completed,
        score = score,
        starsEarned = starsEarned,
        completedAt = completedAt,
        attempts = attempts
    )
    
    private fun UserProgress.toEntity() = UserProgressEntity(
        totalLessonsCompleted = totalLessonsCompleted,
        totalStarsEarned = totalStarsEarned,
        currentStreak = currentStreak,
        longestStreak = longestStreak,
        lastActivityDate = lastActivityDate,
        stickersUnlocked = stickersUnlocked.joinToString(",")
    )
    
    private fun UserProgressEntity.toDomain() = UserProgress(
        totalLessonsCompleted = totalLessonsCompleted,
        totalStarsEarned = totalStarsEarned,
        currentStreak = currentStreak,
        longestStreak = longestStreak,
        lastActivityDate = lastActivityDate,
        stickersUnlocked = if (stickersUnlocked.isBlank()) {
            emptyList()
        } else {
            stickersUnlocked.split(",")
        }
    )
}
