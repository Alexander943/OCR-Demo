package com.mlkit.textrecognition.presentation.modules.main

import android.app.Activity
import android.content.Intent
import com.mlkit.textrecognition.presentation.base.BaseRouter
import com.mlkit.textrecognition.presentation.modules.simple.SimpleActivity
import javax.inject.Inject

class MainRouter @Inject constructor() : BaseRouter() {

    fun openSimpleActivity(activity: Activity) {
        activity.startActivity(Intent(activity, SimpleActivity::class.java))
    }
}