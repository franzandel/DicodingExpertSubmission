package com.franzandel.dicodingexpertsubmission.presentation.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.franzandel.core.coroutine.CoroutineThread
import com.franzandel.core.presentation.BaseViewModel
import com.franzandel.core.wrapper.Result
import com.franzandel.core.wrapper.result
import com.franzandel.dicodingexpertsubmission.domain.model.local.Screenshots
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
) : BaseViewModel() {

    private val _gameScreenshots = MutableLiveData<Screenshots>()
    val gameScreenshots: LiveData<Screenshots> = _gameScreenshots

    private val _gameScreenshotsError = MutableLiveData<String>()
    val gameScreenshotsError: LiveData<String> = _gameScreenshotsError

    fun getGameScreenshots(gameId: String) {
        _loadingResult.value = true
        viewModelScope.launch(thread.background()) {
            when (val result = useCase.getGameScreenshots(gameId)) {
                is Result.Success -> _gameScreenshots.postValue(result.result)
                is Result.Error -> _gameScreenshotsError.postValue(result.error.localizedMessage)
            }
            _loadingResult.postValue(false)
        }
    }
}