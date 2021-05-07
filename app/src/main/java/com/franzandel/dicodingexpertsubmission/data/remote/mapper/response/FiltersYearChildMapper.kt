package com.franzandel.dicodingexpertsubmission.data.remote.mapper.response

import com.franzandel.dicodingexpertsubmission.core.mapper.BaseMapper
import com.franzandel.dicodingexpertsubmission.data.remote.model.response.FiltersYearChildDTO
import com.franzandel.dicodingexpertsubmission.domain.model.remote.response.FiltersYearChild
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

/**
 * Created by Franz Andel on 04/05/21.
 * Android Engineer
 */

@ViewModelScoped
class FiltersYearChildMapper @Inject constructor() :
    BaseMapper<List<FiltersYearChildDTO>, List<FiltersYearChild>>() {

    override fun map(dataModel: List<FiltersYearChildDTO>): List<FiltersYearChild> =
        with(dataModel) {
            map {
                FiltersYearChild(
                    it.count,
                    it.nofollow,
                    it.year
                )
            }
        }
}