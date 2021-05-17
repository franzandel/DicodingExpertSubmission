package com.franzandel.feature_home.domain.model.remote.response

data class Store(
    val domain: String,
    val gamesCount: Int,
    val id: Int,
    val imageBackground: String,
    val name: String,
    val slug: String
)