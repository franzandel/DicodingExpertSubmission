package com.franzandel.dicodingexpertsubmission.di

import com.franzandel.dicodingexpertsubmission.core.mapper.BaseMapper
import com.franzandel.dicodingexpertsubmission.core.mapper.BaseResponseMapper
import com.franzandel.dicodingexpertsubmission.data.local.AppLocalData
import com.franzandel.dicodingexpertsubmission.data.local.AppLocalDataImpl
import com.franzandel.dicodingexpertsubmission.data.remote.AppRemoteData
import com.franzandel.dicodingexpertsubmission.data.remote.AppRemoteDataImpl
import com.franzandel.dicodingexpertsubmission.data.remote.mapper.ResponseMapper
import com.franzandel.dicodingexpertsubmission.data.remote.mapper.ResultMapper
import com.franzandel.dicodingexpertsubmission.data.remote.model.ResultDTO
import com.franzandel.dicodingexpertsubmission.data.remote.model.ScreenshotsDTO
import com.franzandel.dicodingexpertsubmission.data.repository.AppRepositoryImpl
import com.franzandel.dicodingexpertsubmission.domain.model.Result
import com.franzandel.dicodingexpertsubmission.domain.model.Screenshots
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
    abstract fun bindResultMapper(
        resultMapper: ResultMapper
    ): BaseMapper<ResultDTO, Result>

    @Binds
    abstract fun bindResponseMapper(
        responseMapper: ResponseMapper
    ): BaseResponseMapper<ScreenshotsDTO, Screenshots>

    @Binds
    abstract fun bindAppRemoteData(
        remoteData: AppRemoteDataImpl
    ): AppRemoteData
}