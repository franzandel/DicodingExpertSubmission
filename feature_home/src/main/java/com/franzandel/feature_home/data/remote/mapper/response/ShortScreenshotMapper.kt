package com.franzandel.feature_home.data.remote.mapper.response

import com.franzandel.core.mapper.BaseMapper
import com.franzandel.feature_home.data.remote.model.response.ShortScreenshotDTO
import com.franzandel.feature_home.domain.model.remote.response.ShortScreenshot
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

/**
 * Created by Franz Andel on 04/05/21.
 * Android Engineer
 */

@ViewModelScoped
class ShortScreenshotMapper @Inject constructor() :
    BaseMapper<List<ShortScreenshotDTO>, List<ShortScreenshot>>() {

    override fun map(dataModel: List<ShortScreenshotDTO>): List<ShortScreenshot> =
        with(dataModel) {
            map {
                ShortScreenshot(
                    it.id, it.image
                )
            }
        }
}