package com.example.myweatherapp1

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.myweatherapp1.databinding.ActivityMainBinding

class CurrentConditionsFragment: Fragment(R.layout.activity_main)  {
    private lateinit var binding: ActivityMainBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = ActivityMainBinding.bind(view)
        binding.button.setOnClickListener {
            Toast.makeText(content, "It worked!", Toast.LENGTH_LONG.show())
        }
    }

    companion object {
        const val TAG = "CurrentConditionsFragment"
    }
}