package com.example.motionlayoutdemos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.animation7_collapsing_header.*

class Animation7_Collapsing_Header : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.animation7_collapsing_header)

        Picasso.with(this@Animation7_Collapsing_Header).load(R.drawable.ic_amsterdam).resize(150, 100)
            .centerInside()
            .into(findViewById<ImageView>(R.id.headerImageView))

        personRecyclerView.layoutManager = LinearLayoutManager(this@Animation7_Collapsing_Header)
        personRecyclerView.adapter = ItemAdapter()
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
            return 10
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        }

        class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            init {
                Picasso.with(view.context).load(R.drawable.ic_azur).resize(100, 80).centerInside()
                    .into(view.findViewById<ImageView>(R.id.itemImageView))
            }
        }
    }
}