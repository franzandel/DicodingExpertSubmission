package com.franzandel.dicodingexpertsubmission.domain.model.remote

data class ResultResponse(
    val height: Int,
    val id: Int,
    val image: String,
    val isDeleted: Boolean,
    val width: Int
)