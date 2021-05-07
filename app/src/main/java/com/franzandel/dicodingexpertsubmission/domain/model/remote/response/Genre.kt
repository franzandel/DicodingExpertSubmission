package com.franzandel.dicodingexpertsubmission.domain.model.remote.response

data class Genre(
    val gamesCount: Int,
    val id: Int,
    val imageBackground: String,
    val name: String,
    val slug: String
)