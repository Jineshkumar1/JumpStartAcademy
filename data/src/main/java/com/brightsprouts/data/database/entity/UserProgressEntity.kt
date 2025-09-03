package com.brightsprouts.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime

@Entity(tableName = "user_progress")
data class UserProgressEntity(
    @PrimaryKey
    val id: Int = 1,
    val totalLessonsCompleted: Int,
    val totalStarsEarned: Int,
    val currentStreak: Int,
    val longestStreak: Int,
    val lastActivityDate: LocalDateTime?,
    val stickersUnlocked: String // JSON string of List<String>
)
