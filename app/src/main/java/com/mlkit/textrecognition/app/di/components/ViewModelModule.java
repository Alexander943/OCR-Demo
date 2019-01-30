package com.mlkit.textrecognition.app.di.components;

import com.mlkit.textrecognition.presentation.utils.AppViewModelFactory;

import androidx.lifecycle.ViewModelProvider;
import dagger.Binds;
import dagger.Module;

@Module
public abstract class ViewModelModule {

    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(AppViewModelFactory factory);

//    @Binds
//    @IntoMap
//    @ViewModelKey(SplashViewModel.class)
//    abstract ViewModel bindSplashViewModel(SplashViewModel splashViewModel);
}