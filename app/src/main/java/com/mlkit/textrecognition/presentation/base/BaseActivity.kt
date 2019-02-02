package com.mlkit.textrecognition.presentation.base

import android.app.Activity
import android.content.Context
import android.content.pm.ActivityInfo
import android.content.res.Configuration
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import dagger.android.support.DaggerAppCompatActivity

abstract class BaseActivity : DaggerAppCompatActivity() {

    protected abstract val layoutResource: Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_NOSENSOR
        setContentView(layoutResource)
    }

    override fun onSupportNavigateUp(): Boolean {
        hideSoftKeyboard(this)
        onBackPressed()
        return true
    }

    protected fun disableRotation() {
        requestedOrientation = if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
            ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        } else {
            ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        }
    }

    protected fun hideSoftKeyboard(activity: Activity?) {
        if (activity == null) return
        val imm = activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager ?: return
        imm.hideSoftInputFromWindow(activity.window.decorView.rootView.windowToken, 0)
    }
}
