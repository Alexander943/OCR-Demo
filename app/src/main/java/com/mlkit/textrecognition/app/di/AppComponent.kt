package com.mlkit.textrecognition.app.di

import android.app.Application

import com.mlkit.textrecognition.app.App
import com.mlkit.textrecognition.app.di.components.ActivityModule
import com.mlkit.textrecognition.app.di.components.ViewModelModule

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

import javax.inject.Singleton

/**
 * This is a Dagger component. Refer to [App] for the list of Dagger components
 * used in this application.
 *
 *
 * Even though Dagger allows annotating a [Component] as a singleton, the code
 * itself must ensure only one instance of the class is created. This is done in [App].
 * //[AndroidSupportInjectionModule]
 * // is the module from Dagger.Android that helps with the generation
 * // and location of subcomponents.
 */

@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    ActivityModule::class,
    ViewModelModule::class
])
interface AppComponent : AndroidInjector<App> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): AppComponent.Builder

        fun build(): AppComponent
    }
}