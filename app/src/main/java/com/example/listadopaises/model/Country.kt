package com.example.listadopaises.model

data class Country(
    val name: CountryName,
    val flags: CountryFlags,
    val region: String,
    val subregion: String,
    val area: Double,
    val flag: String,
    val capital: List<String>
)

data class CountryName(
    val common: String
)

data class CountryFlags(
    val png: String,
    val svg: String,
    val alt: String
)
