package com.franzandel.feature_favorite.di

import com.franzandel.core.mapper.BaseMapper
import com.franzandel.feature_favorite.data.local.FavoriteLocalData
import com.franzandel.feature_favorite.data.local.FavoriteLocalDataImpl
import com.franzandel.feature_favorite.data.repository.FavoriteRepositoryImpl
import com.franzandel.feature_favorite.domain.mapper.GamesResultUIMapper
import com.franzandel.feature_favorite.domain.model.local.request.GamesResultRequest
import com.franzandel.feature_favorite.domain.repository.FavoriteRepository
import com.franzandel.feature_favorite.domain.usecase.FavoriteUseCase
import com.franzandel.feature_favorite.domain.usecase.FavoriteUseCaseImpl
import com.franzandel.feature_favorite.presentation.model.GamesResultUI
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
}