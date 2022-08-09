package com.example.newsapplication.common

sealed class ApiResult<T>(val data: T? = null, val message: String? = null) {

    /**
     * success response with data
     */
    class Success<T>(data: T?) : ApiResult<T>(data)

    /**
     * Failure response
     */
    class Error<T>(message: String, data: T? = null) : ApiResult<T>(data, message)

    /**
     * Loading
     */
    class Loading<T>(data: T? = null) : ApiResult<T>(data)
}