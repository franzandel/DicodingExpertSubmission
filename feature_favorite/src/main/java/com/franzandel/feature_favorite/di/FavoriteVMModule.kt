package com.franzandel.feature_favorite.di

import androidx.lifecycle.ViewModel
import com.franzandel.core.coroutine.CoroutineThread
import com.franzandel.core.mapper.BaseMapper
import com.franzandel.core.presentation.vm.ViewModelKey
import com.franzandel.feature_favorite.data.local.dao.FavoriteDao
import com.franzandel.feature_favorite.data.local.db.FavoriteDatabase
import com.franzandel.feature_favorite.domain.model.local.request.GamesResultRequest
import com.franzandel.feature_favorite.domain.usecase.FavoriteUseCase
import com.franzandel.feature_favorite.presentation.model.GamesResultUI
import com.franzandel.feature_favorite.presentation.vm.FavoriteViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.multibindings.IntoMap

/**
 * Created by Franz Andel on 12/05/21.
 * Android Engineer
 */

@Module
@InstallIn(ViewModelComponent::class)
object FavoriteVMModule {

    @Provides
    @IntoMap
    @ViewModelKey(FavoriteViewModel::class)
    fun provideFavoriteViewModel(
        useCase: FavoriteUseCase,
        thread: CoroutineThread,
        mapper: BaseMapper<GamesResultRequest, GamesResultUI>
    ): ViewModel =
        FavoriteViewModel(useCase, thread, mapper)

    @Provides
    @ViewModelScoped
    fun provideFavoriteDao(database: FavoriteDatabase): FavoriteDao =
        database.favoriteDao()
}