package com.miracozkan.iuc_android_workshop_01.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.miracozkan.iuc_android_workshop_01.remote.model.Data


// Code with ❤
//┌─────────────────────────────┐
//│ Created by Mirac OZKAN      │
//│ ─────────────────────────── │
//│ mirac.ozkan123@gmail.com    │
//│ ─────────────────────────── │
//│ 12.11.2019 - 10:03          │
//└─────────────────────────────┘

class MovieListAdapter(
    private var movieList: List<Data>? = null,
    private val onItemClickListener: (Data) -> Unit
) : RecyclerView.Adapter<MovieListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieListViewHolder =
        MovieListViewHolder(parent)

    override fun getItemCount(): Int {
        movieList?.let {
            return it.size
        }
        return 0
    }

    override fun onBindViewHolder(holder: MovieListViewHolder, position: Int) {
        holder.bind(movieList!![position], onItemClickListener)
    }

    fun setNewList(movieList: List<Data>) {
        this.movieList = movieList
        notifyDataSetChanged()
    }

}