package com.example.myweatherapp1.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class SearchViewModel: ViewModel() {

    private val _showErrorDialog = MutableLiveData(false)
    private val _enableButton = MutableLiveData(false)
    private var zipCode: String? = null

    val showErrorDialog:LiveData<Boolean>
        get() = _showErrorDialog

    val enableButton: LiveData<Boolean>
        get() = _enableButton

    fun updateZipcode(zipCode: String) {
        if (zipCode != this.zipCode) {
            this.zipCode = zipCode
            _enableButton.value = isValidZipCode((zipCode))
        }
    }

    private fun isValidZipCode(zipCode: String): Boolean {
        return zipCode.length == 5 && zipCode.all { it.isDigit() }
    }

    fun submitButtonClicked() {
        /**
         * make api request
         */
        Log.d(SearchViewModel::class.simpleName, zipCode ?: "No Zip yet!")

        //bottom line of code is for demostration purposes, might need to delete it
        _showErrorDialog.value = Random.nextBoolean()
    }
}