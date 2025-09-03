package com.brightsprouts.data.repository

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import com.brightsprouts.core.domain.model.AppSettings
import com.brightsprouts.core.domain.model.TtsSettings
import com.brightsprouts.core.domain.repository.SettingsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

@Singleton
class SettingsRepositoryImpl @Inject constructor(
    private val context: Context
) : SettingsRepository {
    
    private val dataStore = context.dataStore
    
    companion object {
        private val LANGUAGE = stringPreferencesKey("language")
        private val TTS_ENABLED = booleanPreferencesKey("tts_enabled")
        private val AUDIO_ENABLED = booleanPreferencesKey("audio_enabled")
        private val REDUCED_MOTION = booleanPreferencesKey("reduced_motion")
        private val SESSION_TIME_LIMIT = intPreferencesKey("session_time_limit")
        private val PARENTAL_GATE_ENABLED = booleanPreferencesKey("parental_gate_enabled")
        private val TTS_VOICE = stringPreferencesKey("tts_voice")
        private val TTS_SPEED = floatPreferencesKey("tts_speed")
        private val TTS_PITCH = floatPreferencesKey("tts_pitch")
        private val PARENTAL_GATE_PASSED = booleanPreferencesKey("parental_gate_passed")
    }
    
    override fun observeAppSettings(): Flow<AppSettings> {
        return dataStore.data.map { preferences ->
            AppSettings(
                language = preferences[LANGUAGE] ?: "en",
                ttsEnabled = preferences[TTS_ENABLED] ?: true,
                audioEnabled = preferences[AUDIO_ENABLED] ?: true,
                reducedMotion = preferences[REDUCED_MOTION] ?: false,
                sessionTimeLimit = preferences[SESSION_TIME_LIMIT],
                parentalGateEnabled = preferences[PARENTAL_GATE_ENABLED] ?: true
            )
        }
    }
    
    override suspend fun getAppSettings(): AppSettings {
        val preferences = dataStore.data.first()
        return AppSettings(
            language = preferences[LANGUAGE] ?: "en",
            ttsEnabled = preferences[TTS_ENABLED] ?: true,
            audioEnabled = preferences[AUDIO_ENABLED] ?: true,
            reducedMotion = preferences[REDUCED_MOTION] ?: false,
            sessionTimeLimit = preferences[SESSION_TIME_LIMIT],
            parentalGateEnabled = preferences[PARENTAL_GATE_ENABLED] ?: true
        )
    }
    
    override suspend fun updateAppSettings(settings: AppSettings) {
        dataStore.edit { preferences ->
            preferences[LANGUAGE] = settings.language
            preferences[TTS_ENABLED] = settings.ttsEnabled
            preferences[AUDIO_ENABLED] = settings.audioEnabled
            preferences[REDUCED_MOTION] = settings.reducedMotion
            settings.sessionTimeLimit?.let { preferences[SESSION_TIME_LIMIT] = it }
            preferences[PARENTAL_GATE_ENABLED] = settings.parentalGateEnabled
        }
    }
    
    override fun observeTtsSettings(): Flow<TtsSettings> {
        return dataStore.data.map { preferences ->
            TtsSettings(
                voice = preferences[TTS_VOICE] ?: "default",
                speed = preferences[TTS_SPEED] ?: 1.0f,
                pitch = preferences[TTS_PITCH] ?: 1.0f
            )
        }
    }
    
    override suspend fun getTtsSettings(): TtsSettings {
        val preferences = dataStore.data.first()
        return TtsSettings(
            voice = preferences[TTS_VOICE] ?: "default",
            speed = preferences[TTS_SPEED] ?: 1.0f,
            pitch = preferences[TTS_PITCH] ?: 1.0f
        )
    }
    
    override suspend fun updateTtsSettings(settings: TtsSettings) {
        dataStore.edit { preferences ->
            preferences[TTS_VOICE] = settings.voice
            preferences[TTS_SPEED] = settings.speed
            preferences[TTS_PITCH] = settings.pitch
        }
    }
    
    override suspend fun setParentalGatePassed(passed: Boolean) {
        dataStore.edit { preferences ->
            preferences[PARENTAL_GATE_PASSED] = passed
        }
    }
    
    override suspend fun isParentalGatePassed(): Boolean {
        val preferences = dataStore.data.first()
        return preferences[PARENTAL_GATE_PASSED] ?: false
    }
}
