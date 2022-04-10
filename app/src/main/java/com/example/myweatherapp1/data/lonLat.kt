package com.example.myweatherapp1.data

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
class Coordinates (
    @Json(name = "lat") val latitude: Double,
    @Json(name = "lon") val longitude: Double,

    ): Parcelable