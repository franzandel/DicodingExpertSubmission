package com.franzandel.feature_detail.domain.usecase

import com.franzandel.core.wrapper.Result
import com.franzandel.feature_detail.domain.model.local.request.GamesResultRequest
import com.franzandel.feature_detail.presentation.model.GamesResultUI

/**
 * Created by Franz Andel on 11/05/21.
 * Android Engineer
 */

interface DetailUseCase {
    suspend fun insertGamesResults(gamesResultUI: GamesResultUI): Result<Unit>
    suspend fun deleteGamesResults(gamesResultUI: GamesResultUI): Result<Unit>
    suspend fun getGamesResults(name: String): Result<GamesResultRequest>
}