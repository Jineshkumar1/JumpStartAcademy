package com.brightsprouts.data.repository

import com.brightsprouts.core.domain.model.Lesson
import com.brightsprouts.core.domain.model.LessonDomain
import com.brightsprouts.core.domain.repository.ContentRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.serialization.json.Json
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ContentRepositoryImpl @Inject constructor(
    private val contentLoader: ContentLoader
) : ContentRepository {
    
    private val json = Json { ignoreUnknownKeys = true }
    private var cachedLessons: List<Lesson>? = null
    
    override suspend fun getLessonsByDomain(domain: LessonDomain): List<Lesson> {
        return getAllLessons().filter { it.domain == domain }
    }
    
    override suspend fun getLessonById(id: String): Lesson? {
        return getAllLessons().find { it.id == id }
    }
    
    override suspend fun getAllLessons(): List<Lesson> {
        if (cachedLessons == null) {
            cachedLessons = contentLoader.loadLessons()
        }
        return cachedLessons ?: emptyList()
    }
    
    override fun observeLessonsByDomain(domain: LessonDomain): Flow<List<Lesson>> = flow {
        emit(getLessonsByDomain(domain))
    }
    
    override suspend fun isContentDownloaded(): Boolean {
        return contentLoader.isContentAvailable()
    }
    
    override suspend fun downloadContent(): Result<Unit> {
        return try {
            contentLoader.downloadContent()
            cachedLessons = null // Clear cache to reload
            Result.success(Unit)
        } catch (e: Exception) {
            Timber.e(e, "Failed to download content")
            Result.failure(e)
        }
    }
}
