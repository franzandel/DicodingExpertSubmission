package com.franzandel.feature_home.data.remote.mapper.response

import com.franzandel.core.mapper.BaseMapper
import com.franzandel.feature_home.data.remote.model.response.RatingDTO
import com.franzandel.feature_home.domain.model.remote.response.Rating
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

/**
 * Created by Franz Andel on 04/05/21.
 * Android Engineer
 */

@ViewModelScoped
class RatingsMapper @Inject constructor() : BaseMapper<List<RatingDTO>, List<Rating>>() {

    override fun map(dataModel: List<RatingDTO>): List<Rating> =
        with(dataModel) {
            map {
                Rating(
                    it.count, it.id, it.percent, it.title
                )
            }
        }
}