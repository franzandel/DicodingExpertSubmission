package com.franzandel.dicodingexpertsubmission.data.repository

import com.franzandel.dicodingexpertsubmission.data.local.AppLocalData
import com.franzandel.dicodingexpertsubmission.data.remote.AppRemoteData
import com.franzandel.dicodingexpertsubmission.domain.repository.AppRepository
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class AppRepositoryImpl @Inject constructor(
    private val remoteData: AppRemoteData,
    private val localData: AppLocalData
) : AppRepository