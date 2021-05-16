package com.franzandel.dicodingexpertsubmission.data.repository

import androidx.paging.PagingData
import com.franzandel.core.wrapper.Result
import com.franzandel.dicodingexpertsubmission.data.local.FavoriteLocalData
import com.franzandel.dicodingexpertsubmission.domain.model.local.request.GamesResultRequest
import com.franzandel.dicodingexpertsubmission.domain.repository.FavoriteRepository
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