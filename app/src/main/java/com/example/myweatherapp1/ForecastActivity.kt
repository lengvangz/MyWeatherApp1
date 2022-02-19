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


class ForecastActivity : AppCompatActivity(){

    private lateinit var recyclerView: RecyclerView
    private val apiKey = "c163037dbc8433a6fc6ed27e192a5a95"
    private lateinit var api: Api
    private lateinit var date: TextView
    private lateinit var sunrise: TextView
    private lateinit var sunset: TextView
    private lateinit var currentTemp: TextView
    private lateinit var high: TextView
    private lateinit var low: TextView
    private lateinit var conditionIcons: ImageView

    private val adapterData = listOf<Data>(
        Data(1643692260),
        Data(1643778660),
        Data(1643865060),
        Data(1643951460),
        Data(1644037860),
        Data(1644124260),
        Data(1644210660),
        Data(1644297060),
        Data(1644383460),
        Data(1644469860),
        Data(1644556260),
        Data(1644642660),
        Data(1644729060),
        Data(1644815460),
        Data(1644901860),
        Data(1644988260),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.forecast_activity)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = MyAdapter(adapterData)
        
        conditionIcons = findViewById(R.id.condition_icons)
        date = findViewById(R.id.date)
        sunrise = findViewById(R.id.sunrise)
        sunset = findViewById(R.id.sunset)
        currentTemp = findViewById(R.id.temp)
        high = findViewById(R.id.high)
        low = findViewById(R.id.low)

        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.openweathermap.org/data/2.5/forecast/daily")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()

        api = retrofit.create(Api::class.java)
    }

    override fun onResume() {
        super.onResume()
        val call: Call<Forecast> = api.getForecast("55423")
        call.enqueue(object : Callback<Forecast> {
            override fun onResponse(
                call: Call<Forecast>,
                response: Response<Forecast>
            ) {
                val forecast = response.body()
                forecast?.let {
                    bindData(it)
                }
            }

            override fun onFailure(call: Call<Forecast>, t: Throwable) {

            }

        } )
    }

    private fun bindData(forecast: Forecast) {
        date.text = forecast.listForecast.firstOrNull()?.date.toString()
        sunrise.text = forecast.sunrise
        sunset.text = forecast.sunset
        currentTemp.text = forecast.temp
        high.text = forecast.high
        low.text = forecast.low
        val iconName = forecast.listForecast.firstOrNull()?.
        val iconUrl = "https://openweathermap.org/img/wn/${iconName}@2x.png"
        Glide.with(this)
            .load(iconUrl)
            .into(conditionIcons)


    }
}