package com.example.moviesapp.domain

import androidx.lifecycle.LiveData
import com.example.moviesapp.domain.model.MovieInfo

interface MovieListRepository {

    fun getMovieList(): LiveData<List<MovieInfo>>

    fun getMovieInfoById(movieItemId: Int): LiveData<MovieInfo>

    suspend fun loadDataToDb()

    suspend fun addFavoriteMovie(movieInfo: MovieInfo)

    suspend fun deleteFavoriteMovie(movieInfo: MovieInfo)

    fun getMovieTrailerById(movieItemId: Int): MovieInfo

    fun searchMovieByTitle(title: String): MovieInfo

}