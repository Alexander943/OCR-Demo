package com.mlkit.textrecognition.presentation.modules.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import com.mlkit.textrecognition.R
import com.mlkit.textrecognition.presentation.base.BaseActivity
import com.mlkit.textrecognition.presentation.modules.main.MainActivity

class SplashActivity : BaseActivity() {

    override val layoutResource = R.layout.splash_activity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Handler().postDelayed({
            startActivity(Intent(this@SplashActivity, MainActivity::class.java))
            finish()
        }, 500)
    }
}
