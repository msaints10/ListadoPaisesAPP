package com.example.listadopaises.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.listadopaises.model.Country
import com.example.listadopaises.network.RetrofitClient
import kotlinx.coroutines.launch

class CountriesViewModel : ViewModel() {

    private val _countries = MutableLiveData<List<Country>>()
    val countries: LiveData<List<Country>> = _countries

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    fun loadCountries() {
        viewModelScope.launch {
            try {
                val countryList = RetrofitClient.api.getAllCountries()
                _countries.postValue(countryList)
            } catch (e: Exception) {
                _error.postValue("Error al cargar países: ${e.message}")
            }
        }
    }
}