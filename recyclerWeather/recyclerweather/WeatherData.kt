package com.example.recyclerweather

import com.google.gson.annotations.SerializedName

data class WeatherData(

    @SerializedName("weather")
    val weather: List<Weather>,

    @SerializedName("main")
    val temperature: Temperature,

    @SerializedName("name")
    val name: String?



)