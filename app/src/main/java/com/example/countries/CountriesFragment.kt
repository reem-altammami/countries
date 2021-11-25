package com.example.countries

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.countries.databinding.FragmentCountriesBinding


class CountriesFragment : Fragment() {
    private var _binding : FragmentCountriesBinding? = null
    val binding get() = _binding!!
    private val viewModel: ConutriesViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCountriesBinding.inflate(inflater,container,false)
        // Inflate the layout for this fragment
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = this@CountriesFragment
        binding.viewModel = viewModel
        binding.photosGrid.adapter = PhotoGridAdapter()
    }
}