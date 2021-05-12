package com.franzandel.dicodingexpertsubmission.domain.repository

import com.franzandel.dicodingexpertsubmission.core.wrapper.Result
import com.franzandel.dicodingexpertsubmission.domain.model.local.request.GamesResultRequest

/**
 * Created by Franz Andel on 11/05/21.
 * Android Engineer
 */

interface DetailRepository {
    suspend fun insertGamesResults(gamesResultRequest: GamesResultRequest): Result<Unit>
    suspend fun deleteGamesResults(gamesResultRequest: GamesResultRequest): Result<Unit>
    suspend fun getGamesResults(name: String): Result<GamesResultRequest>
}