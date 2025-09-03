package com.brightsprouts.core.domain.usecase

import com.brightsprouts.core.domain.model.LessonProgress
import com.brightsprouts.core.domain.repository.ProgressRepository
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class SubmitAnswerUseCaseTest {
    
    private lateinit var progressRepository: ProgressRepository
    private lateinit var submitAnswerUseCase: SubmitAnswerUseCase
    
    @BeforeEach
    fun setUp() {
        progressRepository = mockk()
        submitAnswerUseCase = SubmitAnswerUseCase(progressRepository)
    }
    
    @Test
    fun `submitAnswer should save progress with correct score`() = runTest {
        // Given
        val lessonId = "test_lesson_1"
        val isCorrect = true
        val score = 85
        coEvery { progressRepository.getLessonProgress(any()) } returns null
        coEvery { progressRepository.saveLessonProgress(any()) } returns Unit
        coEvery { progressRepository.updateStreak() } returns Unit
        
        // When
        submitAnswerUseCase(lessonId, isCorrect, score)
        
        // Then
        coVerify { progressRepository.saveLessonProgress(any()) }
        coVerify { progressRepository.updateStreak() }
    }
    
    @Test
    fun `submitAnswer should calculate correct stars for score`() = runTest {
        // Given
        val lessonId = "test_lesson_1"
        val isCorrect = true
        coEvery { progressRepository.getLessonProgress(any()) } returns null
        coEvery { progressRepository.saveLessonProgress(any()) } returns Unit
        coEvery { progressRepository.updateStreak() } returns Unit
        
        // When
        submitAnswerUseCase(lessonId, isCorrect, 95) // Should get 3 stars
        
        // Then
        coVerify { 
            progressRepository.saveLessonProgress(
                match { it.starsEarned == 3 }
            ) 
        }
    }
}
