package com.franzandel.dicodingexpertsubmission.di

import com.franzandel.dicodingexpertsubmission.core.mapper.BaseMapper
import com.franzandel.dicodingexpertsubmission.core.mapper.BaseResponseMapper
import com.franzandel.dicodingexpertsubmission.data.local.AppLocalData
import com.franzandel.dicodingexpertsubmission.data.local.AppLocalDataImpl
import com.franzandel.dicodingexpertsubmission.data.local.mapper.ResultDTOMapper
import com.franzandel.dicodingexpertsubmission.data.local.mapper.ResultMapper
import com.franzandel.dicodingexpertsubmission.data.local.mapper.ScreenshotsDTOMapper
import com.franzandel.dicodingexpertsubmission.data.local.mapper.ScreenshotsMapper
import com.franzandel.dicodingexpertsubmission.data.local.model.ResultDTO
import com.franzandel.dicodingexpertsubmission.data.local.model.ScreenshotsDTO
import com.franzandel.dicodingexpertsubmission.data.remote.AppRemoteData
import com.franzandel.dicodingexpertsubmission.data.remote.AppRemoteDataImpl
import com.franzandel.dicodingexpertsubmission.data.remote.mapper.ResultResponseMapper
import com.franzandel.dicodingexpertsubmission.data.remote.mapper.ScreenshotsResponseMapper
import com.franzandel.dicodingexpertsubmission.data.remote.model.ResultResponseDTO
import com.franzandel.dicodingexpertsubmission.data.remote.model.ScreenshotsResponseDTO
import com.franzandel.dicodingexpertsubmission.data.repository.AppRepositoryImpl
import com.franzandel.dicodingexpertsubmission.domain.model.local.Result
import com.franzandel.dicodingexpertsubmission.domain.model.local.Screenshots
import com.franzandel.dicodingexpertsubmission.domain.model.remote.ResultResponse
import com.franzandel.dicodingexpertsubmission.domain.model.remote.ScreenshotsResponse
import com.franzandel.dicodingexpertsubmission.domain.repository.AppRepository
import com.franzandel.dicodingexpertsubmission.domain.repository.mapper.ResultResponseResultMapper
import com.franzandel.dicodingexpertsubmission.domain.repository.mapper.ScreenshotsResponseScreenshotsMapper
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
    abstract fun bindResultResponseResultMapper(
        resultResponseResultMapper: ResultResponseResultMapper
    ): BaseMapper<ResultResponse, Result>

    @Binds
    abstract fun bindScreenshotsResponseScreenshotsMapper(
        screenshotsMapper: ScreenshotsResponseScreenshotsMapper
    ): BaseMapper<ScreenshotsResponse, Screenshots>

    @Binds
    abstract fun bindAppRepository(
        repositoryImpl: AppRepositoryImpl
    ): AppRepository

    @Binds
    abstract fun bindResultDTOMapper(
        resultDTOMapper: ResultDTOMapper
    ): BaseMapper<Result, ResultDTO>

    @Binds
    abstract fun bindScreenshotsDTOMapper(
        screenshotsDTOMapper: ScreenshotsDTOMapper
    ): BaseMapper<Screenshots, ScreenshotsDTO>

    @Binds
    abstract fun bindResultMapper(
        resultMapper: ResultMapper
    ): BaseMapper<ResultDTO, Result>

    @Binds
    abstract fun bindScreenshotsMapper(
        screenshotsMapper: ScreenshotsMapper
    ): BaseMapper<ScreenshotsDTO, Screenshots>

    @Binds
    abstract fun bindAppLocalData(
        localData: AppLocalDataImpl
    ): AppLocalData

    @Binds
    abstract fun bindResultResponseMapper(
        resultMapper: ResultResponseMapper
    ): BaseMapper<ResultResponseDTO, ResultResponse>

    @Binds
    abstract fun bindScreenshotsResponseMapper(
        responseMapper: ScreenshotsResponseMapper
    ): BaseResponseMapper<ScreenshotsResponseDTO, ScreenshotsResponse>

    @Binds
    abstract fun bindAppRemoteData(
        remoteData: AppRemoteDataImpl
    ): AppRemoteData
}