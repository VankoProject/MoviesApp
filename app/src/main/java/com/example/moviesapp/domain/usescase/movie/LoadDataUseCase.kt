package com.example.moviesapp.domain.usescase.movie

import com.example.moviesapp.domain.MovieListRepository

class LoadDataUseCase(private val movieListRepository: MovieListRepository) {

    suspend fun loadData() = movieListRepository.loadDataToDb()
}