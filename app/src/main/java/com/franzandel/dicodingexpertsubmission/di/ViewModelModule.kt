package com.franzandel.dicodingexpertsubmission.di

import com.franzandel.dicodingexpertsubmission.data.local.dao.ScreenshotsDao
import com.franzandel.dicodingexpertsubmission.data.local.db.GamesDatabase
import com.franzandel.dicodingexpertsubmission.data.remote.network.AppService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import retrofit2.Retrofit

/**
 * Created by Franz Andel on 02/05/21.
 * Android Engineer
 */

@Module
@InstallIn(ViewModelComponent::class)
object ViewModelModule {
    @Provides
    @ViewModelScoped
    fun provideAppService(retrofit: Retrofit): AppService =
        retrofit.create(AppService::class.java)

    @Provides
    @ViewModelScoped
    fun provideScreenshotsDao(database: GamesDatabase): ScreenshotsDao =
        database.screenshotsDao()
}