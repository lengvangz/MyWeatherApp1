package com.example.myweatherapp1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.myweatherapp1.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    @Inject lateinit var viewModel: MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            startActivity(Intent(this, ForecastActivity::class.java))
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.currentConditions.observe(this ) { currentConditions ->
            bindData(currentConditions)
        }
        viewModel.loadData()

    }

    private fun bindData(currentConditions: CurrentConditions) {
        binding.cityName.text = currentConditions.name
        binding.temperature.text = getString(R.string.temperature, currentConditions.main.temp.toInt())
        binding.feelsLike.text = getString(R.string.feels_like, currentConditions.main.feelsLike.toInt())
        binding.low.text = getString(R.string.low, currentConditions.main.tempMin.toInt())
        binding.high.text = getString(R.string.high, currentConditions.main.tempMax.toInt())
        binding.humidity.text = getString(R.string.humidity, currentConditions.main.humidity.toInt())
        binding.pressure.text = getString(R.string.pressure, currentConditions.main.pressure.toInt())
        val iconName = currentConditions.weather.firstOrNull()?.icon
        val iconUrl = "https://openweathermap.org/img/wn/${iconName}@2x.png"
        Glide.with(this)
            .load(iconUrl)
            .into(binding.conditionIcon)

    }
}


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