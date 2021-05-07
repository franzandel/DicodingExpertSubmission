package com.franzandel.dicodingexpertsubmission.data.remote.mapper.response

import com.franzandel.dicodingexpertsubmission.core.mapper.BaseMapper
import com.franzandel.dicodingexpertsubmission.core.mapper.BaseResponseMapper
import com.franzandel.dicodingexpertsubmission.data.remote.model.response.FiltersDTO
import com.franzandel.dicodingexpertsubmission.data.remote.model.response.GamesDTO
import com.franzandel.dicodingexpertsubmission.data.remote.model.response.GamesResultDTO
import com.franzandel.dicodingexpertsubmission.domain.model.remote.response.Filters
import com.franzandel.dicodingexpertsubmission.domain.model.remote.response.Games
import com.franzandel.dicodingexpertsubmission.domain.model.remote.response.GamesResult
import com.google.gson.Gson
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

/**
 * Created by Franz Andel on 04/05/21.
 * Android Engineer
 */

@ViewModelScoped
class GamesMapper @Inject constructor(
    gson: Gson,
    private val filtersMapper: BaseMapper<FiltersDTO, Filters>,
    private val gamesResultsMapper: BaseMapper<List<GamesResultDTO>, List<GamesResult>>
) : BaseResponseMapper<GamesDTO, Games>(gson = gson) {

    override fun map(dataModel: GamesDTO): Games =
        with(dataModel) {
            Games(
                count,
                description,
                filtersMapper.map(filters),
                next,
                nofollow,
                nofollowCollections,
                noindex,
                previous,
                gamesResultsMapper.map(results),
                seoDescription,
                seoH1,
                seoKeywords,
                seoTitle
            )
        }
}
