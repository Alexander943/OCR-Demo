package com.mlkit.textrecognition.presentation.modules.main

import android.graphics.BitmapFactory
import android.os.Bundle
import com.google.firebase.ml.vision.FirebaseVision
import com.google.firebase.ml.vision.common.FirebaseVisionImage
import com.mlkit.textrecognition.R
import com.mlkit.textrecognition.presentation.base.BaseActivity
import kotlinx.android.synthetic.main.main_activity.*
import timber.log.Timber

class MainActivity : BaseActivity() {

    override val layoutResource = R.layout.main_activity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        ma_btn_bitmap.setOnClickListener { performBitmapRecognition() }
    }

    private fun performBitmapRecognition() {
        val bitmap = BitmapFactory.decodeResource(resources, R.drawable.alice_in_wonderland)
        val image = FirebaseVisionImage.fromBitmap(bitmap)
        processImage(image)
    }

    private fun processImage(image: FirebaseVisionImage) {
        val detector = FirebaseVision.getInstance().onDeviceTextRecognizer
        val result = detector.processImage(image)
            .addOnSuccessListener { firebaseVisionText ->
                // Task completed successfully
                // ...

                val resultText = firebaseVisionText.text
                for (block in firebaseVisionText.textBlocks) {
                    val blockText = block.text
                    val blockConfidence = block.confidence
                    val blockLanguages = block.recognizedLanguages
                    val blockCornerPoints = block.cornerPoints
                    val blockFrame = block.boundingBox
                    for (line in block.lines) {
                        val lineText = line.text
                        val lineConfidence = line.confidence
                        val lineLanguages = line.recognizedLanguages
                        val lineCornerPoints = line.cornerPoints
                        val lineFrame = line.boundingBox
                        for (element in line.elements) {
                            val elementText = element.text
                            val elementConfidence = element.confidence
                            val elementLanguages = element.recognizedLanguages
                            val elementCornerPoints = element.cornerPoints
                            val elementFrame = element.boundingBox
                        }
                    }
                    Timber.e(blockText)
                }

                Timber.e(firebaseVisionText.toString())
            }
            .addOnFailureListener {
                // Task failed with an exception
                // ...
            }
    }
}
