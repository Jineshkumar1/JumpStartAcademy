package com.brightsprouts.mobile

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class JumpStartAcademyApplication : Application() {
    
    override fun onCreate() {
        super.onCreate()
        
        // Always plant Timber for debugging in development
        Timber.plant(Timber.DebugTree())
    }
}
