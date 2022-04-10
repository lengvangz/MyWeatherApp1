package com.example.myweatherapp1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.activity.addCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myweatherapp1.adapters.ForecastAdapter
import com.example.myweatherapp1.databinding.FragmentForecastBinding
import com.example.myweatherapp1.viewmodels.ForecastViewModel
import javax.inject.Inject

class ForecastFragment : Fragment(R.layout.fragment_forecast) {

    private lateinit var viewBinding: FragmentForecastBinding
    @Inject
    lateinit var viewModel:ForecastViewModel
    private val args: ForecastFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as? AppCompatActivity)?.supportActionBar?.title = "Forecast"

        viewBinding = FragmentForecastBinding.bind(view)

        viewBinding.recyclerView.layoutManager = LinearLayoutManager(requireContext())

        ViewModel.viewState.observe(viewLifecycleOwner) {
            bindView(it)
        }
        viewModel.onViewCreated(args.coordinates)

        requireActivity().onBackPressedDispatcher.addCallback {
            findNavController().navigateUp()
        }
    }

    private fun bindView(state: ForecastViewModel.State) {
        viewBinding.recyclerView.adapter = state.forecast?.forecastItems.let { ForecastAdapter(it)}
    }

}