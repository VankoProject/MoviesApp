package com.example.moviesapp.domain.usescase.movie

import com.example.moviesapp.domain.MovieListRepository
import com.example.moviesapp.domain.model.MovieInfo

class SearchMovieByTitleUseCase(private val movieListRepository: MovieListRepository) {

    operator fun invoke(title: String): MovieInfo{
        return movieListRepository.searchMovieByTitle(title)
    }
}