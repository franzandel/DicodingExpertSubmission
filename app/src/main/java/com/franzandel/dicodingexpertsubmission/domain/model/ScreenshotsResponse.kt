package com.franzandel.dicodingexpertsubmission.domain.model

data class ScreenshotsResponse(
    val count: Int,
    val next: Any?,
    val previous: Any?,
    val results: List<ResultResponse>
)