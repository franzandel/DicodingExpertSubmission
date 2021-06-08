package com.franzandel.feature_favorite.di

import com.franzandel.core.mapper.BaseMapper
import com.franzandel.feature_favorite.data.local.mapper.GamesResultRequestEntityMapper
import com.franzandel.feature_favorite.data.local.model.GamesResultEntity
import com.franzandel.feature_favorite.domain.mapper.GamesResultsEntityMapper
import com.franzandel.feature_favorite.domain.model.local.request.GamesResultRequest
import com.franzandel.feature_favorite.presentation.mapper.GamesResultsRequestMapper
import com.franzandel.feature_favorite.presentation.model.GamesResultUI
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

/**
 * Created by Franz Andel on 08/06/21.
 * Android Engineer
 */

@Module
@InstallIn(ViewModelComponent::class)
abstract class SharedFavoriteAbstractVMModule {
    @Binds
    abstract fun bindGamesResultsRequestMapper(
        gamesResultsRequestMapper: GamesResultsRequestMapper
    ): BaseMapper<GamesResultUI, GamesResultRequest>

    @Binds
    abstract fun bindGamesResultsEntityMapper(
        gamesResultsEntityMapper: GamesResultsEntityMapper
    ): BaseMapper<GamesResultRequest, GamesResultEntity>

    @Binds
    abstract fun bindGamesResultsEntityRequestMapper(
        gamesResultRequestEntityMapper: GamesResultRequestEntityMapper
    ): BaseMapper<GamesResultEntity, GamesResultRequest>
}