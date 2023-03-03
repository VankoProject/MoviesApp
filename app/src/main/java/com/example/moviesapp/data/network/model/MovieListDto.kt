package com.example.moviesapp.data.network.model

import com.google.gson.annotations.SerializedName

data class MoviesListDto(

    @SerializedName("page")
    val page: Int? = null,
    @SerializedName("results")
    val results: List<MovieInfoDto>? = null,
    @SerializedName("total_pages")
    val totalPages: Int? = null,
    @SerializedName("total_results")
    val totalResults: Int? = null


)