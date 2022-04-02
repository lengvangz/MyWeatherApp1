package com.example.myweatherapp1

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation.findNavController
import com.example.myweatherapp1.databinding.SearchActivityBinding
import com.example.myweatherapp1.viewmodels.SearchViewModel

class SearchFragment: Fragment() {
    private lateinit var viewModel: SearchViewModel
    private lateinit var binding: SearchActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.showErrorDialog.observe(this) { showError ->
            if(showError) {
                ErrorDialogFragment().show(childFragmentManager,"")
            }
            binding.button.setOnClickListener {
                findNavController().navigate(R.id.action_currentConditionsFragment_to_forecastFragment)
            }
        }
    }
}