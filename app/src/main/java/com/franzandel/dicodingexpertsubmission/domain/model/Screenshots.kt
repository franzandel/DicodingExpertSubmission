package com.franzandel.dicodingexpertsubmission.domain.model

data class Screenshots(
    val count: Int,
    val next: Any?,
    val previous: Any?,
    val results: List<Result>
)