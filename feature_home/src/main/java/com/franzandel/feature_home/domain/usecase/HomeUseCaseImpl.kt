package com.franzandel.feature_home.domain.usecase

import androidx.paging.PagingData
import com.franzandel.feature_home.domain.model.remote.response.GamesResult
import com.franzandel.feature_home.domain.repository.HomeRepository
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@ViewModelScoped
class HomeUseCaseImpl @Inject constructor(
    private val repository: HomeRepository
) : HomeUseCase {

    override suspend fun getAllGames(): Flow<PagingData<GamesResult>> =
        repository.getAllGames()
}