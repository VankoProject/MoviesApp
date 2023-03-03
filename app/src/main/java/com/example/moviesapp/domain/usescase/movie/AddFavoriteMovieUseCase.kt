package com.example.moviesapp.domain.usescase.movie

import com.example.moviesapp.domain.MovieListRepository
import com.example.moviesapp.domain.model.MovieInfo

class AddFavoriteMovieUseCase(private val movieListRepository: MovieListRepository) {

    suspend operator fun invoke(movieInfo: MovieInfo) {
        movieListRepository.addFavoriteMovie(movieInfo)
    }
}