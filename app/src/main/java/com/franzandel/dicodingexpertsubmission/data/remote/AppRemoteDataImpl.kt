package com.franzandel.dicodingexpertsubmission.data.remote

import com.franzandel.dicodingexpertsubmission.BuildConfig
import com.franzandel.dicodingexpertsubmission.core.mapper.BaseResponseMapper
import com.franzandel.dicodingexpertsubmission.core.wrapper.Result
import com.franzandel.dicodingexpertsubmission.core.wrapper.suspendTryCatch
import com.franzandel.dicodingexpertsubmission.data.remote.model.ScreenshotsDTO
import com.franzandel.dicodingexpertsubmission.data.remote.network.AppService
import com.franzandel.dicodingexpertsubmission.domain.model.Screenshots
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class AppRemoteDataImpl @Inject constructor(
    private val service: AppService,
    private val mapper: BaseResponseMapper<ScreenshotsDTO, Screenshots>
) : AppRemoteData {

    override suspend fun getGameScreenshots(gameId: String): Result<Screenshots> =
        suspendTryCatch {
            val screenshotsDTO = service.getGameScreenshots(gameId, BuildConfig.GAMES_API_KEY)
            mapper.mapResponse(screenshotsDTO)
        }
}