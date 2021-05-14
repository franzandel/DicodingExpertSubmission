package com.franzandel.dicodingexpertsubmission.di

import com.franzandel.dicodingexpertsubmission.data.local.dao.DetailDao
import com.franzandel.dicodingexpertsubmission.data.local.db.GamesDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

/**
 * Created by Franz Andel on 11/05/21.
 * Android Engineer
 */

@Module
@InstallIn(ViewModelComponent::class)
object DetailVMModule {

    @Provides
    @ViewModelScoped
    fun provideDetailDao(database: GamesDatabase): DetailDao =
        database.detailDao()
}