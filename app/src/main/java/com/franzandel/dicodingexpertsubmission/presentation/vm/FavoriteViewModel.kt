package com.franzandel.dicodingexpertsubmission.presentation.vm

import androidx.lifecycle.LiveData
import androidx.paging.PagingData
import com.franzandel.dicodingexpertsubmission.core.presentation.BaseViewModel
import com.franzandel.dicodingexpertsubmission.domain.model.local.request.GamesResultRequest
import com.franzandel.dicodingexpertsubmission.domain.usecase.FavoriteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Created by Franz Andel on 12/05/21.
 * Android Engineer
 */

@HiltViewModel
class FavoriteViewModel @Inject constructor(
    private val useCase: FavoriteUseCase
) : BaseViewModel() {

    suspend fun getFavoriteGames(): LiveData<PagingData<GamesResultRequest>> =
        useCase.getGamesResults()
}