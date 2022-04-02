package com.example.myweatherapp1

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    @GET("weather")
    suspend fun getCurrentConditions(
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