package com.franzandel.dicodingexpertsubmission.data.remote.model

import com.google.gson.annotations.SerializedName

data class ResultResponseDTO(
    val height: Int,
    val id: Int,
    val image: String,
    @SerializedName("is_deleted")
    val isDeleted: Boolean,
    val width: Int
)