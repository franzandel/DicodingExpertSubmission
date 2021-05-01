package com.franzandel.dicodingexpertsubmission.presentation.vm

import androidx.lifecycle.ViewModel
import com.franzandel.dicodingexpertsubmission.domain.usecase.AppUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Created by Franz Andel on 01/05/21.
 * Android Engineer
 */

@HiltViewModel
class MainViewModel @Inject constructor(
    private val useCase: AppUseCase
) : ViewModel() {
}