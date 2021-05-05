package com.franzandel.dicodingexpertsubmission.data.remote.model

data class ScreenshotsResponseDTO(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<ResultResponseDTO>
)