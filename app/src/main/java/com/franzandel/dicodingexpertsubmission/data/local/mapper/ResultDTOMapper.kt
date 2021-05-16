package com.franzandel.dicodingexpertsubmission.data.local.mapper

import com.franzandel.core.mapper.BaseMapper
import com.franzandel.dicodingexpertsubmission.data.local.model.ResultDTO
import com.franzandel.dicodingexpertsubmission.domain.model.local.Result
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

/**
 * Created by Franz Andel on 04/05/21.
 * Android Engineer
 */

@ViewModelScoped
class ResultDTOMapper @Inject constructor() : BaseMapper<Result, ResultDTO>() {

    override fun map(dataModel: Result): ResultDTO =
        with(dataModel) {
            ResultDTO(
                height = height,
                id = id,
                image = image,
                isDeleted = isDeleted,
                width = width
            )
        }
}