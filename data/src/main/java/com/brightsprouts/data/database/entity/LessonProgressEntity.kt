package com.brightsprouts.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime

@Entity(tableName = "lesson_progress")
data class LessonProgressEntity(
    @PrimaryKey
    val lessonId: String,
    val completed: Boolean,
    val score: Int,
    val starsEarned: Int,
    val completedAt: LocalDateTime?,
    val attempts: Int
)
