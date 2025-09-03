package com.brightsprouts.core.domain.repository

import com.brightsprouts.core.domain.model.AppSettings
import com.brightsprouts.core.domain.model.TtsSettings
import kotlinx.coroutines.flow.Flow

interface SettingsRepository {
    fun observeAppSettings(): Flow<AppSettings>
    suspend fun getAppSettings(): AppSettings
    suspend fun updateAppSettings(settings: AppSettings)
    
    fun observeTtsSettings(): Flow<TtsSettings>
    suspend fun getTtsSettings(): TtsSettings
    suspend fun updateTtsSettings(settings: TtsSettings)
    
    suspend fun setParentalGatePassed(passed: Boolean)
    suspend fun isParentalGatePassed(): Boolean
}
