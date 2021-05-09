package com.franzandel.dicodingexpertsubmission.domain.usecase

import com.franzandel.dicodingexpertsubmission.core.mapper.BaseMapper
import com.franzandel.dicodingexpertsubmission.core.wrapper.Result
import com.franzandel.dicodingexpertsubmission.core.wrapper.suspendTryCatch
import com.franzandel.dicodingexpertsubmission.domain.model.remote.response.GamesResult
import com.franzandel.dicodingexpertsubmission.domain.repository.HomeRepository
import com.franzandel.dicodingexpertsubmission.presentation.model.GamesResultUI
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class HomeUseCaseImpl @Inject constructor(
    private val repository: HomeRepository,
    private val mapper: BaseMapper<List<GamesResult>, List<GamesResultUI>>
) : HomeUseCase {

    companion object {
        private const val GAMES_RESULT_MAPPER_ERROR = "games_result_mapper_error"
    }

    override suspend fun getAllGames(): Result<List<GamesResultUI>> =
        suspendTryCatch {
            when (val gamesResult = repository.getAllGames()) {
                is Result.Success -> Result.Success(mapper.map(gamesResult.data!!.results))
                is Result.Error -> throw Exception(GAMES_RESULT_MAPPER_ERROR)
            }
        }
}