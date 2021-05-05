package com.franzandel.dicodingexpertsubmission.domain.model.local

data class Screenshots(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<Result>
)