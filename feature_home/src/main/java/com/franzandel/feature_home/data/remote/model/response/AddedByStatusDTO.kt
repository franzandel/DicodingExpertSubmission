package com.franzandel.feature_home.data.remote.model.response

import androidx.annotation.Keep

@Keep
data class AddedByStatusDTO(
    val beaten: Int,
    val dropped: Int,
    val owned: Int,
    val playing: Int,
    val toplay: Int,
    val yet: Int
)