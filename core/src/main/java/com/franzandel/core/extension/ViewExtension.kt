package com.franzandel.core.extension

import android.view.View

/**
 * Created by Franz Andel on 06/05/21.
 * Android Engineer
 */

fun View.show() {
    this.visibility = View.VISIBLE
}

fun View.hide() {
    this.visibility = View.GONE
}