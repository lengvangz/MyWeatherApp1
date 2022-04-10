package com.example.myweatherapp1.data

import android.os.Parcelable
import android.service.notification.Condition
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class CurrentConditions(
    @Json(name = "weather") val weather: List<WeatherCondition>,
    @Json(name = "coord") val currents: Currents,
    @Json(name = "main") val condition: Condition,
    @Json(name = "name") val cityName: String,
): Parcelable
