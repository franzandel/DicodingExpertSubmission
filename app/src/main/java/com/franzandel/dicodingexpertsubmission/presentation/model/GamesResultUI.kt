package com.franzandel.dicodingexpertsubmission.presentation.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by Franz Andel on 08/05/21.
 * Android Engineer
 */

@Parcelize
data class GamesResultUI(
    val name: String,
    val rating: Double,
    val backgroundImage: String,
    val released: String,
    val platforms: List<String>,
    val genres: List<String>,
    val stores: List<String>,
    val tags: List<String>,
    val shortScreenshots: List<String>
) : Parcelable