package com.franzandel.dicodingexpertsubmission.domain.model

data class ResultResponse(
    val height: Int,
    val id: Int,
    val image: String,
    val is_deleted: Boolean,
    val width: Int
)