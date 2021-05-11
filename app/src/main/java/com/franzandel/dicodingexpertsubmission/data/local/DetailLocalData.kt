package com.franzandel.dicodingexpertsubmission.data.local

import com.franzandel.dicodingexpertsubmission.core.wrapper.Result
import com.franzandel.dicodingexpertsubmission.domain.model.local.request.GamesResultRequest

/**
 * Created by Franz Andel on 01/05/21.
 * Android Engineer
 */

interface DetailLocalData {
    suspend fun insertGamesResults(gamesResultRequest: GamesResultRequest): Result<Unit>
    suspend fun deleteGamesResults(gamesResultRequest: GamesResultRequest): Result<Unit>
    suspend fun getGamesResults(name: String): Result<GamesResultRequest>
}