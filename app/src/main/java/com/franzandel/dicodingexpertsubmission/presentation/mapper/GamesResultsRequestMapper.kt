package com.franzandel.dicodingexpertsubmission.presentation.mapper

import com.franzandel.core.mapper.BaseMapper
import com.franzandel.dicodingexpertsubmission.domain.model.local.request.GamesResultRequest
import com.franzandel.dicodingexpertsubmission.presentation.model.GamesResultUI
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

/**
 * Created by Franz Andel on 04/05/21.
 * Android Engineer
 */

@ViewModelScoped
class GamesResultsRequestMapper @Inject constructor() :
    BaseMapper<GamesResultUI, GamesResultRequest>() {

    override fun map(dataModel: GamesResultUI): GamesResultRequest =
        with(dataModel) {
            GamesResultRequest(
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