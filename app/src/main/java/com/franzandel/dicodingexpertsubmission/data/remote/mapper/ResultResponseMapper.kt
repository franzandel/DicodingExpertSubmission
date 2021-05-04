package com.franzandel.dicodingexpertsubmission.data.remote.mapper

import com.franzandel.dicodingexpertsubmission.core.mapper.BaseMapper
import com.franzandel.dicodingexpertsubmission.data.remote.model.ResultResponseDTO
import com.franzandel.dicodingexpertsubmission.domain.model.ResultResponse
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

/**
 * Created by Franz Andel on 04/05/21.
 * Android Engineer
 */

@ViewModelScoped
class ResultResponseMapper @Inject constructor() : BaseMapper<ResultResponseDTO, ResultResponse>() {

    override fun map(dataModel: ResultResponseDTO): ResultResponse =
        with(dataModel) {
            ResultResponse(
                height = height,
                id = id,
                image = image,
                is_deleted = is_deleted,
                width = width
            )
        }
}