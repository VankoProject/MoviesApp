package com.example.moviesapp.domain.usescase.movie

import androidx.lifecycle.LiveData
import com.example.moviesapp.domain.MovieListRepository
import com.example.moviesapp.domain.model.MovieInfo

class GetMovieListUseCase(private val movieListRepository: MovieListRepository) {

   operator fun invoke(): LiveData<List<MovieInfo>>{
      return movieListRepository.getMovieList()
   }
}