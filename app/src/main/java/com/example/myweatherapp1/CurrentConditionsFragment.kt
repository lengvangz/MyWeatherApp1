package com.example.myweatherapp1

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.myweatherapp1.data.Forecast
import com.example.myweatherapp1.databinding.ActivityMainBinding

class CurrentConditionsFragment: Fragment(R.layout.activity_main)  {
    private lateinit var binding: FragmentCurrentConditionsBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCurrentConditionsBinding.bind(view)
        binding.button.setOnClickListener {
            navigateToForecast()
        }

        binding.toolbar.setTitleTextColor(ContextCompat.getColor(requireContext(), R.color.white))
        binding.toolbar.title = "Current Conditions"

    }

    private fun navigateToForecast() {
        val forecast = Forecast(33f, "Sunny")
        val action = CurrentConditionsFragmentDirections.actionCurrentConditionsFragmentToForecast(forecast)
    }

    companion object {
        const val TAG = "CurrentConditionsFragment"
        const val KEY_ZIP = "zip"

        fun create(zipCode: String): CurrentConditionsFragment {
            val fragment = CurrentConditionsFragment()
            fragment.arguments = Bundle().apply {
                putString(KEY_ZIP, zipCode)
            }
            return fragment

        }
    }
}