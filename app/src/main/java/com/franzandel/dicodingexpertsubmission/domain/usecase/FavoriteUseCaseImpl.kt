package com.franzandel.dicodingexpertsubmission.domain.usecase

import androidx.paging.PagingData
import com.franzandel.dicodingexpertsubmission.core.mapper.BaseMapper
import com.franzandel.dicodingexpertsubmission.core.wrapper.Result
import com.franzandel.dicodingexpertsubmission.domain.model.local.request.GamesResultRequest
import com.franzandel.dicodingexpertsubmission.domain.repository.FavoriteRepository
import com.franzandel.dicodingexpertsubmission.presentation.model.GamesResultUI
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@ViewModelScoped
class FavoriteUseCaseImpl @Inject constructor(
    private val repository: FavoriteRepository,
    private val requestMapper: BaseMapper<GamesResultUI, GamesResultRequest>
) : FavoriteUseCase {

    override suspend fun insertGamesResults(gamesResultUI: GamesResultUI): Result<Unit> {
        val gamesResultRequest = requestMapper.map(gamesResultUI)
        return repository.insertGamesResults(gamesResultRequest)
    }

    override suspend fun deleteGamesResults(gamesResultUI: GamesResultUI): Result<Unit> {
        val gamesResultRequest = requestMapper.map(gamesResultUI)
        return repository.deleteGamesResults(gamesResultRequest)
    }

    override suspend fun getGamesResults(): Flow<PagingData<GamesResultRequest>> =
        repository.getGamesResults()
}