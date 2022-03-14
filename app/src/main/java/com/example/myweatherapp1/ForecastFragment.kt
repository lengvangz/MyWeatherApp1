package com.example.myweatherapp1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.myweatherapp1.databinding.FragmentForecastBinding

class ForecastFragment : Fragment(R.layout.fragment_forecast) {

    private val args: ForecastFragmentArgs by navArgs()
    private lateinit var binding: FragmentForecastBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentForecastBinding.bind(view)
        binding.temp.text = "${args.forecast.temp}"
        binding.condition.text = args.forecast.condition
    }
}