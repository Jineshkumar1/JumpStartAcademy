package com.brightsprouts.tv

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class JumpStartAcademyTvApplication : Application() {
    
    override fun onCreate() {
        super.onCreate()
        
        // Always plant Timber for debugging in development
        Timber.plant(Timber.DebugTree())
    }
}
