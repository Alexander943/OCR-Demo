package com.mlkit.textrecognition.presentation.utils

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

object SchedulersFacade {

    fun io(): Scheduler {
        return Schedulers.io()
    }

    fun ui(): Scheduler {
        return AndroidSchedulers.mainThread()
    }

    fun computation(): Scheduler {
        return Schedulers.computation()
    }

    fun single(): Scheduler {
        return Schedulers.single()
    }
}