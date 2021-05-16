package com.franzandel.core.wrapper

/**
 * Created by Franz Andel on 04/05/21.
 * Android Engineer
 */

suspend fun <T> suspendTryCatch(
    codeBlock: suspend () -> Result<T>
): Result<T> = try {
    codeBlock.invoke()
} catch (e: Exception) {
    Result.Error(e)
}