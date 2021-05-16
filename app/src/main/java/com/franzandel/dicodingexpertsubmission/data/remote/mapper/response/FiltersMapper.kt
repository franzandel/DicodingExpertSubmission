package com.franzandel.dicodingexpertsubmission.data.remote.mapper.response

import com.franzandel.core.mapper.BaseMapper
import com.franzandel.dicodingexpertsubmission.data.remote.model.response.FiltersDTO
import com.franzandel.dicodingexpertsubmission.data.remote.model.response.FiltersYearDTO
import com.franzandel.dicodingexpertsubmission.domain.model.remote.response.Filters
import com.franzandel.dicodingexpertsubmission.domain.model.remote.response.FiltersYear
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

/**
 * Created by Franz Andel on 04/05/21.
 * Android Engineer
 */

@ViewModelScoped
class FiltersMapper @Inject constructor(
    private val filtersYearMapper: BaseMapper<List<FiltersYearDTO>, List<FiltersYear>>
) : BaseMapper<FiltersDTO, Filters>() {

    override fun map(dataModel: FiltersDTO): Filters =
        with(dataModel) {
            Filters(
                filtersYearMapper.map(years)
            )
        }
}