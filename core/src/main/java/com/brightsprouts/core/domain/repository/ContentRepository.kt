package com.brightsprouts.core.domain.repository

import com.brightsprouts.core.domain.model.Lesson
import com.brightsprouts.core.domain.model.LessonDomain
import kotlinx.coroutines.flow.Flow

interface ContentRepository {
    suspend fun getLessonsByDomain(domain: LessonDomain): List<Lesson>
    suspend fun getLessonById(id: String): Lesson?
    suspend fun getAllLessons(): List<Lesson>
    fun observeLessonsByDomain(domain: LessonDomain): Flow<List<Lesson>>
    suspend fun isContentDownloaded(): Boolean
    suspend fun downloadContent(): Result<Unit>
}
