package com.franzandel.feature_home.data.remote.model.response

import com.google.gson.annotations.SerializedName

data class ResultPlatformDTO(
    val platform: ResultPlatformChildDTO,
    @SerializedName("released_at")
    val releasedAt: String?,
    @SerializedName("requirements_en")
    val requirementsEn: Any?,
    @SerializedName("requirements_ru")
    val requirementsRu: Any?
)