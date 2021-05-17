package com.franzandel.feature_home.data.remote.mapper.response

import com.franzandel.core.mapper.BaseMapper
import com.franzandel.feature_home.data.remote.model.response.GenreDTO
import com.franzandel.feature_home.domain.model.remote.response.Genre
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

/**
 * Created by Franz Andel on 04/05/21.
 * Android Engineer
 */

@ViewModelScoped
class GenresMapper @Inject constructor() : BaseMapper<List<GenreDTO>, List<Genre>>() {

    override fun map(dataModel: List<GenreDTO>): List<Genre> =
        with(dataModel) {
            map {
                Genre(
                    it.gamesCount, it.id, it.imageBackground, it.name, it.slug
                )
            }
        }
}