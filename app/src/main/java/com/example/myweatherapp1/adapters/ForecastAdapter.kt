package com.example.myweatherapp1.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myweatherapp1.data.DayForecast
import com.example.myweatherapp1.R
import com.example.myweatherapp1.data.Forecast

@SuppressLint("NewApi")
class ForecastAdapter(private var data: List<DayForecast>) : RecyclerView.Adapter<ForecastAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding: ViewHolderBinding = ViewHolderBinding.bind(view)
        val textView: TextView = view.findViewById(R.id.sunset)

        fun bind(dayForecast: DayForecast) {
            binding.sunrise.text = ""
            Glide.with(view)
                .load()
                .into()

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.forecast_activity, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dayForecast = data[position]
        holder.bind(dayForecast)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    private fun navigateToForecast() {
        val forecast = Forecast(33f, "Sunny")
        val action = CurrentConditionsFragmentDirections.actionCurrentConditionsFragmentToForecastFragment(forecast)
        findNavController().navigate(action)
    }

}