package com.franzandel.core.presentation.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * Created by Franz Andel on 14/05/21.
 * Android Engineer
 */

abstract class BaseViewModel : ViewModel() {

    protected val mErrorResult = MutableLiveData<String>()
    val errorResult: LiveData<String> = mErrorResult

    private val mLoadingResult = MutableLiveData<Boolean>()
    val loadingResult: LiveData<Boolean> = mLoadingResult
}