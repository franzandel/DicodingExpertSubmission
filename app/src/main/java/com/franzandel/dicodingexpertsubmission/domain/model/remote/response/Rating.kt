package com.franzandel.dicodingexpertsubmission.domain.model.remote.response

data class Rating(
    val count: Int,
    val id: Int,
    val percent: Double,
    val title: String
)