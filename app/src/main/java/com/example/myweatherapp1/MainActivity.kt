package com.example.myweatherapp1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var button: Button

    private val adapterData = listOf<Data>(
        Data(1643692260),
        Data(1643778660),
        Data(1643865060),
        Data(1643951460),
        Data(1644037860),
        Data(1644124260),
        Data(1644210660),
        Data(1644297060),
        Data(1644383460),
        Data(1644469860),
        Data(1644556260),
        Data(1644642660),
        Data(1644729060),
        Data(1644815460),
        Data(1644901860),
        Data(1644988260),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        recyclerView.adapter = MyAdapter(adapterData)

       //button.setOnClickListener { startActivity(Intent(this, ForecastActivity::class.java)) }


    }
}

