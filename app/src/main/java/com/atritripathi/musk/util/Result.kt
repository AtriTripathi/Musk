package com.atritripathi.musk.util

sealed class Result<T>(
    val data: T? = null,
    val error: Throwable? = null
) {
    class Success<T>(data: T) : Result<T>(data)
    class Loading<T>(data: T? = null) : Result<T>(data)
    class Error<T>(throwable: Throwable, data: T? = null) : Result<T>(data, throwable)
}