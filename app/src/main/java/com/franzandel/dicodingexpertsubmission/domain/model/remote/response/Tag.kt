package com.franzandel.dicodingexpertsubmission.domain.model.remote.response

data class Tag(
    val gamesCount: Int,
    val id: Int,
    val imageBackground: String,
    val language: String,
    val name: String,
    val slug: String
)