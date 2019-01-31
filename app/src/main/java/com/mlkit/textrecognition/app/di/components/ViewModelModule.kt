package com.mlkit.textrecognition.app.di.components

import com.mlkit.textrecognition.presentation.utils.AppViewModelFactory

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: AppViewModelFactory): ViewModelProvider.Factory

    //    @Binds
    //    @IntoMap
    //    @ViewModelKey(SplashViewModel.class)
    //    abstract ViewModel bindSplashViewModel(SplashViewModel splashViewModel);
}