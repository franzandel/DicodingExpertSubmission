package com.franzandel.feature_detail.domain.usecase

import com.franzandel.core.mapper.BaseMapper
import com.franzandel.core.wrapper.Result
import com.franzandel.feature_detail.domain.model.local.request.GamesResultRequest
import com.franzandel.feature_detail.domain.repository.DetailRepository
import com.franzandel.feature_detail.presentation.model.GamesResultUI
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class DetailUseCaseImpl @Inject constructor(
    private val repository: DetailRepository,
    private val requestMapper: BaseMapper<GamesResultUI, GamesResultRequest>
) : com.franzandel.feature_detail.domain.usecase.DetailUseCase {

    override suspend fun insertGamesResults(gamesResultUI: GamesResultUI): Result<Unit> {
        val gamesResultRequest = requestMapper.map(gamesResultUI)
        return repository.insertGamesResults(gamesResultRequest)
    }

    override suspend fun deleteGamesResults(gamesResultUI: GamesResultUI): Result<Unit> {
        val gamesResultRequest = requestMapper.map(gamesResultUI)
        return repository.deleteGamesResults(gamesResultRequest)
    }

    override suspend fun getGamesResults(name: String): Result<GamesResultRequest> =
        repository.getGamesResults(name)
}