package com.franzandel.dicodingexpertsubmission.domain.repository.mapper.response

import com.franzandel.dicodingexpertsubmission.core.mapper.BaseMapper
import com.franzandel.dicodingexpertsubmission.domain.model.local.request.GamesResultRequest
import com.franzandel.dicodingexpertsubmission.presentation.model.GamesResultUI
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

/**
 * Created by Franz Andel on 12/05/21.
 * Android Engineer
 */

@ActivityScoped
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