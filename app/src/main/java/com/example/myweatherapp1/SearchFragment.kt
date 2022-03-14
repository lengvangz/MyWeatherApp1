package com.example.myweatherapp1

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.myweatherapp1.viewmodels.SearchViewModel

class SearchFragment: Fragment() {
    private lateinit var viewModel: SearchViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.showErrorDialog.observe(this) { showError ->
            if(showError) {
                ErrorDialogFragment().show(childFragmentManager,"")
            }
        }
    }
}