package com.franzandel.dicodingexpertsubmission.data.remote.model

data class ScreenshotsDTO(
    val count: Int,
    val next: Any?,
    val previous: Any?,
    val results: List<ResultDTO>
)