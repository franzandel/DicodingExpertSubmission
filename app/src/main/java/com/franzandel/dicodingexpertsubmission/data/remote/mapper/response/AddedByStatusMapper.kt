package com.franzandel.dicodingexpertsubmission.data.remote.mapper.response

import com.franzandel.dicodingexpertsubmission.core.mapper.BaseMapper
import com.franzandel.dicodingexpertsubmission.data.remote.model.response.AddedByStatusDTO
import com.franzandel.dicodingexpertsubmission.domain.model.remote.response.AddedByStatus
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

/**
 * Created by Franz Andel on 04/05/21.
 * Android Engineer
 */

@ViewModelScoped
class AddedByStatusMapper @Inject constructor() :
    BaseMapper<AddedByStatusDTO, AddedByStatus>() {

    override fun map(dataModel: AddedByStatusDTO): AddedByStatus =
        with(dataModel) {
            AddedByStatus(
                beaten, dropped, owned, playing, toplay, yet
            )
        }
}