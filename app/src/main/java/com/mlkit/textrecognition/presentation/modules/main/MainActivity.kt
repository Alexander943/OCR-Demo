package com.mlkit.textrecognition.presentation.modules.main

import android.os.Bundle

import com.mlkit.textrecognition.R

import dagger.android.DaggerActivity

class MainActivity : DaggerActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
