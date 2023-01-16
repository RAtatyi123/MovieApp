package com.example.movieapp.data.retrofit.api

import com.example.movieapp.models.MoviesModel
import retrofit2.Response
import retrofit2.http.GET


interface ApiService {

    @GET("3/movie/popular?api_key=dfd3f173287a3fab3d4eb3b67da2ef26&language=en-US&page=1")
    suspend fun getPopularMovie(): Response<MoviesModel>

}