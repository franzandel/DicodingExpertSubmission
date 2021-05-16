package com.franzandel.dicodingexpertsubmission.domain.usecase

import com.franzandel.core.wrapper.Result
import com.franzandel.dicodingexpertsubmission.domain.model.local.Screenshots
import com.franzandel.dicodingexpertsubmission.domain.repository.AppRepository
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class AppUseCaseImpl @Inject constructor(private val repository: AppRepository) :
    AppUseCase {

    override suspend fun getGameScreenshots(gameId: String): Result<Screenshots> =
        repository.getGameScreenshots(gameId)
}