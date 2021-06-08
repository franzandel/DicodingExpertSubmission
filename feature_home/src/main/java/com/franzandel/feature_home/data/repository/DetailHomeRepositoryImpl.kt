package com.franzandel.feature_home.data.repository

import com.franzandel.core.wrapper.Result
import com.franzandel.feature_home.data.local.DetailHomeLocalData
import com.franzandel.feature_home.domain.model.local.request.GamesResultRequest
import com.franzandel.feature_home.domain.repository.DetailHomeRepository
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class DetailHomeRepositoryImpl @Inject constructor(
    private val localData: DetailHomeLocalData
) : DetailHomeRepository {

    override suspend fun insertGamesResults(gamesResultRequest: GamesResultRequest): Result<Unit> =
        localData.insertGamesResults(gamesResultRequest)

    override suspend fun deleteGamesResults(gamesResultRequest: GamesResultRequest): Result<Unit> =
        localData.deleteGamesResults(gamesResultRequest)

    override suspend fun getGamesResult(name: String): Result<GamesResultRequest> =
        localData.getGamesResults(name)
}