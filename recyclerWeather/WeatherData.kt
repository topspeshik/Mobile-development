package com.example.weatherrecycler

import com.google.gson.annotations.SerializedName

data class WeatherData(

    @SerializedName("sys")
    val weather: Weather?

)