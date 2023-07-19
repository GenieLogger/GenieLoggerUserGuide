package com.kt.genieloggersample

import android.app.Application
import genie.log.GenieTree

class TestApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        // initialize GenieLogger
        GenieTree.initializeLogging(this.applicationContext, BuildConfig.DEBUG)
    }
}