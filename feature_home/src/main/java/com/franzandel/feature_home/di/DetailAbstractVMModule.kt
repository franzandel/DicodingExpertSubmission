package com.franzandel.feature_home.di

import com.franzandel.core.mapper.BaseMapper
import com.franzandel.feature_home.data.local.DetailLocalData
import com.franzandel.feature_home.data.local.DetailLocalDataImpl
import com.franzandel.feature_home.data.local.mapper.GamesResultRequestEntityMapper
import com.franzandel.feature_home.data.local.model.GamesResultEntity
import com.franzandel.feature_home.data.repository.DetailRepositoryImpl
import com.franzandel.feature_home.domain.mapper.GamesResultsEntityMapper
import com.franzandel.feature_home.domain.model.local.request.GamesResultRequest
import com.franzandel.feature_home.domain.repository.DetailRepository
import com.franzandel.feature_home.domain.usecase.DetailUseCase
import com.franzandel.feature_home.domain.usecase.DetailUseCaseImpl
import com.franzandel.feature_home.presentation.mapper.GamesResultsRequestMapper
import com.franzandel.feature_home.presentation.model.GamesResultUI
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