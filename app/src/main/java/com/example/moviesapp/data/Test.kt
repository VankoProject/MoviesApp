package com.example.moviesapp.data

import kotlinx.coroutines.runBlocking
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

data class MoviesList(

    val page: Int? = null,
    val results: List<MovieDetail>? = null,

    )

data class MovieDetail(

    val id: Int? = null,
    val overview: String? = null,
    val poster_path: String? = null,
    val release_date: String? = null,
    val title: String? = null,
    val video: Boolean? = null,
    val vote_average: Double? = null,

    )

interface Api {
    @GET("3/movie/popular")
    suspend fun getPopularMovies(
        @Query("api_key") apiKey: String = "b728862be4859f4b752498f3ff892837",
        @Query("language") language: String = "en-US",
        @Query("page") page: Int = 1
    ): List<MovieDetail>

    @GET("3/movie/{movie_id}")
    suspend fun getMovieInfo(
        @Path("movie_id") id:Int = 550,
        @Query("api_key") apiKey: String = "b728862be4859f4b752498f3ff892837",
        @Query("language") language: String = "en-US"
    ): MovieDetail

}

fun main() = runBlocking {

    val loggingInterceptor = HttpLoggingInterceptor()
        .setLevel(HttpLoggingInterceptor.Level.BODY)

    val client = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .build()

    val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("https://api.themoviedb.org/")
        .client(client)
        .build()

    // create base part of URL with endpoint
    val api = retrofit.create(Api::class.java)

    val response = api.getPopularMovies()

    println("MoviePopularList: $response")

}