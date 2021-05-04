package com.franzandel.dicodingexpertsubmission.data.remote.model

data class ScreenshotsResponseDTO(
    val count: Int,
    val next: Any?,
    val previous: Any?,
    val results: List<ResultResponseDTO>
)