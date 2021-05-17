package com.franzandel.feature_home.domain.usecase

import androidx.paging.PagingData
import com.franzandel.feature_home.domain.model.remote.response.GamesResult
import kotlinx.coroutines.flow.Flow

/**
 * Created by Franz Andel on 07/05/21.
 * Android Engineer
 */

interface HomeUseCase {
    suspend fun getAllGames(): Flow<PagingData<GamesResult>>
}