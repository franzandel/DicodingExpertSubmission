package com.franzandel.dicodingexpertsubmission.domain.usecase

import com.franzandel.core.wrapper.Result
import com.franzandel.dicodingexpertsubmission.domain.model.local.Screenshots

/**
 * Created by Franz Andel on 01/05/21.
 * Android Engineer
 */

interface AppUseCase {
    suspend fun getGameScreenshots(gameId: String): Result<Screenshots>
}