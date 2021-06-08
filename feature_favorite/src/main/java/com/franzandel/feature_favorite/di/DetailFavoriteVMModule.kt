package com.franzandel.feature_favorite.di

import androidx.lifecycle.ViewModel
import com.franzandel.core.coroutine.CoroutineThread
import com.franzandel.core.presentation.vm.ViewModelKey
import com.franzandel.feature_favorite.data.local.dao.DetailFavoriteDao
import com.franzandel.feature_favorite.data.local.db.FavoriteDatabase
import com.franzandel.feature_favorite.domain.usecase.DetailFavoriteUseCase
import com.franzandel.feature_favorite.presentation.vm.DetailFavoriteViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.multibindings.IntoMap

/**
 * Created by Franz Andel on 11/05/21.
 * Android Engineer
 */

@Module
@InstallIn(ViewModelComponent::class)
object DetailFavoriteVMModule {

    @Provides
    @IntoMap
    @ViewModelKey(DetailFavoriteViewModel::class)
    fun provideDetailFavoriteViewModel(
        useCase: DetailFavoriteUseCase,
        thread: CoroutineThread
    ): ViewModel =
        DetailFavoriteViewModel(useCase, thread)

    @Provides
    @ViewModelScoped
    fun provideDetailFavoriteDao(database: FavoriteDatabase): DetailFavoriteDao =
        database.detailFavoriteDao()
}