package com.franzandel.feature_favorite.domain.usecase

import com.franzandel.core.mapper.BaseMapper
import com.franzandel.core.wrapper.Result
import com.franzandel.feature_favorite.domain.model.local.request.GamesResultRequest
import com.franzandel.feature_favorite.domain.repository.DetailFavoriteRepository
import com.franzandel.feature_favorite.presentation.model.GamesResultUI
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class DetailFavoriteUseCaseImpl @Inject constructor(
    private val repository: DetailFavoriteRepository,
    private val requestMapper: BaseMapper<GamesResultUI, GamesResultRequest>
) : DetailFavoriteUseCase {

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