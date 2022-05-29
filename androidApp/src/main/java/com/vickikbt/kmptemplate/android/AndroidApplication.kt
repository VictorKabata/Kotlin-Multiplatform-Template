package com.vickikbt.kmptemplate.android

import android.app.Application

class AndroidApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        val androidModule = listOf(null)
        // ToDo: initKoin{}
    }
}
