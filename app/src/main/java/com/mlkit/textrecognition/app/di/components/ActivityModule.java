package com.mlkit.textrecognition.app.di.components;

import com.mlkit.textrecognition.presentation.modules.main.MainActivity;
import com.mlkit.textrecognition.presentation.modules.splash.SplashActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityModule {

    @ContributesAndroidInjector
    abstract MainActivity mainActivity();

    @ContributesAndroidInjector
    abstract SplashActivity splashActivity();
}
