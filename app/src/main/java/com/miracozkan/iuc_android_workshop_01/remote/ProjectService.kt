package com.miracozkan.iuc_android_workshop_01.remote

import com.miracozkan.iuc_android_workshop_01.remote.model.Data
import retrofit2.Call
import retrofit2.http.GET


// Code with ❤
//┌─────────────────────────────┐
//│ Created by Mirac OZKAN      │
//│ ─────────────────────────── │
//│ mirac.ozkan123@gmail.com    │
//│ ─────────────────────────── │
//│ 12.11.2019 - 09:36          │
//└─────────────────────────────┘

interface ProjectService {

    @GET("data.json")
    fun fetchMovies(
    ): Call<List<Data>>

}