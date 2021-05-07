package com.franzandel.dicodingexpertsubmission.data.remote

import com.franzandel.dicodingexpertsubmission.BuildConfig
import com.franzandel.dicodingexpertsubmission.core.mapper.BaseResponseMapper
import com.franzandel.dicodingexpertsubmission.core.wrapper.Result
import com.franzandel.dicodingexpertsubmission.core.wrapper.suspendTryCatch
import com.franzandel.dicodingexpertsubmission.data.remote.model.response.GamesDTO
import com.franzandel.dicodingexpertsubmission.data.remote.network.HomeService
import com.franzandel.dicodingexpertsubmission.domain.model.remote.response.Games
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class HomeRemoteDataImpl @Inject constructor(
    private val service: HomeService,
    private val mapper: BaseResponseMapper<GamesDTO, Games>
) : HomeRemoteData {

    override suspend fun getAllGames(): Result<Games> =
        suspendTryCatch {
            val screenshotsDTO = service.getAllGames(BuildConfig.GAMES_API_KEY)
            mapper.mapResponse(screenshotsDTO)
        }
}