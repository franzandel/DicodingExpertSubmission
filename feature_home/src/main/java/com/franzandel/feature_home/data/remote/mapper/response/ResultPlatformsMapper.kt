package com.franzandel.feature_home.data.remote.mapper.response

import com.franzandel.core.mapper.BaseMapper
import com.franzandel.feature_home.data.remote.model.response.ResultPlatformChildDTO
import com.franzandel.feature_home.data.remote.model.response.ResultPlatformDTO
import com.franzandel.feature_home.domain.model.remote.response.ResultPlatform
import com.franzandel.feature_home.domain.model.remote.response.ResultPlatformChild
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

/**
 * Created by Franz Andel on 04/05/21.
 * Android Engineer
 */

@ViewModelScoped
class ResultPlatformsMapper @Inject constructor(
    private val resultPlatformChildMapper: BaseMapper<ResultPlatformChildDTO, ResultPlatformChild>
) : BaseMapper<List<ResultPlatformDTO>, List<ResultPlatform>>() {

    override fun map(dataModel: List<ResultPlatformDTO>): List<ResultPlatform> =
        with(dataModel) {
            map {
                ResultPlatform(
                    resultPlatformChildMapper.map(it.platform),
                    it.releasedAt,
                    it.requirementsEn,
                    it.requirementsRu
                )
            }
        }
}