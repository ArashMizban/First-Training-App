package com.example.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.retrofit.Server.ApiClient
import com.example.retrofit.Server.ApiServices
import com.example.retrofit.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    //MovieAdapter
    private val moviesAdapter by lazy { MoviesAdapter() }

    //ApiServices
    private val api:ApiServices by lazy {
        ApiClient().getClient().create(ApiServices::class.java)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}