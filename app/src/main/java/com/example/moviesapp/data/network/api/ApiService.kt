package com.example.moviesapp.data.network.api

import com.example.moviesapp.data.network.model.MovieInfoDto
import com.example.moviesapp.data.network.model.MoviesListDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("3/movie/popular")
    suspend fun getPopularMovies(
        @Query(QUERY_PARAM_API_KEY) apiKey: String = API_KEY,
        @Query(QUERY_PARAM_LANGUAGE) language: String = "en-US",
        @Query(QUERY_PARAM_PAGE) page: Int = 1
    ): MoviesListDto

    @GET("3/movie/{movie_id}")
    suspend fun getMovieInfo(
        @Path(PATH_PARAM_ID) id:Int = 550,
        @Query(QUERY_PARAM_API_KEY) apiKey: String = API_KEY,
        @Query(QUERY_PARAM_LANGUAGE) language: String = "en-US"
    ): MovieInfoDto


    companion object {
        private const val QUERY_PARAM_API_KEY = "api_key"
        private const val QUERY_PARAM_PAGE = "page"
        private const val PATH_PARAM_ID = "movie_id"
        private const val QUERY_PARAM_LANGUAGE = "language"

        private const val API_KEY = "b728862be4859f4b752498f3ff892837"
    }
}