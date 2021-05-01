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
object AppModule {

//    @Provides
//    fun provideAnalyticsService(
//        // Potential dependencies of this type
//    ): AnalyticsService {
//        return Retrofit.Builder()
//            .baseUrl("https://example.com")
//            .build()
//            .create(AnalyticsService::class.java)
//    }
}