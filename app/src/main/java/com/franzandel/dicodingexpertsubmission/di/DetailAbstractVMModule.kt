package com.franzandel.dicodingexpertsubmission.di

import com.franzandel.dicodingexpertsubmission.core.mapper.BaseMapper
import com.franzandel.dicodingexpertsubmission.data.local.DetailLocalData
import com.franzandel.dicodingexpertsubmission.data.local.DetailLocalDataImpl
import com.franzandel.dicodingexpertsubmission.data.local.mapper.GamesResultRequestEntityMapper
import com.franzandel.dicodingexpertsubmission.data.local.model.GamesResultEntity
import com.franzandel.dicodingexpertsubmission.data.repository.DetailRepositoryImpl
import com.franzandel.dicodingexpertsubmission.domain.model.local.request.GamesResultRequest
import com.franzandel.dicodingexpertsubmission.domain.repository.DetailRepository
import com.franzandel.dicodingexpertsubmission.domain.repository.mapper.request.GamesResultsEntityMapper
import com.franzandel.dicodingexpertsubmission.domain.usecase.DetailUseCase
import com.franzandel.dicodingexpertsubmission.domain.usecase.DetailUseCaseImpl
import com.franzandel.dicodingexpertsubmission.presentation.mapper.GamesResultsRequestMapper
import com.franzandel.dicodingexpertsubmission.presentation.model.GamesResultUI
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

/**
 * Created by Franz Andel on 11/05/21.
 * Android Engineer
 */

@Module
@InstallIn(ViewModelComponent::class)
abstract class DetailAbstractVMModule {

    @Binds
    abstract fun bindDetailUseCase(
        detailUseCaseImpl: DetailUseCaseImpl
    ): DetailUseCase

    @Binds
    abstract fun bindDetailRepository(
        detailRepositoryImpl: DetailRepositoryImpl
    ): DetailRepository

    @Binds
    abstract fun bindGamesResultsRequestMapper(
        gamesResultsRequestMapper: GamesResultsRequestMapper
    ): BaseMapper<GamesResultUI, GamesResultRequest>

    @Binds
    abstract fun bindGamesResultsEntityMapper(
        gamesResultsEntityMapper: GamesResultsEntityMapper
    ): BaseMapper<GamesResultRequest, GamesResultEntity>

    @Binds
    abstract fun bindGamesResultsEntityRequestMapper(
        gamesResultRequestEntityMapper: GamesResultRequestEntityMapper
    ): BaseMapper<GamesResultEntity, GamesResultRequest>

    @Binds
    abstract fun bindDetailLocalData(
        localData: DetailLocalDataImpl
    ): DetailLocalData
}