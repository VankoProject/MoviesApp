package com.example.moviesapp.data.database.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "movie_table")
data class MovieDbModel(

    @PrimaryKey
    val id: Int? = null,
    val overview: String? = null,
    @ColumnInfo(name = "poster_path")
    val posterPath: String? = null,
    @ColumnInfo(name = "release_date")
    val releaseDate: String? = null,
    val title: String? = null,
    val video: Boolean? = null,
    @ColumnInfo(name = "vote_average")
    val voteAverage: Double? = null,

)
