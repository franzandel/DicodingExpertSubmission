package com.franzandel.feature_favorite.domain.repository

import com.franzandel.core.wrapper.Result
import com.franzandel.feature_favorite.domain.model.local.request.GamesResultRequest

/**
 * Created by Franz Andel on 11/05/21.
 * Android Engineer
 */

interface DetailFavoriteRepository {
    suspend fun insertGamesResults(gamesResultRequest: GamesResultRequest): Result<Unit>
    suspend fun deleteGamesResults(gamesResultRequest: GamesResultRequest): Result<Unit>
    suspend fun getGamesResult(name: String): Result<GamesResultRequest>
}