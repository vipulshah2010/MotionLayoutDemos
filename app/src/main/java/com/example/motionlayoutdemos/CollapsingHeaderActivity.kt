package com.example.motionlayoutdemos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import com.example.motionlayoutdemos.databinding.Activity7collapsingHeaderBinding

class CollapsingHeaderActivity : AppCompatActivity() {

    private lateinit var binding: Activity7collapsingHeaderBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = Activity7collapsingHeaderBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.headerImageView.load(R.drawable.ic_amsterdam)
        binding.personRecyclerView.adapter = ItemAdapter()
    }

    class ItemAdapter : RecyclerView.Adapter<ItemAdapter.ViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            return ViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.list_item,
                    parent,
                    false
                )
            )
        }

        override fun getItemCount(): Int {
            return 20
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        }

        class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            init {
                view.findViewById<ImageView>(R.id.itemImageView).load(R.drawable.ic_azur)
            }
        }
    }
}