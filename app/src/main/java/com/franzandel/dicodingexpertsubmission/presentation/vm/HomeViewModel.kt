package com.franzandel.dicodingexpertsubmission.presentation.vm

import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import androidx.paging.map
import com.franzandel.core.mapper.BaseMapper
import com.franzandel.core.presentation.BaseViewModel
import com.franzandel.dicodingexpertsubmission.domain.model.remote.response.GamesResult
import com.franzandel.dicodingexpertsubmission.domain.usecase.HomeUseCase
import com.franzandel.dicodingexpertsubmission.presentation.model.GamesResultUI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/**
 * Created by Franz Andel on 06/05/21.
 * Android Engineer
 */

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val useCase: HomeUseCase,
    private val mapper: BaseMapper<GamesResult, GamesResultUI>
) : BaseViewModel() {

    suspend fun getAllGames() =
        useCase.getAllGames().map {
            it.map { gamesResult ->
                mapper.map(gamesResult)
            }
        }.cachedIn(viewModelScope)
}