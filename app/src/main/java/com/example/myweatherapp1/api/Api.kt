package com.example.myweatherapp1.api

import com.example.myweatherapp1.data.CurrentConditions
import com.example.myweatherapp1.data.Forecast
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    @GET("weather")
    suspend fun getCurrentConditions(
        @Query("lat, lon") lat, lon: String,
        @Query("zip") zip: String,
        @Query("units") units: String = "imperial",
        @Query("appid") appId: String = "c163037dbc8433a6fc6ed27e192a5a95",
    ): CurrentConditions

    @GET("forecast/daily")
    suspend fun getForecast(
        @Query("zip") zip: String,
        @Query("units") units: String = "imperial",
        @Query("cnt") count: String = "16",
        @Query("appid") appId: String = "c163037dbc8433a6fc6ed27e192a5a95",
    ): Forecast
}