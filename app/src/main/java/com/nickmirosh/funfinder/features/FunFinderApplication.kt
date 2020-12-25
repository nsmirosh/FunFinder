package com.nickmirosh.funfinder.features

import android.app.Application
import timber.log.Timber

class FunFinderApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}