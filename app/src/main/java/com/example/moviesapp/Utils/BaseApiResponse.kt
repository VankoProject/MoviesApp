package com.example.moviesapp.Utils

import retrofit2.Response

abstract class BaseApiResponse {


    suspend fun <T> saveApiCall(api: suspend () -> Response<T>): NetworkResult<T> {
        try {
            val response = api()
            if (response.isSuccessful) {
                val body = response.body()
                body?.let {
                    return NetworkResult.Success(body)
                } ?: return sendError("${response.code()} ${response.message()}")
            } else {
                return sendError("Error")
            }
        } catch (e: Exception) {
            return sendError(e.toString())
        }
    }

    private fun <T> sendError(e: String): NetworkResult.Error<T> =
        NetworkResult.Error(data = null, message = "Api call failed: $e")


}