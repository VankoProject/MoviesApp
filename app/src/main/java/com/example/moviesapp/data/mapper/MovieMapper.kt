package com.example.moviesapp.data.mapper

import com.example.moviesapp.data.database.room.MovieDbModel
import com.example.moviesapp.data.network.model.MovieInfoDto
import com.example.moviesapp.data.network.model.MoviesListDto
import com.example.moviesapp.domain.model.MovieInfo

class MovieMapper {

    fun mapMovieInfoDtoToMovieDbModel(dto: MovieInfoDto) = MovieDbModel(
        id = dto.id,
        overview = dto.overview,
        posterPath = dto.posterPath,
        releaseDate = dto.releaseDate,
        title = dto.title,
        voteAverage = dto.voteAverage
    )

    fun mapMovieDbModelToMovieItem(dbModel: MovieDbModel) = MovieInfo(
        id = dbModel.id,
        overview = dbModel.overview,
        posterPath = dbModel.posterPath,
        releaseDate = dbModel.releaseDate,
        title = dbModel.title,
        voteAverage = dbModel.voteAverage
    )



}