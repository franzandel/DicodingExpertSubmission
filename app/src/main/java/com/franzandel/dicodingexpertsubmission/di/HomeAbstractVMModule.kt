package com.franzandel.dicodingexpertsubmission.di

import com.franzandel.dicodingexpertsubmission.core.mapper.BaseMapper
import com.franzandel.dicodingexpertsubmission.core.mapper.BaseResponseMapper
import com.franzandel.dicodingexpertsubmission.data.remote.HomeRemoteData
import com.franzandel.dicodingexpertsubmission.data.remote.HomeRemoteDataImpl
import com.franzandel.dicodingexpertsubmission.data.remote.mapper.response.*
import com.franzandel.dicodingexpertsubmission.data.remote.model.response.*
import com.franzandel.dicodingexpertsubmission.data.repository.HomeRepositoryImpl
import com.franzandel.dicodingexpertsubmission.domain.model.remote.response.*
import com.franzandel.dicodingexpertsubmission.domain.repository.HomeRepository
import com.franzandel.dicodingexpertsubmission.domain.usecase.HomeUseCase
import com.franzandel.dicodingexpertsubmission.domain.usecase.HomeUseCaseImpl
import com.franzandel.dicodingexpertsubmission.presentation.mapper.GamesResultUIMapper
import com.franzandel.dicodingexpertsubmission.presentation.model.GamesResultUI
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

/**
 * Created by Franz Andel on 07/05/21.
 * Android Engineer
 */

@Module
@InstallIn(ViewModelComponent::class)
abstract class HomeAbstractVMModule {

    @Binds
    abstract fun bindGamesResultUIMapper(
        gamesResultUIMapper: GamesResultUIMapper
    ): BaseMapper<GamesResult, GamesResultUI>

    @Binds
    abstract fun bindHomeUseCase(
        homeUseCaseImpl: HomeUseCaseImpl
    ): HomeUseCase

    @Binds
    abstract fun bindHomeRepository(
        homeRepositoryImpl: HomeRepositoryImpl
    ): HomeRepository

    @Binds
    abstract fun bindHomeRemoteData(
        homeRemoteDataImpl: HomeRemoteDataImpl
    ): HomeRemoteData

    @Binds
    abstract fun bindStoreMapper(
        storeMapper: StoreMapper
    ): BaseMapper<StoreDTO, Store>

    @Binds
    abstract fun bindResultPlatformChildMapper(
        resultPlatformChildMapper: ResultPlatformChildMapper
    ): BaseMapper<ResultPlatformChildDTO, ResultPlatformChild>

    @Binds
    abstract fun bindParentPlatformsChildMapper(
        parentPlatformsChildMapper: ParentPlatformsChildMapper
    ): BaseMapper<ParentPlatformChildDTO, ParentPlatformChild>

    @Binds
    abstract fun bindEsrbRatingMapper(
        esrbRatingMapper: EsrbRatingMapper
    ): BaseMapper<EsrbRatingDTO?, EsrbRating?>

    @Binds
    abstract fun bindAddedByStatusMapper(
        addedByStatusMapper: AddedByStatusMapper
    ): BaseMapper<AddedByStatusDTO, AddedByStatus>

    @Binds
    abstract fun bindFiltersMapper(
        filtersMapper: FiltersMapper
    ): BaseMapper<FiltersDTO, Filters>

    @Binds
    abstract fun bindGamesMapper(
        gamesMapper: GamesMapper
    ): BaseResponseMapper<GamesDTO, Games>

    @Binds
    abstract fun bindGamesResultMapper(
        gamesResultMapper: GamesResultMapper
    ): BaseMapper<GamesResultDTO, GamesResult>
}