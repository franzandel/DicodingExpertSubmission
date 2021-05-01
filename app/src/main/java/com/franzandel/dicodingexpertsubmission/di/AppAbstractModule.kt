package com.franzandel.dicodingexpertsubmission.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

/**
 * Created by Franz Andel on 01/05/21.
 * Android Engineer
 */

@Module
@InstallIn(ActivityComponent::class)
abstract class AppAbstractModule {
//    @Binds
//    abstract fun bindAppUseCase(
//        useCaseImpl: AppUseCaseImpl
//    ): AppUseCase
//
//    @Binds
//    abstract fun bindAppRepository(
//        repositoryImpl: AppRepositoryImpl
//    ): AppRepository
//
//    @Binds
//    abstract fun bindAppLocalData(
//        localData: AppLocalDataImpl
//    ): AppLocalData
//
//    @Binds
//    abstract fun bindAppRemoteData(
//        remoteData: AppRemoteDataImpl
//    ): AppRemoteData
}