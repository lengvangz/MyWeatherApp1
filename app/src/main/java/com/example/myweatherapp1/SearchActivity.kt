package com.example.myweatherapp1

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.myweatherapp1.databinding.SearchActivityBinding
import com.example.myweatherapp1.viewmodels.SearchViewModel

/**
 * apply health/dependency
 */

class SearchActivity: AppCompatActivity() {
    private lateinit var searchViewModel: SearchViewModel
    private lateinit var binding: SearchActivityBinding
    private lateinit var locationPermissionRequest: ActivityResultLauncher<Array<String>>
    private lateinit var locationProvider: FusedLocationProviderClient

    @SuppressLint("NewApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SearchActivityBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)
        locationPermissionRequest = registerForActivityResult(
            ActivityResultContracts.RequestMultiplePermissions()
        ) {
            permission ->
            when {
                permissions.getOrDefault(Manifest.permission.ACCESS_COARSE_LOCATION, false) -> {
                    requestLocation()
                }
                else -> {
                    //No location access grated
                }
            }
        }

        val button = findViewById<MaterialButton>(R.id.location_button)
        button.setOnClickListener{
            requestLocation()
        }


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