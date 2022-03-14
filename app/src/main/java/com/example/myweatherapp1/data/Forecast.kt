package com.example.myweatherapp1.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Forecast(val temp: Float, val condition: String) : Parcelable
