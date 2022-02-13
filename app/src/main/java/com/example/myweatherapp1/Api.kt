package com.example.myweatherapp1

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    @GET("weather")
    fun getCurrentConditions(
        @Query("zip") zip:String,
        @Query("units") units: String = "imperial",
        @Query("appid")appid: String = "65d0dbe0426f683cc656687df21d2bbe",
    ) : Call<CurrentConditions>
}