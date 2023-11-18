package com.example.retrofit.Server

import com.example.retrofit.Utils.Constans
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ApiClient {

    private lateinit var retrofit_setting : Retrofit

    private val client = OkHttpClient.Builder()
        .readTimeout(Constans.NETWORK_TIMEOUT , TimeUnit.SECONDS)
        .connectTimeout(Constans.NETWORK_TIMEOUT , TimeUnit.SECONDS)
        .writeTimeout(Constans.NETWORK_TIMEOUT , TimeUnit.SECONDS)
        .build()

    fun getClient() : Retrofit {
        retrofit_setting = Retrofit.Builder()
            .baseUrl(Constans.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
        return retrofit_setting
    }
}