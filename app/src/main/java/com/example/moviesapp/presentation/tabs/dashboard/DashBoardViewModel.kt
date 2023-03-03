package com.example.moviesapp.presentation.tabs.dashboard

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesapp.data.MovieListRepositoryImpl
import com.example.moviesapp.domain.usescase.movie.GetMovieListUseCase
import com.example.moviesapp.domain.usescase.movie.LoadDataUseCase
import kotlinx.coroutines.launch

class DashBoardViewModel(application: Application) : AndroidViewModel(application) {

   private val repository = MovieListRepositoryImpl(application)
   private val getMovieListUseCase = GetMovieListUseCase(repository)
   private val loadDataUseCase = LoadDataUseCase(repository)

   val moviePopularList = getMovieListUseCase()

    init {
        viewModelScope.launch {
            loadDataUseCase.loadData()
        }
    }

}