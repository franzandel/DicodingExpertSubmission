package com.franzandel.dicodingexpertsubmission.data.remote

import androidx.paging.PagingData
import com.franzandel.dicodingexpertsubmission.domain.model.remote.response.GamesResult
import kotlinx.coroutines.flow.Flow

/**
 * Created by Franz Andel on 07/05/21.
 * Android Engineer
 */

interface HomeRemoteData {
    suspend fun getAllGames(): Flow<PagingData<GamesResult>>
}