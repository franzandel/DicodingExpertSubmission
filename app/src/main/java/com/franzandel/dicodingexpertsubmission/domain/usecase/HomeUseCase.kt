package com.franzandel.dicodingexpertsubmission.domain.usecase

import com.franzandel.dicodingexpertsubmission.core.wrapper.Result
import com.franzandel.dicodingexpertsubmission.presentation.model.GamesResultUI

/**
 * Created by Franz Andel on 07/05/21.
 * Android Engineer
 */

interface HomeUseCase {
    suspend fun getAllGames(): Result<List<GamesResultUI>>
}