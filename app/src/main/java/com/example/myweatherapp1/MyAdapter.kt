package com.example.myweatherapp1

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter

/**
 *subclass to provide views to the RecyclerView
 */
@SuppressLint("NewApi")
class MyAdapter(
    private val data: List<Data>,
    ) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    /**
     * wrapper around a view for an item
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val iconView: ImageView = view.findViewById(R.id.condition_icon)
        private val dateView: TextView = view.findViewById(R.id.date)
        private val sunriseView: TextView = view.findViewById(R.id.sunrise)
        private val sunsetView: TextView = view.findViewById(R.id.sunset)
        private val currentTempView: TextView = view.findViewById(R.id.temp)
        private val highView: TextView = view.findViewById(R.id.high)
        private val lowView: TextView = view.findViewById(R.id.low)

        fun bind(data: Data) {
            val instant = Instant.ofEpochSecond(data.date)
            val dateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault())
            val formatter = DateTimeFormatter.ofPattern("MMM dd")
            dateView.text = formatter.format(dateTime)
        }
    }

    /**
     * called by RecyclerView when it needs a new holder of the specified type,
     * second parameter is the type
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.forecast_activity,parent,false)

        return ViewHolder(view)
    }

    /**
     * called by RecyclerView to display data at position, second parameter is the position
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])

    }

    /**
     * returns the total number of items that can be displayed
     */
    override fun getItemCount() = data.size
}