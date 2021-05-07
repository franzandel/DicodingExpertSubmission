package com.franzandel.dicodingexpertsubmission.data.remote.mapper.response

import com.franzandel.dicodingexpertsubmission.core.mapper.BaseMapper
import com.franzandel.dicodingexpertsubmission.data.remote.model.response.EsrbRatingDTO
import com.franzandel.dicodingexpertsubmission.domain.model.remote.response.EsrbRating
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

/**
 * Created by Franz Andel on 04/05/21.
 * Android Engineer
 */

@ViewModelScoped
class EsrbRatingMapper @Inject constructor() : BaseMapper<EsrbRatingDTO?, EsrbRating?>() {

    override fun map(dataModel: EsrbRatingDTO?): EsrbRating? =
        dataModel?.run {
            EsrbRating(
                id, name, slug
            )
        }
}