package com.franzandel.dicodingexpertsubmission.data.remote

import com.franzandel.dicodingexpertsubmission.core.wrapper.Result
import com.franzandel.dicodingexpertsubmission.domain.model.remote.response.Games

/**
 * Created by Franz Andel on 07/05/21.
 * Android Engineer
 */

interface HomeRemoteData {
    suspend fun getAllGames(): Result<Games>
}