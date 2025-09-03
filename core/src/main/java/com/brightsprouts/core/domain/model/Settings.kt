package com.brightsprouts.core.domain.model

data class AppSettings(
    val language: String = "en",
    val ttsEnabled: Boolean = true,
    val audioEnabled: Boolean = true,
    val reducedMotion: Boolean = false,
    val sessionTimeLimit: Int? = null, // minutes, null = no limit
    val parentalGateEnabled: Boolean = true
)

data class TtsSettings(
    val voice: String = "default",
    val speed: Float = 1.0f,
    val pitch: Float = 1.0f
)
