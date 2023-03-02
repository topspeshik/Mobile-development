package com.example.weatherrecycler.data

import android.os.Parcelable
import com.example.weatherrecycler.data.Temperature
import com.example.weatherrecycler.data.Weather
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class WeatherData(

    @SerializedName("weather")
    val weather: List<Weather>,

    @SerializedName("main")
    val temperature: Temperature,

    @SerializedName("name")
    val name: String?



) : Parcelable