package com.franzandel.dicodingexpertsubmission.di

import com.franzandel.dicodingexpertsubmission.core.mapper.BaseMapper
import com.franzandel.dicodingexpertsubmission.domain.model.local.request.GamesResultRequest
import com.franzandel.dicodingexpertsubmission.domain.repository.mapper.response.GamesResultUIMapper
import com.franzandel.dicodingexpertsubmission.presentation.model.GamesResultUI
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

/**
 * Created by Franz Andel on 12/05/21.
 * Android Engineer
 */

@Module
@InstallIn(ActivityComponent::class)
abstract class FavoriteAbstractModule {

    @Binds
    abstract fun bindGamesResultUIMapper(
        gamesResultUIMapper: GamesResultUIMapper
    ): BaseMapper<GamesResultRequest, GamesResultUI>
}