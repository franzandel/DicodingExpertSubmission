package com.franzandel.dicodingexpertsubmission.domain.repository.mapper

import com.franzandel.dicodingexpertsubmission.core.mapper.BaseMapper
import com.franzandel.dicodingexpertsubmission.domain.model.local.Result
import com.franzandel.dicodingexpertsubmission.domain.model.local.Screenshots
import com.franzandel.dicodingexpertsubmission.domain.model.remote.ResultResponse
import com.franzandel.dicodingexpertsubmission.domain.model.remote.ScreenshotsResponse
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

/**
 * Created by Franz Andel on 05/05/21.
 * Android Engineer
 */

@ViewModelScoped
class ScreenshotsResponseScreenshotsMapper @Inject constructor(
    private val resultMapper: BaseMapper<ResultResponse, Result>
) : BaseMapper<ScreenshotsResponse, Screenshots>() {

    override fun map(dataModel: ScreenshotsResponse): Screenshots =
        with(dataModel) {
            Screenshots(
                count = count,
                next = next,
                previous = previous,
                results = results.map { resultMapper.map(it) }
            )
        }
}