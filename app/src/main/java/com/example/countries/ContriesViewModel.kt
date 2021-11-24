package com.example.countries

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.countries.network.CountriesApi
import kotlinx.coroutines.launch

class ConutriesViewModel : ViewModel() {

    private val _status = MutableLiveData<String>()

    val status: LiveData<String> = _status
    init {
        getCountriesPhotos()
    }

    private fun getCountriesPhotos() {
        viewModelScope.launch {

            try {
                val listResult = CountriesApi.retrofitService.getPhotos()
                _status.value = "Success: ${listResult.size} Countries photos retrieved"
            } catch (e: Exception) {
                _status.value = "Failure: ${e.message}"

            }
        }
    }
}