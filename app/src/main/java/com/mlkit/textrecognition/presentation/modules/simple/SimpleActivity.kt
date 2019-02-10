package com.mlkit.textrecognition.presentation.modules.simple

import android.graphics.BitmapFactory
import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.google.firebase.ml.vision.FirebaseVision
import com.google.firebase.ml.vision.common.FirebaseVisionImage
import com.mlkit.textrecognition.R
import com.mlkit.textrecognition.presentation.base.BaseActivity
import kotlinx.android.synthetic.main.image_text_activity.*

class SimpleActivity : BaseActivity() {

    override val layoutResource = R.layout.image_text_activity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Glide.with(this@SimpleActivity)
                .load(R.drawable.alice_in_wonderland)
                .apply(RequestOptions().centerInside())
                .into(ita_image)

        ita_btn_bitmap.setOnClickListener { performBitmapRecognition() }
    }

    private fun performBitmapRecognition() {
        val bitmap = BitmapFactory.decodeResource(resources, R.drawable.alice_in_wonderland)
        val image = FirebaseVisionImage.fromBitmap(bitmap)
        processImage(image)
    }

    private fun processImage(image: FirebaseVisionImage) {
        var recognizedText = ""
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
                        recognizedText += blockText + "\n"
                    }
                    ita_text_recognized.text = recognizedText
                }
                .addOnFailureListener {
                    // Task failed with an exception
                    // ...
                }
    }
}