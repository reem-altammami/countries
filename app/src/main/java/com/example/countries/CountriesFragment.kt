package com.example.countries

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.countries.databinding.FragmentCountriesBinding


class CountriesFragment : Fragment() {

    private val viewModel: ConutriesViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentCountriesBinding.inflate(inflater)
        // Inflate the layout for this fragment
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.photosGrid.adapter = PhotoGridAdapter()
        return binding.root

    }

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        binding.lifecycleOwner = this@CountriesFragment
//        binding.viewModel = viewModel
//        binding.photosGrid.adapter = PhotoGridAdapter()
//    }
}