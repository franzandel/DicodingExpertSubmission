package com.franzandel.dicodingexpertsubmission.di

import com.franzandel.dicodingexpertsubmission.core.coroutine.CoroutineThread
import com.franzandel.dicodingexpertsubmission.core.coroutine.CoroutineThreadImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * Created by Franz Andel on 01/05/21.
 * Android Engineer
 */

@Module
@InstallIn(SingletonComponent::class)
abstract class AppAbstractModule {
    @Binds
    abstract fun bindCoroutineThread(
        coroutineThreadImpl: CoroutineThreadImpl
    ): CoroutineThread
}