package com.franzandel.dicodingexpertsubmission.domain.model.remote.response

data class FiltersYear(
    val count: Int,
    val decade: Int,
    val filter: String,
    val from: Int,
    val nofollow: Boolean,
    val to: Int,
    val years: List<FiltersYearChild>
)