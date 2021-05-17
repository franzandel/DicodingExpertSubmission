package com.franzandel.feature_home.data.repository

import androidx.paging.PagingData
import com.franzandel.feature_home.data.remote.HomeRemoteData
import com.franzandel.feature_home.domain.model.remote.response.GamesResult
import com.franzandel.feature_home.domain.repository.HomeRepository
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@ViewModelScoped
class HomeRepositoryImpl @Inject constructor(
    private val remoteData: HomeRemoteData
) : HomeRepository {

    override suspend fun getAllGames(): Flow<PagingData<GamesResult>> = remoteData.getAllGames()
}