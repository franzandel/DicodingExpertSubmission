package com.franzandel.dicodingexpertsubmission.domain.model.remote.response

data class Games(
    val count: Int,
    val description: String,
    val filters: Filters,
    val next: String,
    val nofollow: Boolean,
    val nofollowCollections: List<String>,
    val noindex: Boolean,
    val previous: Any?,
    val results: List<GamesResult>,
    val seoDescription: String,
    val seoH1: String,
    val seoKeywords: String,
    val seoTitle: String
)