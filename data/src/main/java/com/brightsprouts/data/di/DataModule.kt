package com.brightsprouts.data.di

import android.content.Context
import com.brightsprouts.core.domain.repository.ContentRepository
import com.brightsprouts.core.domain.repository.ProgressRepository
import com.brightsprouts.core.domain.repository.SettingsRepository
import com.brightsprouts.data.database.JumpStartAcademyDatabase
import com.brightsprouts.data.database.dao.ProgressDao
import com.brightsprouts.data.repository.ContentRepositoryImpl
import com.brightsprouts.data.repository.ProgressRepositoryImpl
import com.brightsprouts.data.repository.SettingsRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {
    
    @Binds
    @Singleton
    abstract fun bindContentRepository(
        contentRepositoryImpl: ContentRepositoryImpl
    ): ContentRepository
    
    @Binds
    @Singleton
    abstract fun bindProgressRepository(
        progressRepositoryImpl: ProgressRepositoryImpl
    ): ProgressRepository
    
    @Binds
    @Singleton
    abstract fun bindSettingsRepository(
        settingsRepositoryImpl: SettingsRepositoryImpl
    ): SettingsRepository
    
    companion object {
        @Provides
        @Singleton
        fun provideDatabase(@ApplicationContext context: Context): JumpStartAcademyDatabase {
            return JumpStartAcademyDatabase.getDatabase(context)
        }
        
        @Provides
        fun provideProgressDao(database: JumpStartAcademyDatabase): ProgressDao {
            return database.progressDao()
        }
    }
}
