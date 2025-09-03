package com.brightsprouts.core.domain.usecase

import com.brightsprouts.core.domain.model.LessonProgress
import com.brightsprouts.core.domain.repository.ProgressRepository
import java.time.LocalDateTime
import javax.inject.Inject

class SubmitAnswerUseCase @Inject constructor(
    private val progressRepository: ProgressRepository
) {
    suspend operator fun invoke(
        lessonId: String,
        isCorrect: Boolean,
        score: Int
    ) {
        val existingProgress = progressRepository.getLessonProgress(lessonId)
        val newProgress = existingProgress?.copy(
            completed = true,
            score = score,
            starsEarned = calculateStars(score),
            completedAt = LocalDateTime.now(),
            attempts = existingProgress.attempts + 1
        ) ?: LessonProgress(
            lessonId = lessonId,
            completed = true,
            score = score,
            starsEarned = calculateStars(score),
            completedAt = LocalDateTime.now(),
            attempts = 1
        )
        
        progressRepository.saveLessonProgress(newProgress)
        
        if (isCorrect) {
            progressRepository.updateStreak()
        }
    }
    
    private fun calculateStars(score: Int): Int = when {
        score >= 90 -> 3
        score >= 70 -> 2
        score >= 50 -> 1
        else -> 0
    }
}
