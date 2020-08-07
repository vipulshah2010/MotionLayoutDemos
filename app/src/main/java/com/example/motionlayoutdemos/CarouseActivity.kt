package com.example.motionlayoutdemos

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.motionlayoutdemos.databinding.Activity5carouselBinding

// layout changes
class CarouseActivity : AppCompatActivity() {

    var selectedCardIndex: Int = -1

    private lateinit var binding: Activity5carouselBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = Activity5carouselBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.left.setOnClickListener {
            if (selectedCardIndex != 0) {
                binding.motionLayout.setTransition(R.id.left_center_right, R.id.center_right)
                binding.motionLayout.transitionToEnd()
                selectedCardIndex = 0
            }
        }

        binding.center.setOnClickListener {
            if (selectedCardIndex != 1) {
                if (selectedCardIndex == 0) {
                    binding.motionLayout.setTransition(R.id.center_right, R.id.left_center_right)
                } else {
                    binding.motionLayout.setTransition(R.id.left_center, R.id.left_center_right)
                }

                binding.motionLayout.transitionToEnd()
                selectedCardIndex = 1
            }
        }

        binding.right.setOnClickListener {
            if (selectedCardIndex != 2) {
                binding.motionLayout.setTransition(R.id.left_center_right, R.id.left_center)
                binding.motionLayout.transitionToEnd()
                selectedCardIndex = 2
            }
        }
    }
}