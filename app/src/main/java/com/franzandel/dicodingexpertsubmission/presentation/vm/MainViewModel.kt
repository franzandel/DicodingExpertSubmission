package com.franzandel.dicodingexpertsubmission.presentation.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.franzandel.dicodingexpertsubmission.core.coroutine.CoroutineThread
import com.franzandel.dicodingexpertsubmission.core.wrapper.Result
import com.franzandel.dicodingexpertsubmission.core.wrapper.response
import com.franzandel.dicodingexpertsubmission.domain.model.ScreenshotsResponse
import com.franzandel.dicodingexpertsubmission.domain.usecase.AppUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Franz Andel on 01/05/21.
 * Android Engineer
 */

@HiltViewModel
class MainViewModel @Inject constructor(
    private val useCase: AppUseCase,
    private val thread: CoroutineThread
) : ViewModel() {

    private val _gameScreenshots = MutableLiveData<ScreenshotsResponse>()
    val gameScreenshots: LiveData<ScreenshotsResponse> = _gameScreenshots

    private val _gameScreenshotsError = MutableLiveData<String>()
    val gameScreenshotsError: LiveData<String> = _gameScreenshotsError

    fun getGameScreenshots(gameId: String) {
        viewModelScope.launch(thread.background()) {
            when (val result = useCase.getGameScreenshots(gameId)) {
                is Result.Success -> _gameScreenshots.postValue(result.response)
                is Result.Error -> _gameScreenshotsError.postValue(result.error.localizedMessage)
            }
        }
    }
}