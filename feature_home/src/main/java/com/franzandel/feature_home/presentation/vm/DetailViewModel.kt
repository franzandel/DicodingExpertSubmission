package com.franzandel.feature_home.presentation.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.franzandel.core.coroutine.CoroutineThread
import com.franzandel.core.presentation.vm.BaseViewModel
import com.franzandel.core.wrapper.Result
import com.franzandel.core.wrapper.result
import com.franzandel.feature_home.domain.usecase.DetailUseCase
import com.franzandel.feature_home.presentation.model.GamesResultUI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Franz Andel on 10/05/21.
 * Android Engineer
 */

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val useCase: DetailUseCase,
    private val thread: CoroutineThread
) : BaseViewModel() {

    private val _insertGamesResults = MutableLiveData<Unit>()
    val insertGamesResults: LiveData<Unit> = _insertGamesResults

    fun insertGamesResults(gamesResultUI: GamesResultUI) {
        viewModelScope.launch(thread.background()) {
            when (val result = useCase.insertGamesResults(gamesResultUI)) {
                is Result.Success -> _insertGamesResults.postValue(result.result)
                is Result.Error -> mErrorResult.postValue(result.error.localizedMessage)
            }
        }
    }

    private val _deleteGamesResults = MutableLiveData<Unit>()
    val deleteGamesResults: LiveData<Unit> = _deleteGamesResults

    fun deleteGamesResults(gamesResultUI: GamesResultUI) {
        viewModelScope.launch(thread.background()) {
            when (val result = useCase.deleteGamesResults(gamesResultUI)) {
                is Result.Success -> _deleteGamesResults.postValue(result.result)
                is Result.Error -> mErrorResult.postValue(result.error.localizedMessage)
            }
        }
    }

    private val _isFavoriteGamesResults = MutableLiveData<Boolean>()
    val isFavoriteGamesResults: LiveData<Boolean> = _isFavoriteGamesResults

    fun getGamesResults(name: String) {
        viewModelScope.launch(thread.background()) {
            when (val result = useCase.getGamesResult(name)) {
                is Result.Success -> _isFavoriteGamesResults.postValue(true)
                is Result.Error -> mErrorResult.postValue(result.error.localizedMessage)
            }
        }
    }
}