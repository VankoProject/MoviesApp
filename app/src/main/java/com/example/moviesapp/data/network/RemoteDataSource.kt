package com.example.moviesapp.data.network

import com.example.moviesapp.data.network.api.ApiService

class RemoteDataSource (private val apiService: ApiService ) {

    suspend fun getPopularMovies() = apiService.getPopularMovies()

    suspend fun getMovieInfo(id: Int) = apiService.getMovieInfo(id = id)
}