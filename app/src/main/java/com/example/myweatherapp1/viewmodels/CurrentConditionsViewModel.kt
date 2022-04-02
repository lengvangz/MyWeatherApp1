package com.example.myweatherapp1.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myweatherapp1.data.CurrentConditions
import com.example.myweatherapp1.api.Api
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltViewModel
class CurrentConditionsViewModel @Inject constructor(private val service: Api): ViewModel() {

    private val _currentConditions = MutableLiveData<CurrentConditions>()
    val currentConditions: LiveData<CurrentConditions>
        get() = _currentConditions

    fun loadData() =  runBlocking {
        launch {
            _currentConditions.value = service.getCurrentConditions("54016")
        }
    }

}