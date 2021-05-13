package com.franzandel.dicodingexpertsubmission.di

import com.franzandel.dicodingexpertsubmission.core.mapper.BaseMapper
import com.franzandel.dicodingexpertsubmission.data.local.FavoriteLocalData
import com.franzandel.dicodingexpertsubmission.data.local.FavoriteLocalDataImpl
import com.franzandel.dicodingexpertsubmission.data.repository.FavoriteRepositoryImpl
import com.franzandel.dicodingexpertsubmission.domain.model.local.request.GamesResultRequest
import com.franzandel.dicodingexpertsubmission.domain.repository.FavoriteRepository
import com.franzandel.dicodingexpertsubmission.domain.repository.mapper.response.GamesResultUIMapper
import com.franzandel.dicodingexpertsubmission.domain.usecase.FavoriteUseCase
import com.franzandel.dicodingexpertsubmission.domain.usecase.FavoriteUseCaseImpl
import com.franzandel.dicodingexpertsubmission.presentation.model.GamesResultUI
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

/**
 * Created by Franz Andel on 12/05/21.
 * Android Engineer
 */

@Module
@InstallIn(ViewModelComponent::class)
abstract class FavoriteAbstractVMModule {

    @Binds
    abstract fun bindGamesResultUIMapper(
        gamesResultUIMapper: GamesResultUIMapper
    ): BaseMapper<GamesResultRequest, GamesResultUI>

    @Binds
    abstract fun bindFavoriteUseCase(
        favoriteUseCaseImpl: FavoriteUseCaseImpl
    ): FavoriteUseCase

    @Binds
    abstract fun bindFavoriteRepository(
        favoriteRepositoryImpl: FavoriteRepositoryImpl
    ): FavoriteRepository

    @Binds
    abstract fun bindFavoriteLocalData(
        favoriteLocalDataImpl: FavoriteLocalDataImpl
    ): FavoriteLocalData

    // TODO: 12/05/21 DONT DELETE THIS (CAUSING ERROR DAGGER DUPLICATE BINDING)
//    @Binds
//    abstract fun bindGamesResultsEntityRequestMapper(
//        gamesResultRequestEntityMapper: GamesResultRequestEntityMapper
//    ): BaseMapper<GamesResultEntity, GamesResultRequest>
}