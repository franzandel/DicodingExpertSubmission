package com.franzandel.dicodingexpertsubmission.di

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.room.Room
import com.franzandel.dicodingexpertsubmission.BuildConfig
import com.franzandel.dicodingexpertsubmission.data.local.db.GamesDatabase
import com.franzandel.dicodingexpertsubmission.presentation.vm.ViewModelFactory
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
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

    private const val GAMES_DB_NAME = "Games.db"

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
    @Singleton
    fun provideGamesDatabase(@ApplicationContext context: Context): GamesDatabase =
        Room.databaseBuilder(
            context,
            GamesDatabase::class.java,
            GAMES_DB_NAME
        ).fallbackToDestructiveMigration()
            .build()

    @Provides
    fun provideViewModelFactory(
        providerMap: MutableMap<Class<out ViewModel>, Provider<ViewModel>>
    ): ViewModelFactory = ViewModelFactory(providerMap)
}