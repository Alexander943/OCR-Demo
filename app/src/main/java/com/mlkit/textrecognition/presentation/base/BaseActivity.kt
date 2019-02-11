package com.mlkit.textrecognition.presentation.base

import android.os.Bundle
import com.mlkit.textrecognition.app.extension.hideSoftKeyboard
import dagger.android.support.DaggerAppCompatActivity

abstract class BaseActivity : DaggerAppCompatActivity() {

    protected abstract val layoutResource: Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutResource)
    }

    override fun onSupportNavigateUp(): Boolean {
        hideSoftKeyboard()
        onBackPressed()
        return true
    }
}
