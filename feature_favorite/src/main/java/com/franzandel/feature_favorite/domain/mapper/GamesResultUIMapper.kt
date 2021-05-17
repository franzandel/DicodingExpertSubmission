package com.franzandel.feature_favorite.domain.mapper

import com.franzandel.core.mapper.BaseMapper
import com.franzandel.feature_favorite.domain.model.local.request.GamesResultRequest
import com.franzandel.feature_favorite.presentation.model.GamesResultUI
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

/**
 * Created by Franz Andel on 12/05/21.
 * Android Engineer
 */

@ViewModelScoped
class GamesResultUIMapper @Inject constructor() :
    BaseMapper<GamesResultRequest, GamesResultUI>() {

    override fun map(dataModel: GamesResultRequest): GamesResultUI =
        with(dataModel) {
            GamesResultUI(
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