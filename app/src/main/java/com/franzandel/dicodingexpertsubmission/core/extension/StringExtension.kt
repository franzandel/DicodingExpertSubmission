package com.franzandel.dicodingexpertsubmission.core.extension

/**
 * Created by Franz Andel on 11/05/21.
 * Android Engineer
 */

fun List<String>.toMultiLineString(): String {
    var multiLineString = ""
    forEach {
        multiLineString += "$it\n"
    }
    return multiLineString
}