package com.example.recyclerweather

import com.google.gson.annotations.SerializedName

data class Temperature (

    @SerializedName("temp")
    val temp: String?
)