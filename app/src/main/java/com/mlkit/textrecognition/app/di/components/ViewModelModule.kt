package com.mlkit.textrecognition.app.di.components

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mlkit.textrecognition.app.di.annotation.ViewModelKey
import com.mlkit.textrecognition.presentation.modules.main.MainViewModel
import com.mlkit.textrecognition.presentation.utils.AppViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: AppViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    internal abstract fun bindMainViewModel(mainViewModel: MainViewModel): ViewModel
}