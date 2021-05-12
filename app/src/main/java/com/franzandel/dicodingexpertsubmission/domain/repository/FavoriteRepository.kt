package com.franzandel.dicodingexpertsubmission.domain.repository

import androidx.paging.PagingData
import com.franzandel.dicodingexpertsubmission.domain.model.local.request.GamesResultRequest
import kotlinx.coroutines.flow.Flow

/**
 * Created by Franz Andel on 12/05/21.
 * Android Engineer
 */

interface FavoriteRepository {
    suspend fun getGamesResults(): Flow<PagingData<GamesResultRequest>>
}