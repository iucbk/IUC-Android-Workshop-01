package com.miracozkan.iuc_android_workshop_01.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.miracozkan.iuc_android_workshop_01.R
import com.miracozkan.iuc_android_workshop_01.Utils.Companion.SPAN_COUNT
import com.miracozkan.iuc_android_workshop_01.adapter.MovieListAdapter
import com.miracozkan.iuc_android_workshop_01.hide
import com.miracozkan.iuc_android_workshop_01.remote.RetrofitClient
import com.miracozkan.iuc_android_workshop_01.remote.model.Data
import com.miracozkan.iuc_android_workshop_01.show
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private val retrofitClient = RetrofitClient()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intent = Intent(this@MainActivity, DetailActivity::class.java)

        prgBar.show()
        initUi(intent)
        fetchData()

    }

    private fun initUi(intent: Intent) {
        recycMovieList.apply {
            adapter = MovieListAdapter { _data ->
                intent.putExtra("movieItem", _data)
                startActivity(intent)
            }
            layoutManager =
                GridLayoutManager(this@MainActivity, SPAN_COUNT)
        }
    }

    private fun fetchData() {
        retrofitClient.getProjectService().fetchMovies().enqueue(object : Callback<List<Data>> {
            override fun onFailure(call: Call<List<Data>>, t: Throwable) {
                prgBar.hide()
                Log.v("TESTT", t.message ?: "onFailure Error")
                retry()
            }

            override fun onResponse(call: Call<List<Data>>, response: Response<List<Data>>) {
                Log.v("TESTT", response.body()?.toString() ?: "onResponse Error")
                (recycMovieList.adapter as MovieListAdapter).setNewList(
                    response.body() ?: emptyList()
                )
                prgBar.hide()
            }
        })
    }

    private fun retry() = fetchData()

}