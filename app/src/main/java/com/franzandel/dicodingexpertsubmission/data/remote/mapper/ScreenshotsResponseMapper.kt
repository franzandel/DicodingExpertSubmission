package com.franzandel.dicodingexpertsubmission.data.remote.mapper

import com.franzandel.dicodingexpertsubmission.core.mapper.BaseMapper
import com.franzandel.dicodingexpertsubmission.core.mapper.BaseResponseMapper
import com.franzandel.dicodingexpertsubmission.data.remote.model.ResultResponseDTO
import com.franzandel.dicodingexpertsubmission.data.remote.model.ScreenshotsResponseDTO
import com.franzandel.dicodingexpertsubmission.domain.model.ResultResponse
import com.franzandel.dicodingexpertsubmission.domain.model.ScreenshotsResponse
import com.google.gson.Gson
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

/**
 * Created by Franz Andel on 04/05/21.
 * Android Engineer
 */

@ViewModelScoped
class ScreenshotsResponseMapper @Inject constructor(
    gson: Gson,
    private val resultMapper: BaseMapper<ResultResponseDTO, ResultResponse>
) : BaseResponseMapper<ScreenshotsResponseDTO, ScreenshotsResponse>(gson = gson) {

    override fun map(dataModel: ScreenshotsResponseDTO): ScreenshotsResponse =
        with(dataModel) {
            ScreenshotsResponse(
                count = count,
                next = next,
                previous = previous,
                results = results.map { resultMapper.map(it) }
            )
        }
}
