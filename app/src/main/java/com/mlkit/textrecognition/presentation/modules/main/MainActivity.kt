package com.mlkit.textrecognition.presentation.modules.main

import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.mlkit.textrecognition.R
import com.mlkit.textrecognition.presentation.base.BaseActivity
import com.mlkit.textrecognition.presentation.utils.AppViewModelFactory
import kotlinx.android.synthetic.main.main_activity.*
import javax.inject.Inject

class MainActivity : BaseActivity() {

    @Inject
    lateinit var viewModelFactory: AppViewModelFactory

    @Inject
    lateinit var router: MainRouter

    private lateinit var viewModel: MainViewModel

    override val layoutResource = R.layout.main_activity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProviders.of(
                this@MainActivity, viewModelFactory).get(MainViewModel::class.java)

        ma_btn_bitmap.setOnClickListener { router.openSimpleActivity(this@MainActivity) }
    }
}
