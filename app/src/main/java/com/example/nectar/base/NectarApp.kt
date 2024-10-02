package com.example.nectar.base

import android.app.Application
import dagger.hilt.android.HiltAndroidApp


@HiltAndroidApp
class NectarApp : Application() {
    override fun onCreate() {
        super.onCreate()
    }

    }
