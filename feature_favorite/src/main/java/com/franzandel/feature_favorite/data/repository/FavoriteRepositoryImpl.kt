package com.franzandel.feature_favorite.data.repository

import androidx.paging.PagingData
import com.franzandel.core.wrapper.Result
import com.franzandel.feature_favorite.data.local.FavoriteLocalData
import com.franzandel.feature_favorite.domain.model.local.request.GamesResultRequest
import com.franzandel.feature_favorite.domain.repository.FavoriteRepository
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@ViewModelScoped
class FavoriteRepositoryImpl @Inject constructor(private val localData: FavoriteLocalData) :
    FavoriteRepository {

    override suspend fun insertGamesResults(gamesResultRequest: GamesResultRequest): Result<Unit> =
        localData.insertGamesResults(gamesResultRequest)

    override suspend fun deleteGamesResults(gamesResultRequest: GamesResultRequest): Result<Unit> =
        localData.deleteGamesResults(gamesResultRequest)

    override suspend fun getGamesResults(): Flow<PagingData<GamesResultRequest>> =
        localData.getGamesResults()
}