package com.example.myweatherapp1

data class CurrentConditions(
    val weather: List<WeatherCondition>,
    val main: Currents,
    val name: String,
)
