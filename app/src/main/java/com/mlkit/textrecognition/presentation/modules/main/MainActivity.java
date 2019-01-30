package com.mlkit.textrecognition.presentation.modules.main;

import android.os.Bundle;

import com.mlkit.textrecognition.R;

import dagger.android.DaggerActivity;

public class MainActivity extends DaggerActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
