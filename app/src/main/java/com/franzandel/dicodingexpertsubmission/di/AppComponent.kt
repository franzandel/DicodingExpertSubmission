package com.franzandel.dicodingexpertsubmission.di

import android.content.SharedPreferences
import com.franzandel.core.coroutine.CoroutineThread
import com.google.gson.Gson
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

/**
 * Created by Franz Andel on 16/05/21.
 * Android Engineer
 */

@EntryPoint
@InstallIn(SingletonComponent::class)
interface AppComponent {

    fun coroutineThread(): CoroutineThread
    fun retrofit(): Retrofit
    fun gson(): Gson
    fun sharedPreferences(): SharedPreferences
}