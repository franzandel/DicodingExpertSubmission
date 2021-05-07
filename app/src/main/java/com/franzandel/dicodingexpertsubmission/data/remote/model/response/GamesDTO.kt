package com.franzandel.dicodingexpertsubmission.data.remote.model.response

import com.google.gson.annotations.SerializedName

data class GamesDTO(
    val count: Int,
    val description: String,
    val filters: FiltersDTO,
    val next: String,
    val nofollow: Boolean,
    @SerializedName("nofollow_collections")
    val nofollowCollections: List<String>,
    val noindex: Boolean,
    val previous: Any?,
    val results: List<GamesResultDTO>,
    @SerializedName("seo_description")
    val seoDescription: String,
    @SerializedName("seo_h1")
    val seoH1: String,
    @SerializedName("seo_keywords")
    val seoKeywords: String,
    @SerializedName("seo_title")
    val seoTitle: String
)