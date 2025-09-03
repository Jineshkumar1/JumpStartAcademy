package com.brightsprouts.core.domain.usecase

import com.brightsprouts.core.domain.repository.ContentRepository
import javax.inject.Inject

class LoadLessonUseCase @Inject constructor(
    private val contentRepository: ContentRepository
) {
    suspend operator fun invoke(lessonId: String) = 
        contentRepository.getLessonById(lessonId)
}
