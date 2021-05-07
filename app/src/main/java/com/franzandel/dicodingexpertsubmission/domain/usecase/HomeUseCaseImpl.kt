package com.franzandel.dicodingexpertsubmission.domain.usecase

import com.franzandel.dicodingexpertsubmission.core.wrapper.Result
import com.franzandel.dicodingexpertsubmission.domain.model.remote.response.Games
import com.franzandel.dicodingexpertsubmission.domain.repository.HomeRepository
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class HomeUseCaseImpl @Inject constructor(
    private val repository: HomeRepository
) : HomeUseCase {

    override suspend fun getAllGames(): Result<Games> = repository.getAllGames()
}