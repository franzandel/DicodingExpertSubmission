package com.franzandel.core.extension

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope

/**
 * Created by Franz Andel on 03/06/21.
 * Android Engineer
 */

fun ViewModel.getViewModelScope(coroutineScope: CoroutineScope?) =
    coroutineScope ?: this.viewModelScope