package com.franzandel.feature_home.data.local

import com.franzandel.core.wrapper.Result
import com.franzandel.feature_home.domain.model.local.request.GamesResultRequest

/**
 * Created by Franz Andel on 01/05/21.
 * Android Engineer
 */

interface DetailLocalData {
    suspend fun insertGamesResults(gamesResultRequest: GamesResultRequest): Result<Unit>
    suspend fun deleteGamesResults(gamesResultRequest: GamesResultRequest): Result<Unit>
    suspend fun getGamesResults(name: String): Result<GamesResultRequest>
}