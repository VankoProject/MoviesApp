package com.example.moviesapp.data

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.moviesapp.data.database.room.AppDataBase
import com.example.moviesapp.data.mapper.MovieMapper
import com.example.moviesapp.data.network.api.ApiFactory
import com.example.moviesapp.domain.MovieListRepository
import com.example.moviesapp.domain.model.MovieInfo
import kotlinx.coroutines.delay

class MovieListRepositoryImpl(
    private val application: Application,
) : MovieListRepository{

    private val apiService = ApiFactory.apiService
    private val movieDao = AppDataBase.getInstance(application).movieDao()
    private val mapper = MovieMapper()


    override fun getMovieList(): LiveData<List<MovieInfo>> {
        return Transformations.map(movieDao.getMovieList()) {it ->
            it.map {
                mapper.mapMovieDbModelToMovieItem(it)
            }
        }
    }


    override fun getMovieInfoById(movieItemId: Int): LiveData<MovieInfo> {
        TODO("Not yet implemented")
    }

    override suspend fun loadDataToDb() {
        while (true) {
            try {
                val moviesListDto = apiService.getPopularMovies()
                val dbModelList = moviesListDto.results?.map {
                    mapper.mapMovieInfoDtoToMovieDbModel(it)
                }
                dbModelList?.let { movieDao.addMovieList(it) }
            } catch (e: Exception) {
            }
            delay(600000)
        }
    }

    override suspend fun addFavoriteMovie(movieInfo: MovieInfo) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteFavoriteMovie(movieInfo: MovieInfo) {
        TODO("Not yet implemented")
    }

    override fun getMovieTrailerById(movieItemId: Int): MovieInfo {
        TODO("Not yet implemented")
    }

    override fun searchMovieByTitle(title: String): MovieInfo {
        TODO("Not yet implemented")
    }


}