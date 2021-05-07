package com.franzandel.dicodingexpertsubmission.core.extension

import android.app.Activity
import androidx.core.app.ShareCompat
import com.franzandel.dicodingexpertsubmission.R

/**
 * Created by Franz Andel on 06/05/21.
 * Android Engineer
 */

fun Activity.showShareMessage() {
    val mimeType = "text/plain"
    ShareCompat.IntentBuilder
        .from(this)
        .setType(mimeType)
        .setChooserTitle(getString(R.string.share_message_title))
        .setText(getString(R.string.share_message_description))
        .startChooser()
}