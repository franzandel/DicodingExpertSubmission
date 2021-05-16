package com.franzandel.dicodingexpertsubmission.data.remote.mapper.response

import com.franzandel.core.mapper.BaseMapper
import com.franzandel.dicodingexpertsubmission.data.remote.model.response.FiltersYearChildDTO
import com.franzandel.dicodingexpertsubmission.data.remote.model.response.FiltersYearDTO
import com.franzandel.dicodingexpertsubmission.domain.model.remote.response.FiltersYear
import com.franzandel.dicodingexpertsubmission.domain.model.remote.response.FiltersYearChild
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

/**
 * Created by Franz Andel on 04/05/21.
 * Android Engineer
 */

@ViewModelScoped
class FiltersYearMapper @Inject constructor(
    private val filtersYearChildMapper: BaseMapper<List<FiltersYearChildDTO>, List<FiltersYearChild>>
) : BaseMapper<List<FiltersYearDTO>, List<FiltersYear>>() {

    override fun map(dataModel: List<FiltersYearDTO>): List<FiltersYear> =
        with(dataModel) {
            map {
                FiltersYear(
                    it.count,
                    it.decade,
                    it.filter,
                    it.from,
                    it.nofollow,
                    it.to,
                    filtersYearChildMapper.map(it.years)
                )
            }
        }
}