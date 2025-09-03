package com.brightsprouts.testing

import com.brightsprouts.core.domain.model.Lesson
import com.brightsprouts.core.domain.model.LessonDomain
import com.brightsprouts.core.domain.model.LessonProgress
import com.brightsprouts.core.domain.model.LessonRewards
import com.brightsprouts.core.domain.model.ChoiceCard
import com.brightsprouts.core.domain.model.PromptCard
import java.time.LocalDateTime

object TestUtils {
    
    fun createSampleLesson(
        id: String = "test_lesson_1",
        domain: LessonDomain = LessonDomain.MATH,
        title: String = "Test Lesson"
    ): Lesson {
        return Lesson(
            id = id,
            domain = domain,
            title = title,
            age = "3-4",
            cards = listOf(
                PromptCard(tts = "Test prompt"),
                ChoiceCard(
                    image = "test_image.png",
                    options = listOf("Option 1", "Option 2", "Option 3"),
                    answer = 0
                )
            ),
            rewards = LessonRewards(
                stars = 3,
                sticker = "test_sticker"
            )
        )
    }
    
    fun createSampleProgress(
        lessonId: String = "test_lesson_1",
        completed: Boolean = true,
        score: Int = 85
    ): LessonProgress {
        return LessonProgress(
            lessonId = lessonId,
            completed = completed,
            score = score,
            starsEarned = 2,
            completedAt = LocalDateTime.now(),
            attempts = 1
        )
    }
}
