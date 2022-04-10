package com.example.myweatherapp1.data

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class WeatherCondition(
    @Json(name = "main") val conditionName: String,
    @Json(name = "icon") val iconName: String,
): Parcelable
