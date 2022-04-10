package com.example.myweatherapp1.data

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class Currents(
    @Json(name = "temp") val temperature: Double,
    @Json(name = "feels_like") val feelsLike: Float,
    @Json(name = "temp_min") val tempMin: Float,
    @Json(name = "temp_max") val tempMax: Float,
    @Json(name = "pressure") val pressure: Double,
    @Json(name = "humidity") val humidity: Double,
): Parcelable
