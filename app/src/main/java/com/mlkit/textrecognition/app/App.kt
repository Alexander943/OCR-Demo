package com.mlkit.textrecognition.app

import android.content.Context

import androidx.multidex.MultiDex
import com.mlkit.textrecognition.app.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class App : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder()
            .application(this)
            .build()
    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        // add over 65k methods support
        MultiDex.install(this)
    }
}
