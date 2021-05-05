package com.franzandel.dicodingexpertsubmission.domain.model.remote

data class ScreenshotsResponse(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<ResultResponse>
)