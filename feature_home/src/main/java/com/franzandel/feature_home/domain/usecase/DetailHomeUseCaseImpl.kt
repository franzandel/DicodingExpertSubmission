package com.franzandel.feature_home.domain.usecase

import com.franzandel.core.mapper.BaseMapper
import com.franzandel.core.wrapper.Result
import com.franzandel.feature_home.domain.model.local.request.GamesResultRequest
import com.franzandel.feature_home.domain.repository.DetailHomeRepository
import com.franzandel.feature_home.presentation.model.GamesResultUI
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class DetailHomeUseCaseImpl @Inject constructor(
    private val repository: DetailHomeRepository,
    private val requestMapper: BaseMapper<GamesResultUI, GamesResultRequest>
) : DetailHomeUseCase {

    override suspend fun insertGamesResults(gamesResultUI: GamesResultUI): Result<Unit> {
        val gamesResultRequest = requestMapper.map(gamesResultUI)
        return repository.insertGamesResults(gamesResultRequest)
    }

    override suspend fun deleteGamesResults(gamesResultUI: GamesResultUI): Result<Unit> {
        val gamesResultRequest = requestMapper.map(gamesResultUI)
        return repository.deleteGamesResults(gamesResultRequest)
    }

    override suspend fun getGamesResult(name: String): Result<GamesResultRequest> =
        repository.getGamesResult(name)
}