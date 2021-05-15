package com.franzandel.dicodingexpertsubmission.core.extension

import android.app.TimePickerDialog
import android.content.Context
import android.content.Intent
import android.graphics.drawable.Drawable
import android.view.Gravity
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import com.franzandel.dicodingexpertsubmission.R
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

fun Context.loadDrawable(@DrawableRes drawableId: Int): Drawable? =
    ContextCompat.getDrawable(this, drawableId)

fun Context.loadColor(@ColorRes colorId: Int) = ContextCompat.getColor(this, colorId)

fun Context.showImageToast(@DrawableRes drawable: Int, message: String) {
    val view = TextView(this).apply {
        setCompoundDrawablesWithIntrinsicBounds(drawable, 0, 0, 0)
        compoundDrawablePadding = 8F.toDp()
        setBackgroundDrawable(loadDrawable(R.drawable.bg_rounded_toast))
        text = message
        setTextColor(loadColor(android.R.color.white))
        setPadding(8F.toDp(), 12F.toDp(), 16F.toDp(), 12F.toDp())
        gravity = Gravity.CENTER
    }

    Toast(this).apply {
        this.view = view
        show()
    }
}