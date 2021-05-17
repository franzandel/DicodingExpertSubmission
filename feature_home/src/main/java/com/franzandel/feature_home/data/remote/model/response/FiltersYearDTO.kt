package com.franzandel.feature_home.data.remote.model.response

data class FiltersYearDTO(
    val count: Int,
    val decade: Int,
    val filter: String,
    val from: Int,
    val nofollow: Boolean,
    val to: Int,
    val years: List<FiltersYearChildDTO>
)