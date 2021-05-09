package com.franzandel.dicodingexpertsubmission.domain.repository.mapper.response

import com.franzandel.dicodingexpertsubmission.core.mapper.BaseMapper
import com.franzandel.dicodingexpertsubmission.domain.model.remote.response.GamesResult
import com.franzandel.dicodingexpertsubmission.presentation.model.GamesResultUI
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

/**
 * Created by Franz Andel on 04/05/21.
 * Android Engineer
 */

@ViewModelScoped
class GamesResultsUIMapper @Inject constructor() :
    BaseMapper<List<GamesResult>, List<GamesResultUI>>() {

    override fun map(dataModel: List<GamesResult>): List<GamesResultUI> =
        dataModel.map {
            with(it) {
                GamesResultUI(
                    name, rating, backgroundImage
                )
            }
        }
}