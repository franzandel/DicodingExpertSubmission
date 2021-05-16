package com.franzandel.core.extension

/**
 * Created by Franz Andel on 11/05/21.
 * Android Engineer
 */

fun List<String>.toMultiLineString(): String {
    var multiLineString = ""
    forEachIndexed { index, text ->
        multiLineString += if (index == size - 1)
            text
        else
            "$text\n"
    }
    return multiLineString
}

fun List<String>.toCommaString(): String {
    var multiLineString = ""
    forEachIndexed { index, text ->
        multiLineString += if (index == size - 1)
            text
        else
            "$text, "
    }
    return multiLineString
}

fun String.getHourAndMinute(): Pair<Int, Int> {
    val splittedTime = this.split(':')
    if (splittedTime.size > 2) throw Exception("Too many ':' characters")

    val expectedHour = splittedTime.first().trim().toInt()
    val expectedMinute = splittedTime.last().trim().toInt()
    return Pair(expectedHour, expectedMinute)
}