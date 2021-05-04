package com.franzandel.dicodingexpertsubmission.data.remote

import com.franzandel.dicodingexpertsubmission.core.wrapper.Result
import com.franzandel.dicodingexpertsubmission.domain.model.ScreenshotsResponse

/**
 * Created by Franz Andel on 01/05/21.
 * Android Engineer
 */

interface AppRemoteData {
    suspend fun getGameScreenshots(gameId: String): Result<ScreenshotsResponse>
}