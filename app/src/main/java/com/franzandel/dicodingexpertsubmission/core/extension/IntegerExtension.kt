package com.franzandel.dicodingexpertsubmission.core.extension

/**
 * Created by Franz Andel on 15/05/21.
 * Android Engineer
 */

fun Int.addZeroPrefix(): String =
    if (this.toString().length < 2)
        "0$this"
    else
        this.toString()
