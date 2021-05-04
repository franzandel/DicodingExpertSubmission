package com.franzandel.dicodingexpertsubmission.domain.repository

import com.franzandel.dicodingexpertsubmission.core.wrapper.Result
import com.franzandel.dicodingexpertsubmission.domain.model.Screenshots

/**
 * Created by Franz Andel on 01/05/21.
 * Android Engineer
 */

interface AppRepository {
    suspend fun getGameScreenshots(gameId: String): Result<Screenshots>
}