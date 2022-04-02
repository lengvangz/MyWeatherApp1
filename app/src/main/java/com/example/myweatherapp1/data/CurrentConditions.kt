package com.example.myweatherapp1.data

data class CurrentConditions(
    val weather: List<WeatherCondition>,
    val lonLat: lonLat,
    val main: Currents,
    val name: String,
)
