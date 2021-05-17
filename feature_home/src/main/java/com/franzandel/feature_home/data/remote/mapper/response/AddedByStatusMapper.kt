package com.franzandel.feature_home.data.remote.mapper.response

import com.franzandel.core.mapper.BaseMapper
import com.franzandel.feature_home.data.remote.model.response.AddedByStatusDTO
import com.franzandel.feature_home.domain.model.remote.response.AddedByStatus
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