package com.example.myweatherapp1.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myweatherapp1.data.Forecast
import com.example.myweatherapp1.api.Api
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltViewModel
class ForecastViewModel @Inject constructor(private val service: Api): ViewModel(){

    private val _forecast = MutableLiveData<Forecast>()
    val forecast: LiveData<Forecast>
        get() = _forecast

    fun loadData() = runBlocking {
        launch {
            _forecast.value = service.getForecast("54016")
        }
    }
}