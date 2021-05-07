package com.franzandel.dicodingexpertsubmission.domain.model.remote.response

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