package com.example.weatherrecycler

import com.google.gson.annotations.SerializedName

data class Weather (
    @SerializedName("sunrise")
    val sunrise: Int?,

    @SerializedName("sunset")
    val sunset: Int?
)