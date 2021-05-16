package com.franzandel.core.mapper

import com.franzandel.core.wrapper.Result
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import okhttp3.ResponseBody
import retrofit2.Response

/**
 * Created by Franz Andel on 04/05/21.
 * Android Engineer
 */

@Suppress("UNCHECKED_CAST")
abstract class BaseResponseMapper<SourceType, ResultType>(private val gson: Gson) :
    BaseMapper<SourceType, ResultType>() {

    companion object {
        private const val UNKNOWN_ERROR = "unknown error"
    }

    protected open fun mapErrorMessage(errorBody: ResponseBody): String =
        gson.fromJson<String>(
            errorBody.charStream().readText(),
            object : TypeToken<String>() {}.type
        )

    private fun mapException(errorBody: ResponseBody): Exception =
        Exception(mapErrorMessage(errorBody))

    private fun mapError(response: Response<SourceType>): Result<ResultType> = with(response) {
        val exception = try {
            mapException(errorBody = errorBody() ?: throw Exception(UNKNOWN_ERROR))
        } catch (e: Exception) {
            e
        }

        Result.Error(
            error = exception,
            errorCode = code()
        )
    }

    open fun mapResponse(response: Response<SourceType>): Result<ResultType> = with(response) {
        val responseBody = body()

        if (isSuccessful) {
            if (responseBody != null) Result.Success(
                map(responseBody)
            )
            else Result.Success(Unit as ResultType)
        } else
            mapError(response = response)
    }
}
