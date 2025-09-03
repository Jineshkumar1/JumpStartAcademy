package com.brightsprouts.core.domain.model

import java.time.LocalDateTime

data class LessonProgress(
    val lessonId: String,
    val completed: Boolean,
    val score: Int,
    val starsEarned: Int,
    val completedAt: LocalDateTime?,
    val attempts: Int
)

data class UserProgress(
    val totalLessonsCompleted: Int,
    val totalStarsEarned: Int,
    val currentStreak: Int,
    val longestStreak: Int,
    val lastActivityDate: LocalDateTime?,
    val stickersUnlocked: List<String>
)

data class DailyStreak(
    val currentStreak: Int,
    val lastActivityDate: LocalDateTime?,
    val maxStreak: Int = 7
)
