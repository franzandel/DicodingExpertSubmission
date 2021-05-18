package com.franzandel.feature_favorite.di

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.room.Room
import com.franzandel.core.coroutine.CoroutineThread
import com.franzandel.core.mapper.BaseMapper
import com.franzandel.dicodingexpertsubmission.presentation.vm.ViewModelKey
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

    private const val FAVORITE_DB_NAME = "Favorite.db"

    @Provides
    @IntoMap
    @ViewModelKey(FavoriteViewModel::class)
    fun provideFavoriteViewModel(
        usecase: FavoriteUseCase,
        thread: CoroutineThread,
        mapper: BaseMapper<GamesResultRequest, GamesResultUI>
    ): ViewModel =
        FavoriteViewModel(usecase, thread, mapper)

    @Provides
    @ViewModelScoped
    fun provideFavoriteDatabase(context: Context): FavoriteDatabase =
        Room.databaseBuilder(
            context,
            FavoriteDatabase::class.java,
            FAVORITE_DB_NAME
        ).fallbackToDestructiveMigration()
            .build()

    @Provides
    @ViewModelScoped
    fun provideFavoriteDao(database: FavoriteDatabase): FavoriteDao =
        database.favoriteDao()
}