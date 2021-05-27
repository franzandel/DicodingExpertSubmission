package com.franzandel.feature_home.data.remote.model.response

import androidx.annotation.Keep

@Keep
data class RatingDTO(
    val count: Int,
    val id: Int,
    val percent: Double,
    val title: String
)