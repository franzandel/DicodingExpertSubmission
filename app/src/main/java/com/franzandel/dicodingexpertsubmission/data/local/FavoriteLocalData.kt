package com.franzandel.dicodingexpertsubmission.data.local

import androidx.paging.PagingData
import com.franzandel.dicodingexpertsubmission.core.wrapper.Result
import com.franzandel.dicodingexpertsubmission.domain.model.local.request.GamesResultRequest
import kotlinx.coroutines.flow.Flow

/**
 * Created by Franz Andel on 12/05/21.
 * Android Engineer
 */

interface FavoriteLocalData {
    suspend fun insertGamesResults(gamesResultRequest: GamesResultRequest): Result<Unit>
    suspend fun deleteGamesResults(gamesResultRequest: GamesResultRequest): Result<Unit>
    suspend fun getGamesResults(): Flow<PagingData<GamesResultRequest>>
}