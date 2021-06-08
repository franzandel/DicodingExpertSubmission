package com.franzandel.feature_favorite.di

import com.franzandel.feature_favorite.data.local.DetailFavoriteLocalData
import com.franzandel.feature_favorite.data.local.DetailFavoriteLocalDataImpl
import com.franzandel.feature_favorite.data.repository.DetailFavoriteRepositoryImpl
import com.franzandel.feature_favorite.domain.repository.DetailFavoriteRepository
import com.franzandel.feature_favorite.domain.usecase.DetailFavoriteUseCase
import com.franzandel.feature_favorite.domain.usecase.DetailFavoriteUseCaseImpl
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
abstract class DetailFavoriteAbstractVMModule {

    @Binds
    abstract fun bindDetailFavoriteUseCase(
        detailUseCaseImpl: DetailFavoriteUseCaseImpl
    ): DetailFavoriteUseCase

    @Binds
    abstract fun bindDetailFavoriteRepository(
        detailRepositoryImpl: DetailFavoriteRepositoryImpl
    ): DetailFavoriteRepository

    @Binds
    abstract fun bindDetailFavoriteLocalData(
        localData: DetailFavoriteLocalDataImpl
    ): DetailFavoriteLocalData
}