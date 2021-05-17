package com.franzandel.feature_favorite.domain.mapper

import com.franzandel.core.mapper.BaseMapper
import com.franzandel.feature_favorite.data.local.model.GamesResultEntity
import com.franzandel.feature_favorite.domain.model.local.request.GamesResultRequest
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

/**
 * Created by Franz Andel on 04/05/21.
 * Android Engineer
 */

@ViewModelScoped
class GamesResultsEntityMapper @Inject constructor() :
    BaseMapper<GamesResultRequest, GamesResultEntity>() {

    override fun map(dataModel: GamesResultRequest): GamesResultEntity =
        with(dataModel) {
            GamesResultEntity(
                name,
                rating,
                backgroundImage,
                released,
                platforms,
                genres,
                stores,
                tags,
                shortScreenshots
            )
        }
}