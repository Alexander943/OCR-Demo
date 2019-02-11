package com.mlkit.textrecognition.presentation.base

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner

import androidx.lifecycle.ViewModel
import com.mlkit.textrecognition.presentation.event.SingleLiveEvent
import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel : ViewModel() {

    protected val compositeDisposable = CompositeDisposable()

    protected val loading = SingleLiveEvent<Boolean>()
    protected val error = SingleLiveEvent<Throwable>()

    override fun onCleared() {
        compositeDisposable.clear()
    }

    open fun removeObservers(owner: LifecycleOwner) {
        loading.removeObservers(owner)
        error.removeObservers(owner)
    }

    open fun removeObservers(owner: () -> Lifecycle) {
        loading.removeObservers(owner)
        error.removeObservers(owner)
    }

}