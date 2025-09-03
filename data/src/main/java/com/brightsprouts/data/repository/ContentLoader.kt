package com.brightsprouts.data.repository

import android.content.Context
import com.brightsprouts.core.domain.model.Lesson
import kotlinx.serialization.json.Json
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ContentLoader @Inject constructor(
    private val context: Context
) {
    private val json = Json { ignoreUnknownKeys = true }
    
    suspend fun loadLessons(): List<Lesson> {
        return try {
            val allLessons = mutableListOf<Lesson>()
            
            // Load main lessons file
            val mainLessonsJson = context.assets.open("content/lessons.json").bufferedReader().use { it.readText() }
            val mainLessons = json.decodeFromString<List<Lesson>>(mainLessonsJson)
            allLessons.addAll(mainLessons)
            
            // Load comprehensive Math lessons
            try {
                val mathLessonsJson = context.assets.open("content/math_lessons.json").bufferedReader().use { it.readText() }
                val mathLessons = json.decodeFromString<List<Lesson>>(mathLessonsJson)
                allLessons.addAll(mathLessons)
                Timber.d("Loaded ${mathLessons.size} Math lessons")
            } catch (e: Exception) {
                Timber.w(e, "Failed to load Math lessons")
            }
            
            // Load comprehensive English lessons
            try {
                val englishLessonsJson = context.assets.open("content/english_lessons.json").bufferedReader().use { it.readText() }
                val englishLessons = json.decodeFromString<List<Lesson>>(englishLessonsJson)
                allLessons.addAll(englishLessons)
                Timber.d("Loaded ${englishLessons.size} English lessons")
            } catch (e: Exception) {
                Timber.w(e, "Failed to load English lessons")
            }
            
            Timber.d("Total lessons loaded: ${allLessons.size}")
            allLessons
        } catch (e: Exception) {
            Timber.e(e, "Failed to load lessons from assets")
            emptyList()
        }
    }
    
    fun isContentAvailable(): Boolean {
        return try {
            context.assets.open("content/lessons.json").use { true }
        } catch (e: Exception) {
            false
        }
    }
    
    suspend fun downloadContent(): Unit {
        // For now, content is bundled in assets
        // In a real app, this would download from a CDN
        Timber.d("Content download completed (bundled in assets)")
    }
}
