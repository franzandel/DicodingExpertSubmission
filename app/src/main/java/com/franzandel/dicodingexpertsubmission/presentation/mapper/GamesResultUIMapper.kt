package com.franzandel.dicodingexpertsubmission.presentation.mapper

import com.franzandel.dicodingexpertsubmission.core.mapper.BaseMapper
import com.franzandel.dicodingexpertsubmission.domain.model.remote.response.GamesResult
import com.franzandel.dicodingexpertsubmission.presentation.model.GamesResultUI
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

/**
 * Created by Franz Andel on 14/05/21.
 * Android Engineer
 */

@ViewModelScoped
class GamesResultUIMapper @Inject constructor() : BaseMapper<GamesResult, GamesResultUI>() {

    override fun map(dataModel: GamesResult): GamesResultUI =
        with(dataModel) {
            GamesResultUI(
                name,
                rating,
                backgroundImage,
                released,
                platforms.map { it.platform.name },
                genres.map { it.name },
                stores.map { it.store.name },
                tags.map { it.name },
                shortScreenshots.map { it.image }
            )
        }
}