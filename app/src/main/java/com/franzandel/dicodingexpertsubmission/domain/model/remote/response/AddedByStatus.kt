package com.franzandel.dicodingexpertsubmission.domain.model.remote.response

data class AddedByStatus(
    val beaten: Int,
    val dropped: Int,
    val owned: Int,
    val playing: Int,
    val toplay: Int,
    val yet: Int
)