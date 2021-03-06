package com.franzandel.feature_home.data.remote.mapper.response

import com.franzandel.core.mapper.BaseMapper
import com.franzandel.feature_home.data.remote.model.response.EsrbRatingDTO
import com.franzandel.feature_home.domain.model.remote.response.EsrbRating
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