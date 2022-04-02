package com.example.myweatherapp1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myweatherapp1.databinding.ForecastActivityBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ForecastActivity : AppCompatActivity() {

    private lateinit var binding: ForecastActivityBinding
    @Inject lateinit var viewModel: ForecastViewModel
    private lateinit var adapter: ForecastAdapter
    private lateinit var recyclerView: RecyclerView
    private val apiKey = "c163037dbc8433a6fc6ed27e192a5a95"
    private lateinit var api: Api

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ForecastActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = ForecastAdapter(emptyList())

        viewModel.forecast.observe(this) {
            recyclerView.adapter = ForecastAdapter(it.list)
        }

    }
}