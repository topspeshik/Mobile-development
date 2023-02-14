package com.example.gromik2sem1

import com.google.gson.annotations.SerializedName

data class Humans(

    @SerializedName("id")
    val id: Int?,
    @SerializedName("username")
    val username: String?,
    @SerializedName("email")
    val email: String?

)