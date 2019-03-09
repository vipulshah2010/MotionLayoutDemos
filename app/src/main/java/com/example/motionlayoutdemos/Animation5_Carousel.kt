package com.example.motionlayoutdemos

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.animation5_carousel.*

// layout changes
class Animation5_Carousel : AppCompatActivity() {

    var selectedCardIndex: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.animation5_carousel)

        left.setOnClickListener {
            if (selectedCardIndex != 0) {
                motionLayout.setTransition(R.id.left_center_right, R.id.center_right)
                motionLayout.transitionToEnd()
                selectedCardIndex = 0
            }
        }

        center.setOnClickListener {
            if (selectedCardIndex != 1) {
                if (selectedCardIndex == 0) {
                    motionLayout.setTransition(R.id.center_right, R.id.left_center_right)
                } else {
                    motionLayout.setTransition(R.id.left_center, R.id.left_center_right)
                }

                motionLayout.transitionToEnd()
                selectedCardIndex = 1
            }
        }

        right.setOnClickListener {
            if (selectedCardIndex != 2) {
                motionLayout.setTransition(R.id.left_center_right, R.id.left_center)
                motionLayout.transitionToEnd()
                selectedCardIndex = 2
            }
        }
    }
}