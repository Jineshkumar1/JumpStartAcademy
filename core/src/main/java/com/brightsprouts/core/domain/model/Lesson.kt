package com.brightsprouts.core.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Lesson(
    val id: String,
    val domain: LessonDomain,
    val title: String,
    val age: String,
    val cards: List<LessonCard>,
    val rewards: LessonRewards
)

@Serializable
enum class LessonDomain {
    MATH, ENGLISH, ANIMALS, KG
}

@Serializable
sealed interface LessonCard {
    val type: String
}

@Serializable
data class PromptCard(
    override val type: String = "prompt",
    val tts: String
) : LessonCard

@Serializable
data class ChoiceCard(
    override val type: String = "choice",
    val image: String,
    val options: List<String>,
    val answer: Int
) : LessonCard

@Serializable
data class DragCountCard(
    override val type: String = "drag_count",
    val target: Int,
    val asset: String
) : LessonCard

@Serializable
data class TraceCard(
    override val type: String = "trace",
    val path: String,
    val letter: String
) : LessonCard

@Serializable
data class LessonRewards(
    val stars: Int,
    val sticker: String
)