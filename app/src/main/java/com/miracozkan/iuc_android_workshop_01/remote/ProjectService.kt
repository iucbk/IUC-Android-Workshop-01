package com.miracozkan.iuc_android_workshop_01.remote

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

    @GET("bins/h22f8")
    fun fetchMovies(): Call<BaseResponse>

}