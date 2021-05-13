package com.franzandel.dicodingexpertsubmission.presentation.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import com.franzandel.dicodingexpertsubmission.core.coroutine.CoroutineThread
import com.franzandel.dicodingexpertsubmission.core.presentation.BaseViewModel
import com.franzandel.dicodingexpertsubmission.core.wrapper.Result
import com.franzandel.dicodingexpertsubmission.core.wrapper.result
import com.franzandel.dicodingexpertsubmission.domain.model.local.request.GamesResultRequest
import com.franzandel.dicodingexpertsubmission.domain.usecase.FavoriteUseCase
import com.franzandel.dicodingexpertsubmission.presentation.model.GamesResultUI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Franz Andel on 12/05/21.
 * Android Engineer
 */

@HiltViewModel
class FavoriteViewModel @Inject constructor(
    private val useCase: FavoriteUseCase,
    private val thread: CoroutineThread
) : BaseViewModel() {

    suspend fun getFavoriteGames(): LiveData<PagingData<GamesResultRequest>> =
        useCase.getGamesResults()

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