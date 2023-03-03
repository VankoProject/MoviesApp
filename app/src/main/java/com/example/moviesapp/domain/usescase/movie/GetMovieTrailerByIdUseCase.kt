package com.example.moviesapp.domain.usescase.movie

import com.example.moviesapp.domain.MovieListRepository
import com.example.moviesapp.domain.model.MovieInfo

class GetMovieTrailerByIdUseCase(private val movieListRepository: MovieListRepository) {

    operator fun invoke(movieItemId: Int): MovieInfo {
        return movieListRepository.getMovieTrailerById(movieItemId)
    }
}