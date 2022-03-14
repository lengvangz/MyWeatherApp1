package com.example.myweatherapp1

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.example.myweatherapp1.databinding.SearchActivityBinding
import com.example.myweatherapp1.viewmodels.SearchViewModel

/**
 * apply health/dependency
 */

class SearchActivity: AppCompatActivity() {
    private lateinit var searchViewModel: SearchViewModel
    private lateinit var binding: SearchActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SearchActivityBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        searchViewModel = SearchViewModel()

        searchViewModel.enableButton.observe(this) { enable ->
            binding.button.isEnabled = enable
        }

        searchViewModel.showErrorDialog.observe(this) { showError ->
            if (showError) {
                ErrorDialogFragment().show(supportFragmentManager, ErrorDialogFragment.TAG)
            }
        }

        binding.zipCode.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                p0?.toString()?.let { searchViewModel.updateZipcode(it) }
            }

            override fun afterTextChanged(p0: Editable?) {

            }
        })

        binding.button.setOnClickListener {
            searchViewModel.submitButtonClicked()
        }
    }
}