package com.example.retrofit.Models

import com.google.gson.annotations.SerializedName

data class BodyUserRegister(

    @SerializedName ("email")
    val email : String? ,
    @SerializedName ("password")
    val password : String? ,
    @SerializedName ("name")
    val name : String?
)
