package com.franzandel.feature_home.domain.model.remote.response

data class Rating(
    val count: Int,
    val id: Int,
    val percent: Double,
    val title: String
)