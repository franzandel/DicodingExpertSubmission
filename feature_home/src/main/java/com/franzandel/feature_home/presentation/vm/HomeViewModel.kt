package com.franzandel.feature_home.presentation.vm

import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map
import com.franzandel.core.mapper.BaseMapper
import com.franzandel.core.presentation.vm.BaseViewModel
import com.franzandel.feature_home.domain.model.remote.response.GamesResult
import com.franzandel.feature_home.domain.usecase.HomeUseCase
import com.franzandel.feature_home.presentation.model.GamesResultUI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
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

    suspend fun getAllGames(): Flow<PagingData<GamesResultUI>> =
        useCase.getAllGames().map {
            it.map { gamesResult ->
                mapper.map(gamesResult)
            }
        }.cachedIn(viewModelScope)
}