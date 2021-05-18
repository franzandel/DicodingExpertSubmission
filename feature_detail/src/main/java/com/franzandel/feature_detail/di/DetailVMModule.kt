package com.franzandel.feature_detail.di

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.room.Room
import com.franzandel.core.coroutine.CoroutineThread
import com.franzandel.dicodingexpertsubmission.presentation.vm.ViewModelKey
import com.franzandel.feature_detail.data.local.dao.DetailDao
import com.franzandel.feature_detail.data.local.db.DetailDatabase
import com.franzandel.feature_detail.domain.usecase.DetailUseCase
import com.franzandel.feature_detail.presentation.vm.DetailViewModel
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
object DetailVMModule {

    private const val DETAIL_DB_NAME = "Detail.db"

    @Provides
    @IntoMap
    @ViewModelKey(DetailViewModel::class)
    fun provideDetailViewModel(
        usecase: DetailUseCase,
        thread: CoroutineThread
    ): ViewModel =
        DetailViewModel(usecase, thread)

    @Provides
    @ViewModelScoped
    fun provideDetailDatabase(context: Context): DetailDatabase =
        Room.databaseBuilder(
            context,
            DetailDatabase::class.java,
            DETAIL_DB_NAME
        ).fallbackToDestructiveMigration()
            .build()

    @Provides
    @ViewModelScoped
    fun provideDetailDao(database: DetailDatabase): DetailDao =
        database.detailDao()
}