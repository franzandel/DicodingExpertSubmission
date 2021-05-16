package com.franzandel.dicodingexpertsubmission.data.local.mapper

import com.franzandel.core.mapper.BaseMapper
import com.franzandel.dicodingexpertsubmission.data.local.model.GamesResultEntity
import com.franzandel.dicodingexpertsubmission.domain.model.local.request.GamesResultRequest
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

/**
 * Created by Franz Andel on 04/05/21.
 * Android Engineer
 */

@ViewModelScoped
class GamesResultRequestEntityMapper @Inject constructor() :
    BaseMapper<GamesResultEntity, GamesResultRequest>() {

    override fun map(dataModel: GamesResultEntity): GamesResultRequest =
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