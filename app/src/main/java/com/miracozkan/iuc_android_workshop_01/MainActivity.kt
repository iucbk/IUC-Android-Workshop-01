package com.miracozkan.iuc_android_workshop_01

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.miracozkan.iuc_android_workshop_01.remote.BaseResponse
import com.miracozkan.iuc_android_workshop_01.remote.RetrofitClient
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private val retrofitClient = RetrofitClient()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //https://api.myjson.com/bins/h22f8

        with(recycMovieList) {
            adapter = MovieListAdapter {

            }
            layoutManager = GridLayoutManager(this@MainActivity, 2)
        }

        retrofitClient.getProjectService().fetchMovies().enqueue(object : Callback<BaseResponse> {

            override fun onFailure(call: Call<BaseResponse>, t: Throwable) {
                Log.v("TESTT", t.message ?: "")
            }

            override fun onResponse(call: Call<BaseResponse>, response: Response<BaseResponse>) {
                Log.v("TESTT", response.body()?.data.toString())
                (recycMovieList.adapter as MovieListAdapter).setNewList(response.body()?.data!!)
            }
        })
    }
}