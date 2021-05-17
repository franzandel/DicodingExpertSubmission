package com.franzandel.feature_home.domain.model.remote.response

data class ResultPlatform(
    val platform: ResultPlatformChild,
    val releasedAt: String?,
    val requirementsEn: Any?,
    val requirementsRu: Any?
)