package com.aster.flowtrain

import android.app.Application
import com.aster.webcontainer.WebContainer
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        WebContainer.init(this)
    }
}