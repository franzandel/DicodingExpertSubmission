package com.franzandel.dicodingexpertsubmission.presentation.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.franzandel.dicodingexpertsubmission.core.coroutine.CoroutineThread
import com.franzandel.dicodingexpertsubmission.core.presentation.BaseViewModel
import com.franzandel.dicodingexpertsubmission.core.wrapper.Result
import com.franzandel.dicodingexpertsubmission.core.wrapper.result
import com.franzandel.dicodingexpertsubmission.domain.usecase.DetailUseCase
import com.franzandel.dicodingexpertsubmission.presentation.model.GamesResultUI
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
                is Result.Error -> _errorResult.postValue(result.error.localizedMessage)
            }
        }
    }

    private val _deleteGamesResults = MutableLiveData<Unit>()
    val deleteGamesResults: LiveData<Unit> = _deleteGamesResults

    fun deleteGamesResults(gamesResultUI: GamesResultUI) {
        viewModelScope.launch(thread.background()) {
            when (val result = useCase.deleteGamesResults(gamesResultUI)) {
                is Result.Success -> _deleteGamesResults.postValue(result.result)
                is Result.Error -> _errorResult.postValue(result.error.localizedMessage)
            }
        }
    }

    private val _isFavoriteGamesResults = MutableLiveData<Boolean>()
    val isFavoriteGamesResults: LiveData<Boolean> = _isFavoriteGamesResults

    fun getGamesResults(name: String) {
        viewModelScope.launch(thread.background()) {
            when (val result = useCase.getGamesResults(name)) {
                is Result.Success -> _isFavoriteGamesResults.postValue(true)
                is Result.Error -> _errorResult.postValue(result.error.localizedMessage)
            }
        }
    }
}