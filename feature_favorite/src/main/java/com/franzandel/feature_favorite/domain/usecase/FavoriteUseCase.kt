package com.franzandel.feature_favorite.domain.usecase

import androidx.paging.PagingData
import com.franzandel.core.wrapper.Result
import com.franzandel.feature_favorite.domain.model.local.request.GamesResultRequest
import com.franzandel.feature_favorite.presentation.model.GamesResultUI
import kotlinx.coroutines.flow.Flow

/**
 * Created by Franz Andel on 12/05/21.
 * Android Engineer
 */

interface FavoriteUseCase {
    suspend fun insertGamesResults(gamesResultUI: GamesResultUI): Result<Unit>
    suspend fun deleteGamesResults(gamesResultUI: GamesResultUI): Result<Unit>
    suspend fun getGamesResults(): Flow<PagingData<GamesResultRequest>>
}