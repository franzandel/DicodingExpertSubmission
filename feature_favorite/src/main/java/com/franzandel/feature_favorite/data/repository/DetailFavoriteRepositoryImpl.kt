package com.franzandel.feature_favorite.data.repository

import com.franzandel.core.wrapper.Result
import com.franzandel.feature_favorite.data.local.DetailFavoriteLocalData
import com.franzandel.feature_favorite.domain.model.local.request.GamesResultRequest
import com.franzandel.feature_favorite.domain.repository.DetailFavoriteRepository
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class DetailFavoriteRepositoryImpl @Inject constructor(
    private val localData: DetailFavoriteLocalData
) : DetailFavoriteRepository {

    override suspend fun insertGamesResults(gamesResultRequest: GamesResultRequest): Result<Unit> =
        localData.insertGamesResults(gamesResultRequest)

    override suspend fun deleteGamesResults(gamesResultRequest: GamesResultRequest): Result<Unit> =
        localData.deleteGamesResults(gamesResultRequest)

    override suspend fun getGamesResult(name: String): Result<GamesResultRequest> =
        localData.getGamesResults(name)
}