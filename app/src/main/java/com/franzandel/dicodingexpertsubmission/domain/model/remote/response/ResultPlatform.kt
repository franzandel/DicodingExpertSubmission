package com.franzandel.dicodingexpertsubmission.domain.model.remote.response

data class ResultPlatform(
    val platform: ResultPlatformChild,
    val releasedAt: String,
    val requirementsEn: Any?,
    val requirementsRu: Any?
)