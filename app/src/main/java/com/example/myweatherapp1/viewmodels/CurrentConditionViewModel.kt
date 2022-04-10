package com.example.myweatherapp1.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myweatherapp1.data.Coordinates
import com.example.myweatherapp1.data.CurrentConditions
import javax.inject.Inject

class CurrentConditionViewModel @Inject constructor(): ViewModel() {
    private lateinit var currentConditions: CurrentConditions
    private val _viewState = MutableLiveData(State.DEFAULT)
    val viewState: LiveData<State> = _viewState
    private val _navigateToForecast = MutableLiveData<Coordinates?>()
    val navigateToForecast: LiveData<Coordinates?> = _navigateToForecast

    fun onViewCreate(currentConditions: CurrentConditions) {
        this.currentConditions = currentConditions
        _viewState.value = _viewState.value?.copy(currentConditions = currentConditions)
        _navigateToForecast.value = null
    }

    fun forecastButtonClicked() {
        _navigateToForecast.value = currentConditions.currents
    }

    data class State(
        val currentConditions: CurrentConditions?
    ) {
        companion object {
            internal val DEFAULT = State(null)
        }
    }
}