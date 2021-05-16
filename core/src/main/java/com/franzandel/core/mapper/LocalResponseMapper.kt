package com.franzandel.core.mapper

import com.franzandel.core.wrapper.Result

/**
 * Created by Franz Andel on 04/05/21.
 * Android Engineer
 */

fun <ResultType> mapLocalResponse(
    dbResponse: Number,
    successType: ResultType,
    errorMessage: String
): Result<ResultType> =
    if (dbResponse.toLong() >= 0)
        Result.Success(successType)
    else
        Result.Error(Exception(errorMessage))