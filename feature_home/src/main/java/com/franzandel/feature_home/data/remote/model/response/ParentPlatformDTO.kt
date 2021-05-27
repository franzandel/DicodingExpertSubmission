package com.franzandel.feature_home.data.remote.model.response

import androidx.annotation.Keep

@Keep
data class ParentPlatformDTO(
    val platform: ParentPlatformChildDTO
)