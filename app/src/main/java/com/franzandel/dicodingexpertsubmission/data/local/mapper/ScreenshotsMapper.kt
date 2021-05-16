package com.franzandel.dicodingexpertsubmission.data.local.mapper

import com.franzandel.core.mapper.BaseMapper
import com.franzandel.dicodingexpertsubmission.data.local.model.ResultDTO
import com.franzandel.dicodingexpertsubmission.data.local.model.ScreenshotsDTO
import com.franzandel.dicodingexpertsubmission.domain.model.local.Result
import com.franzandel.dicodingexpertsubmission.domain.model.local.Screenshots
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

/**
 * Created by Franz Andel on 04/05/21.
 * Android Engineer
 */

@ViewModelScoped
class ScreenshotsMapper @Inject constructor(
    private val resultMapper: BaseMapper<ResultDTO, Result>
) : BaseMapper<ScreenshotsDTO, Screenshots>() {

    override fun map(dataModel: ScreenshotsDTO): Screenshots =
        with(dataModel) {
            Screenshots(
                count = count,
                next = next,
                previous = previous,
                results = results.map { resultMapper.map(it) }
            )
        }
}
