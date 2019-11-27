package com.miracozkan.iuc_android_workshop_01.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.miracozkan.iuc_android_workshop_01.R
import com.miracozkan.iuc_android_workshop_01.Utils
import com.miracozkan.iuc_android_workshop_01.remote.model.Data
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    private val movieItem by lazy { intent.getParcelableExtra<Data>("movieItem") }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        supportActionBar?.let {
            it.setDisplayHomeAsUpEnabled(true)
            it.setDisplayShowHomeEnabled(true)
        }

        initUi()
    }

    private fun initUi() {
        movieItem?.let {
            Picasso
                .get()
                .load(Utils.backImageUrl + it.backdrop_path)
                .into(imgDetailPoster)

            txtMovieAbout.text = it.overview
            txtMovieYear.text = it.release_date
            txtOrgName.text = it.original_title
            txtPopularityDetail.text = it.popularity.toString()
            txtVoteAverage.text = it.vote_average.toString()
            txtMovieName.text = it.title
            txtOrginalLang.text = it.original_language
        }
    }
}
