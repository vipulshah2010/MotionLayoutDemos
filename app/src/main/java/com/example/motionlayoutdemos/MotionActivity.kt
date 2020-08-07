package com.example.motionlayoutdemos

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.motionlayoutdemos.databinding.ActivityListItemBinding
import com.example.motionlayoutdemos.databinding.ActivityMotionBinding

class MotionActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMotionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMotionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val map = mapOf(
            "Basic" to BasicAnimationActivity::class.java,
            "Custom" to CustomAttributesActivity::class.java,
            "Key Attributes" to KeyAttributesActivity::class.java,
            "Photo Manipulation" to PhotoManipulationActivity::class.java,
            "Carousel" to CarouseActivity::class.java,
            "Collapsing Toolbar" to CollapsingToolbarActivity::class.java,
            "Collapsing Header" to CollapsingHeaderActivity::class.java
        )

        binding.recyclerview.adapter = RowAdapter(map.keys.toTypedArray()) {
            startActivity(Intent(this@MotionActivity, map[it] ?: error("Activity not found!")))
        }
    }

    class RowAdapter(
        private val animations: Array<String>,
        private val listener: (String) -> Unit
    ) :
        RecyclerView.Adapter<RowAdapter.ViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val binding = ActivityListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
            return ViewHolder(binding)
        }

        override fun getItemCount(): Int {
            return animations.size
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.bind(animations[position], listener)
        }

        class ViewHolder(private val binding: ActivityListItemBinding) :
            RecyclerView.ViewHolder(binding.root) {

            fun bind(text: String, listener: (String) -> Unit) {
                binding.textView.text = text
                itemView.setOnClickListener {
                    listener.invoke(text)
                }
            }
        }
    }
}