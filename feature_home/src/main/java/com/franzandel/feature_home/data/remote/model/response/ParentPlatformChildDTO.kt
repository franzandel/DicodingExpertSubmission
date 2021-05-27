package com.franzandel.feature_home.data.remote.model.response

import androidx.annotation.Keep

@Keep
data class ParentPlatformChildDTO(
    val id: Int,
    val name: String,
    val slug: String
)