package com.miracozkan.iuc_android_workshop_01.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.miracozkan.iuc_android_workshop_01.R
import com.miracozkan.iuc_android_workshop_01.remote.Data
import com.squareup.picasso.Picasso


// Code with ❤
//┌─────────────────────────────┐
//│ Created by Mirac OZKAN      │
//│ ─────────────────────────── │
//│ mirac.ozkan123@gmail.com    │
//│ ─────────────────────────── │
//│ 12.11.2019 - 09:58          │
//└─────────────────────────────┘

class MovieListViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.adapter_item_movie_list, parent, false)
) {
    private val imgPoster = itemView.findViewById<ImageView>(R.id.imgPoster)
    private val txtName = itemView.findViewById<TextView>(R.id.txtName)
    private val txtGenre = itemView.findViewById<TextView>(R.id.txtGenre)
    private val txtDirector = itemView.findViewById<TextView>(R.id.txtDirector)

    fun bind(data: Data, onItemClickListener: (Data) -> Unit) {

        txtDirector.text = data.director
        txtGenre.text = data.genre
        txtName.text = data.title
        Picasso
            .get()
            .load(data.poster)
            .resize(64, 128)
            .into(imgPoster)

        itemView.setOnClickListener {
            onItemClickListener(data)
        }
    }
}