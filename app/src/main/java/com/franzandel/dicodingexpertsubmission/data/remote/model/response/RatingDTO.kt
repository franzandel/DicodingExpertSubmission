package com.franzandel.dicodingexpertsubmission.data.remote.model.response

data class RatingDTO(
    val count: Int,
    val id: Int,
    val percent: Double,
    val title: String
)