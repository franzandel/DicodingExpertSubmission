package com.franzandel.core.extension

import android.content.res.Resources
import android.util.TypedValue

/**
 * Created by Franz Andel on 15/05/21.
 * Android Engineer
 */

fun Float.toDp(): Int =
    TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        this, Resources.getSystem().displayMetrics
    ).toInt()