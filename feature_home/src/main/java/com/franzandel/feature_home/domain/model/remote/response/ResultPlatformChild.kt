package com.franzandel.feature_home.domain.model.remote.response

data class ResultPlatformChild(
    val gamesCount: Int,
    val id: Int,
    val image: Any?,
    val imageBackground: String,
    val name: String,
    val slug: String,
    val yearEnd: Any?,
    val yearStart: Int?
)