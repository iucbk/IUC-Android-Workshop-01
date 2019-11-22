package com.miracozkan.iuc_android_workshop_01.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.miracozkan.iuc_android_workshop_01.R
import com.miracozkan.iuc_android_workshop_01.Utils
import com.miracozkan.iuc_android_workshop_01.remote.model.Data
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
    private val txtReleaseDate = itemView.findViewById<TextView>(R.id.txtReleaseDate)
    private val txtPopularity = itemView.findViewById<TextView>(R.id.txtPopularity)

    fun bind(data: Data, onItemClickListener: (Data) -> Unit) {

        txtPopularity.text = data.popularity.toString()
        txtReleaseDate.text = data.release_date
        txtName.text = data.title

        Picasso
            .get()
            .load(Utils.posterImageUrl + data.poster_path)
            .resize(64, 128)
            .into(imgPoster)

        itemView.setOnClickListener {
            onItemClickListener(data)
        }
    }
}