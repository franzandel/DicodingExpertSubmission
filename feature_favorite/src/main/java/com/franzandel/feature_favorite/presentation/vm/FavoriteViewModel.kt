package com.franzandel.feature_favorite.presentation.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.map
import com.franzandel.core.coroutine.CoroutineThread
import com.franzandel.core.mapper.BaseMapper
import com.franzandel.core.presentation.vm.BaseViewModel
import com.franzandel.core.wrapper.Result
import com.franzandel.core.wrapper.result
import com.franzandel.feature_favorite.domain.model.local.request.GamesResultRequest
import com.franzandel.feature_favorite.domain.usecase.FavoriteUseCase
import com.franzandel.feature_favorite.presentation.model.GamesResultUI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Franz Andel on 12/05/21.
 * Android Engineer
 */

@HiltViewModel
class FavoriteViewModel @Inject constructor(
    private val useCase: FavoriteUseCase,
    private val thread: CoroutineThread,
    private val mapper: BaseMapper<GamesResultRequest, GamesResultUI>
) : BaseViewModel() {

    suspend fun getFavoriteGames(): Flow<PagingData<GamesResultUI>> =
        useCase.getGamesResults().map {
            it.map { gamesResultRequest ->
                mapper.map(gamesResultRequest)
            }
        }

    private val _insertGamesResults = MutableLiveData<Unit>()
    val insertGamesResults: LiveData<Unit> = _insertGamesResults

    fun insertGamesResults(gamesResultUI: GamesResultUI) {
        viewModelScope.launch(thread.background()) {
            when (val result = useCase.insertGamesResults(gamesResultUI)) {
                is Result.Success -> _insertGamesResults.postValue(result.result)
                is Result.Error -> _errorResult.postValue(result.error.localizedMessage)
            }
        }
    }

    private val _deleteGamesResults = MutableLiveData<GamesResultUI>()
    val deleteGamesResults: LiveData<GamesResultUI> = _deleteGamesResults

    fun deleteGamesResults(gamesResultUI: GamesResultUI) {
        viewModelScope.launch(thread.background()) {
            when (val result = useCase.deleteGamesResults(gamesResultUI)) {
                is Result.Success -> _deleteGamesResults.postValue(gamesResultUI)
                is Result.Error -> _errorResult.postValue(result.error.localizedMessage)
            }
        }
    }
}