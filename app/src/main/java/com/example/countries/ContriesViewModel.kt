package com.example.countries

import android.util.Log
import android.widget.ImageView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.countries.network.ContriesPhoto
import com.example.countries.network.CountriesApi
import com.example.countries.network.Response
import kotlinx.coroutines.launch

class ConutriesViewModel : ViewModel() {


    private val _status = MutableLiveData<String>()

    val status: LiveData<String> = _status

   private val _listCountry = MutableLiveData<List<ContriesPhoto>>()
    val listCountry: LiveData<List<ContriesPhoto>> = _listCountry



    init {
        getCountriesPhotos()
    }

    private fun getCountriesPhotos() {
        viewModelScope.launch {

            try {
                val listResult = CountriesApi.retrofitService.getPhotos().msg
                Log.e("TAG", "getCountriesPhotos: try")
             _listCountry.value = CountriesApi.retrofitService.getPhotos().data
                Log.e("TAG", "getCountriesPhotos: ${_listCountry!!.value?.size}", )
//                _status.value = "Success: ${listCountry.value?.size} Countries photos retrieved"
                _status.value = "Success: ${listResult} Countries photos retrieved"
            } catch (e: Exception) {
                _status.value = "Failure: ${e.message}"
                Log.e("TAG", "getCountriesPhotos: error")
            }
        }
    }
}