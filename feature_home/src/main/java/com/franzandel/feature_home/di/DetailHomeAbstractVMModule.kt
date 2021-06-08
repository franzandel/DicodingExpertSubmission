package com.franzandel.feature_home.di

import com.franzandel.core.mapper.BaseMapper
import com.franzandel.feature_home.data.local.DetailHomeLocalData
import com.franzandel.feature_home.data.local.DetailHomeLocalDataImpl
import com.franzandel.feature_home.data.local.mapper.GamesResultRequestEntityMapper
import com.franzandel.feature_home.data.local.model.GamesResultEntity
import com.franzandel.feature_home.data.repository.DetailHomeRepositoryImpl
import com.franzandel.feature_home.domain.mapper.GamesResultsEntityMapper
import com.franzandel.feature_home.domain.model.local.request.GamesResultRequest
import com.franzandel.feature_home.domain.repository.DetailHomeRepository
import com.franzandel.feature_home.domain.usecase.DetailHomeUseCase
import com.franzandel.feature_home.domain.usecase.DetailHomeUseCaseImpl
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
abstract class DetailHomeAbstractVMModule {

    @Binds
    abstract fun bindDetailHomeUseCase(
        detailUseCaseImpl: DetailHomeUseCaseImpl
    ): DetailHomeUseCase

    @Binds
    abstract fun bindDetailHomeRepository(
        detailRepositoryImpl: DetailHomeRepositoryImpl
    ): DetailHomeRepository

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
    abstract fun bindDetailHomeLocalData(
        localData: DetailHomeLocalDataImpl
    ): DetailHomeLocalData
}