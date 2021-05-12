package com.franzandel.dicodingexpertsubmission.data.repository

import androidx.paging.PagingData
import com.franzandel.dicodingexpertsubmission.data.local.FavoriteLocalData
import com.franzandel.dicodingexpertsubmission.domain.model.local.request.GamesResultRequest
import com.franzandel.dicodingexpertsubmission.domain.repository.FavoriteRepository
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@ViewModelScoped
class FavoriteRepositoryImpl @Inject constructor(private val localData: FavoriteLocalData) :
    FavoriteRepository {

    override suspend fun getGamesResults(): Flow<PagingData<GamesResultRequest>> =
        localData.getGamesResults()
}