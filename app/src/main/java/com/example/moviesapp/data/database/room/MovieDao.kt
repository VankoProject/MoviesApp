package com.example.moviesapp.data.database.room

import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface MovieDao {

    @Query("SELECT * FROM movie_table")
    fun getMovieList(): LiveData<List<MovieDbModel>>

    @Query("SELECT * FROM movie_table WHERE id =:movieId")
    fun getMovieById(movieId: Int): MovieDbModel

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addMovieList(movieList: List<MovieDbModel>)

    @Delete
    suspend fun deleteMovie(movieDbModel: MovieDbModel)

}