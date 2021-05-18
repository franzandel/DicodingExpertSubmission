package com.franzandel.feature_detail.data.repository

import com.franzandel.core.wrapper.Result
import com.franzandel.feature_detail.data.local.DetailLocalData
import com.franzandel.feature_detail.domain.model.local.request.GamesResultRequest
import com.franzandel.feature_detail.domain.repository.DetailRepository
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class DetailRepositoryImpl @Inject constructor(
    private val localData: DetailLocalData
) : DetailRepository {

    override suspend fun insertGamesResults(gamesResultRequest: GamesResultRequest): Result<Unit> =
        localData.insertGamesResults(gamesResultRequest)

    override suspend fun deleteGamesResults(gamesResultRequest: GamesResultRequest): Result<Unit> =
        localData.deleteGamesResults(gamesResultRequest)

    override suspend fun getGamesResults(name: String): Result<GamesResultRequest> =
        localData.getGamesResults(name)
}