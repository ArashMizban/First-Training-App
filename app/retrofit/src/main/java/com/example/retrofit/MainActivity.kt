package com.example.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.retrofit.Models.ResponseMoviesList
import com.example.retrofit.Server.ApiClient
import com.example.retrofit.Server.ApiServices
import com.example.retrofit.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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

        binding.apply {

            moviesLoader.visibility = View.VISIBLE
            //call movi api
            val callmovies = api.moviesList(1)
            callmovies.enqueue(object : Callback<ResponseMoviesList>{
                override fun onResponse(
                    call: Call<ResponseMoviesList>, response: Response<ResponseMoviesList>) {
                    moviesLoader.visibility = View.GONE
                    if (response.isSuccessful) {
                        response.body()?.let { itbody ->
                            itbody.data?.let { itdata ->
                                if (itdata.isNotEmpty()) {
                                    moviesAdapter.moviediffer.submitList(itdata)
                                    //Recycler
                                    moviesRecycler.apply {
                                        layoutManager = LinearLayoutManager(this@MainActivity)
                                        adapter = moviesAdapter
                                    }
                                }
                            }
                        }
                    }
                }

                override fun onFailure(call: Call<ResponseMoviesList>, t: Throwable) {
                    moviesLoader.visibility = View.GONE
                    Log.e("OnFailure" , "Error : ${t.message}")
                }

            })
        }
    }
}