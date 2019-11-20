package com.miracozkan.iuc_android_workshop_01.remote.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Data(
    val about: String,
    val director: String,
    val genre: String,
    val id: Int,
    val poster: String,
    val title: String,
    val year: String
) : Parcelable