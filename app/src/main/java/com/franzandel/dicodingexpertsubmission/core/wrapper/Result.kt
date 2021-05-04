package com.franzandel.dicodingexpertsubmission.core.wrapper

/**
 * Created by Franz Andel on 04/05/21.
 * Android Engineer
 */

sealed class Result<out T> {
    data class Success<out S>(val data: S?) : Result<S>()
    data class Error(val error: Exception, val errorCode: Int = -1) : Result<Nothing>()
}

val <T> Result.Success<T>.response: T
    get() = this.data ?: throw Exception("data is null")
