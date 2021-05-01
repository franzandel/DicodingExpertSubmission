package com.franzandel.dicodingexpertsubmission.domain.usecase

import com.franzandel.dicodingexpertsubmission.domain.repository.AppRepository
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class AppUseCaseImpl @Inject constructor(private val repository: AppRepository) :
    AppUseCase