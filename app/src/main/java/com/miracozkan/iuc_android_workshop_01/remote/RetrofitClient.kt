package com.miracozkan.iuc_android_workshop_01.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


// Code with ❤
//┌─────────────────────────────┐
//│ Created by Mirac OZKAN      │
//│ ─────────────────────────── │
//│ mirac.ozkan123@gmail.com    │
//│ ─────────────────────────── │
//│ 12.11.2019 - 09:35          │
//└─────────────────────────────┘

class RetrofitClient {

    private val baseUrl = "https://api.myjson.com/"

    private val retrofit =
        Retrofit
            .Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    private val projectService = retrofit.create(ProjectService::class.java)

    fun getProjectService(): ProjectService = projectService

}