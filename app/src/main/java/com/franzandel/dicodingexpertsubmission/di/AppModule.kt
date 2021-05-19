package com.franzandel.dicodingexpertsubmission.di

import androidx.lifecycle.ViewModel
import com.franzandel.core.presentation.vm.ViewModelFactory
import com.franzandel.dicodingexpertsubmission.BuildConfig
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Provider
import javax.inject.Singleton

/**
 * Created by Franz Andel on 01/05/21.
 * Android Engineer
 */

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl(BuildConfig.GAMES_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun provideGson(): Gson = Gson()

    @Provides
    fun provideViewModelFactory(
        providerMap: MutableMap<Class<out ViewModel>, Provider<ViewModel>>
    ): ViewModelFactory =
        ViewModelFactory(providerMap)
}