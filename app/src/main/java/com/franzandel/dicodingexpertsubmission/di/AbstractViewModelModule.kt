package com.franzandel.dicodingexpertsubmission.di

import com.franzandel.dicodingexpertsubmission.data.local.AppLocalData
import com.franzandel.dicodingexpertsubmission.data.local.AppLocalDataImpl
import com.franzandel.dicodingexpertsubmission.data.remote.AppRemoteData
import com.franzandel.dicodingexpertsubmission.data.remote.AppRemoteDataImpl
import com.franzandel.dicodingexpertsubmission.data.repository.AppRepositoryImpl
import com.franzandel.dicodingexpertsubmission.domain.repository.AppRepository
import com.franzandel.dicodingexpertsubmission.domain.usecase.AppUseCase
import com.franzandel.dicodingexpertsubmission.domain.usecase.AppUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

/**
 * Created by Franz Andel on 01/05/21.
 * Android Engineer
 */

@Module
@InstallIn(ViewModelComponent::class)
abstract class AbstractViewModelModule {
    @Binds
    abstract fun bindAppUseCase(
        useCaseImpl: AppUseCaseImpl
    ): AppUseCase

    @Binds
    abstract fun bindAppRepository(
        repositoryImpl: AppRepositoryImpl
    ): AppRepository

    @Binds
    abstract fun bindAppLocalData(
        localData: AppLocalDataImpl
    ): AppLocalData

    @Binds
    abstract fun bindAppRemoteData(
        remoteData: AppRemoteDataImpl
    ): AppRemoteData
}