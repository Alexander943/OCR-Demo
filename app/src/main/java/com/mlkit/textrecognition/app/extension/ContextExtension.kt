package com.mlkit.textrecognition.app.extension

import android.content.Context
import android.widget.Toast
import androidx.annotation.StringRes

// Toast
fun Context.showToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun Context.showToast(@StringRes resId: Int) {
    Toast.makeText(this, resId, Toast.LENGTH_SHORT).show()
}