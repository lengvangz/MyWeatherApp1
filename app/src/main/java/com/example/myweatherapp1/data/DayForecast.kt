package com.example.myweatherapp1.data

class DayForecast(
    val date: Long,
    val sunrise: Long,
    val sunset: Long,
    //val temp: ForecastTemp,
    val pressure: Float,
    val humidity: Int,
    //val weather: List<WeatherCondition>,
)