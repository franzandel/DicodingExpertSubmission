package com.franzandel.dicodingexpertsubmission.data.remote.mapper

import com.franzandel.dicodingexpertsubmission.core.mapper.BaseMapper
import com.franzandel.dicodingexpertsubmission.core.mapper.BaseResponseMapper
import com.franzandel.dicodingexpertsubmission.data.remote.model.ResultDTO
import com.franzandel.dicodingexpertsubmission.data.remote.model.ScreenshotsDTO
import com.franzandel.dicodingexpertsubmission.domain.model.Result
import com.franzandel.dicodingexpertsubmission.domain.model.Screenshots
import com.google.gson.Gson
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

/**
 * Created by Franz Andel on 04/05/21.
 * Android Engineer
 */

@ViewModelScoped
class ResponseMapper @Inject constructor(
    gson: Gson,
    private val resultMapper: BaseMapper<ResultDTO, Result>
) : BaseResponseMapper<ScreenshotsDTO, Screenshots>(gson = gson) {

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
