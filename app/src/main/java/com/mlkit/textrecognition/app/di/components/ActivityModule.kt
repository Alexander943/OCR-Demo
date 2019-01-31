package com.mlkit.textrecognition.app.di.components

import com.mlkit.textrecognition.presentation.modules.main.MainActivity
import com.mlkit.textrecognition.presentation.modules.splash.SplashActivity

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector
    internal abstract fun mainActivity(): MainActivity

    @ContributesAndroidInjector
    internal abstract fun splashActivity(): SplashActivity
}
