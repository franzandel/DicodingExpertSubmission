package com.franzandel.dicodingexpertsubmission.presentation.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.franzandel.dicodingexpertsubmission.core.coroutine.CoroutineThread
import com.franzandel.dicodingexpertsubmission.core.presentation.BaseViewModel
import com.franzandel.dicodingexpertsubmission.core.wrapper.Result
import com.franzandel.dicodingexpertsubmission.core.wrapper.result
import com.franzandel.dicodingexpertsubmission.domain.model.remote.response.Games
import com.franzandel.dicodingexpertsubmission.domain.usecase.HomeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Franz Andel on 06/05/21.
 * Android Engineer
 */

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val useCase: HomeUseCase,
    private val thread: CoroutineThread
) : BaseViewModel() {

    private val _games = MutableLiveData<Games>()
    val games: LiveData<Games> = _games

    private val _gamesError = MutableLiveData<String>()
    val gameError: LiveData<String> = _gamesError

    fun getAllGames() {
        _loadingResult.value = true
        viewModelScope.launch(thread.background()) {
            when (val result = useCase.getAllGames()) {
                is Result.Success -> _games.postValue(result.result)
                is Result.Error -> _gamesError.postValue(result.error.localizedMessage)
            }
            _loadingResult.postValue(false)
        }
    }
}