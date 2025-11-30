package com.example.listadopaises.network

import com.example.listadopaises.model.Country
import retrofit2.http.GET

interface RestCountriesService {
    @GET("v3.1/all?fields=name,region,area,subregion,flag,flags,capital")
    suspend fun getAllCountries(): List<Country>
}