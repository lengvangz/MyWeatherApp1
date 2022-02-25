package com.example.myweatherapp1

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


class ForecastActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private val apiKey = "c163037dbc8433a6fc6ed27e192a5a95"
    private lateinit var api: Api
    private lateinit var date: TextView
    private lateinit var sunrise: TextView
    private lateinit var sunset: TextView
    private lateinit var currentTemp: TextView
    private lateinit var high: TextView
    private lateinit var low: TextView

    private val adapterData = listOf<DayForecast>(
        DayForecast(1643692260, 1645406400, 1645477200, 10f, 10),
        DayForecast(1643778660, 1645406400, 1645477200, 10f, 10),
        DayForecast(1643865060, 1645406400, 1645477200, 10f, 10),
        DayForecast(1643951460, 1645406400, 1645477200, 10f, 10),
        DayForecast(1644037860, 1645406400, 1645477200, 10f, 10),
        DayForecast(1644124260, 1645406400, 1645477200, 10f, 10),
        DayForecast(1644210660, 1645406400, 1645477200, 10f, 10),
        DayForecast(1644297060, 1645406400, 1645477200, 10f, 10),
        DayForecast(1644383460, 1645406400, 1645477200, 10f, 10),
        DayForecast(1644469860, 1645406400, 1645477200, 10f, 10),
        DayForecast(1644556260, 1645406400, 1645477200, 10f, 10),
        DayForecast(1644642660, 1645406400, 1645477200, 10f, 10),
        DayForecast(1644729060, 1645406400, 1645477200, 10f, 10),
        DayForecast(1644815460, 1645406400, 1645477200, 10f, 10),
        DayForecast(1644901860, 1645406400, 1645477200, 10f, 10),
        DayForecast(1644988260, 1645406400, 1645477200, 10f, 10),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.forecast_activity)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = MyAdapter(adapterData)

        date = findViewById(R.id.date)
        sunrise = findViewById(R.id.sunrise)
        sunset = findViewById(R.id.sunset)
        currentTemp = findViewById(R.id.current_temp)
        high = findViewById(R.id.fhigh)
        low = findViewById(R.id.flow)

        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.openweathermap.org/data/2.5/forecast/daily/")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()

        api = retrofit.create(Api::class.java)
    }

    override fun onResume() {
        super.onResume()
        val call: Call<Forecast> = api.getForecast("54016")
        call.enqueue(object : Callback<Forecast> {
            override fun onResponse(
                call: Call<Forecast>,
                response: Response<Forecast>
            ) {
                val forecast = response.body()
                forecast?.let {
                    bindData(api)
                }
            }

            override fun onFailure(call: Call<Forecast>, t: Throwable) {

            }

        })
    }

    private fun bindData(api: Api) {

    }
}