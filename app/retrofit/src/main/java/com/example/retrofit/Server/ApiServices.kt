package com.example.retrofit.Server

import com.example.retrofit.Models.BodyUserRegister
import com.example.retrofit.Models.ResponseGenereMovies
import com.example.retrofit.Models.ResponseMovieInformations
import com.example.retrofit.Models.ResponseMoviesList
import com.example.retrofit.Models.ResponseUserRegister
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiServices {

    @GET("movies")
    fun moviesList(@Query("page") page:Int) : Call<ResponseMoviesList>

    @GET("movies/{movie_id}")
    fun  movieinformations(@Path("movie_id") id:Int) : Call<ResponseMovieInformations>

    @GET("genres/{genre_id}/movies")
    fun moviegeners(@Path("genre_id") id: Int , @Query("page") page: Int) : Call<ResponseGenereMovies>

    @POST("register")
    fun movieuserregister(@Body body:BodyUserRegister) : Call<ResponseUserRegister>

}