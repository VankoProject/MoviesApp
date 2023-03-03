package com.example.moviesapp.domain.usescase.movie

import androidx.lifecycle.LiveData
import com.example.moviesapp.domain.MovieListRepository
import com.example.moviesapp.domain.model.MovieInfo

class GetMovieInfoByIdUseCase(private val movieListRepository: MovieListRepository) {

    operator fun invoke(movieItemId: Int): LiveData<MovieInfo> {
       return movieListRepository.getMovieInfoById(movieItemId)
    }
}