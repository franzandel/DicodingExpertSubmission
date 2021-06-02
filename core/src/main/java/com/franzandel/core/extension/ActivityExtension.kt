package com.franzandel.core.extension

import android.app.Activity
import androidx.core.app.ShareCompat

/**
 * Created by Franz Andel on 06/05/21.
 * Android Engineer
 */

fun Activity.showShareMessage(chooserTitle: String, text: String) {
    val mimeType = "text/plain"
    ShareCompat.IntentBuilder(this)
        .setType(mimeType)
        .setChooserTitle(chooserTitle)
        .setText(text)
        .startChooser()
}