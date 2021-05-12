package com.franzandel.dicodingexpertsubmission.domain.usecase

import androidx.lifecycle.LiveData
import androidx.paging.PagingData
import com.franzandel.dicodingexpertsubmission.domain.model.local.request.GamesResultRequest

/**
 * Created by Franz Andel on 12/05/21.
 * Android Engineer
 */

interface FavoriteUseCase {
    suspend fun getGamesResults(): LiveData<PagingData<GamesResultRequest>>
}