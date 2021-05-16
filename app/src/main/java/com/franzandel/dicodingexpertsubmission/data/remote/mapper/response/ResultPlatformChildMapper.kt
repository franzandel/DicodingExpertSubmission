package com.franzandel.dicodingexpertsubmission.data.remote.mapper.response

import com.franzandel.core.mapper.BaseMapper
import com.franzandel.dicodingexpertsubmission.data.remote.model.response.ResultPlatformChildDTO
import com.franzandel.dicodingexpertsubmission.domain.model.remote.response.ResultPlatformChild
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

/**
 * Created by Franz Andel on 04/05/21.
 * Android Engineer
 */

@ViewModelScoped
class ResultPlatformChildMapper @Inject constructor() :
    BaseMapper<ResultPlatformChildDTO, ResultPlatformChild>() {

    override fun map(dataModel: ResultPlatformChildDTO): ResultPlatformChild =
        with(dataModel) {
            ResultPlatformChild(
                gamesCount, id, image, imageBackground, name, slug, yearEnd, yearStart
            )
        }
}