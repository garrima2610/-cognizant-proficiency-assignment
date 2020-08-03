package com.cognizant.proficiencyassignment.application

import android.app.Application
import com.cognizant.proficiencyassignment.module.mainModule
import org.koin.android.ext.android.startKoin

/**
 * Get application context
 */
class MainApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin(this,
            listOf(mainModule),
            loadPropertiesFromFile = true)
    }
}