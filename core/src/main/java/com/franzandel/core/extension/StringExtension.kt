package com.franzandel.core.extension

import androidx.appcompat.app.AppCompatDelegate

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
    val splitTime = this.split(':')
    if (splitTime.size > 2) throw Exception("Too many ':' characters")

    val expectedHour = splitTime.first().trim().toInt()
    val expectedMinute = splitTime.last().trim().toInt()
    return Pair(expectedHour, expectedMinute)
}

fun String.setNightMode(themes: Array<String>) {
    val mode = when (this) {
        themes.first() -> AppCompatDelegate.MODE_NIGHT_NO
        themes[1] -> AppCompatDelegate.MODE_NIGHT_YES
        else -> AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM
    }

    AppCompatDelegate.setDefaultNightMode(mode)
}