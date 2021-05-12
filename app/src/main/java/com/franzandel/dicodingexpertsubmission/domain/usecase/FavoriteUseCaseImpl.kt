package com.franzandel.dicodingexpertsubmission.domain.usecase

import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import androidx.paging.PagingData
import com.franzandel.dicodingexpertsubmission.domain.model.local.request.GamesResultRequest
import com.franzandel.dicodingexpertsubmission.domain.repository.FavoriteRepository
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class FavoriteUseCaseImpl @Inject constructor(private val repository: FavoriteRepository) :
    FavoriteUseCase {

    override suspend fun getGamesResults(): LiveData<PagingData<GamesResultRequest>> =
        repository.getGamesResults().asLiveData()
}