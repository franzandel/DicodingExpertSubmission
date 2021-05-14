package com.franzandel.dicodingexpertsubmission.core.extension

import android.app.TimePickerDialog
import android.content.Context
import android.content.Intent
import java.util.*

/**
 * Created by Franz Andel on 28/04/21.
 * Android Engineer
 */

fun Context.goTo(clazz: Class<*>, bundle: (Intent.() -> Unit)? = null) {
    Intent(this, clazz).run {
        bundle?.invoke(this)
        startActivity(this)
    }
}

fun Context.showTimePickerDialog(
    listener: TimePickerDialog.OnTimeSetListener,
    onCancelListener: (() -> Unit)? = null
) {
    val calendar = Calendar.getInstance()
    val hour = calendar.get(Calendar.HOUR_OF_DAY)
    val minute = calendar.get(Calendar.MINUTE)
    val formatHour24 = true

    TimePickerDialog(this, listener, hour, minute, formatHour24).run {
        setOnCancelListener {
            onCancelListener?.invoke()
        }

        show()
    }
}