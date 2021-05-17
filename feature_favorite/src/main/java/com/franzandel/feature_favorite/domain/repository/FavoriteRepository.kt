package com.franzandel.feature_favorite.domain.repository

import androidx.paging.PagingData
import com.franzandel.core.wrapper.Result
import com.franzandel.feature_favorite.domain.model.local.request.GamesResultRequest
import kotlinx.coroutines.flow.Flow

/**
 * Created by Franz Andel on 12/05/21.
 * Android Engineer
 */

interface FavoriteRepository {
    suspend fun insertGamesResults(gamesResultRequest: GamesResultRequest): Result<Unit>
    suspend fun deleteGamesResults(gamesResultRequest: GamesResultRequest): Result<Unit>
    suspend fun getGamesResults(): Flow<PagingData<GamesResultRequest>>
}