package com.franzandel.dicodingexpertsubmission.core.receiver

import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.franzandel.dicodingexpertsubmission.R
import com.franzandel.dicodingexpertsubmission.core.helper.NotificationHelper
import com.franzandel.dicodingexpertsubmission.presentation.activity.SplashScreenActivity

/**
 * Created by Franz Andel on 15/05/21.
 * Android Engineer
 */

class DailyAlarmReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        val title = context.getString(R.string.pn_daily_reminder_title)
        val content = context.getString(R.string.pn_daily_reminder_description)

        val defaultIntent =
            PendingIntent.getActivity(
                context,
                NotificationHelper.DAILY_REMINDER_ID,
                Intent(context, SplashScreenActivity::class.java),
                PendingIntent.FLAG_ONE_SHOT
            )

        val notificationHelper = NotificationHelper(context.applicationContext)
        notificationHelper.sendReminderNotification(
            NotificationHelper.DAILY_REMINDER_ID,
            title,
            content,
            defaultIntent
        )
    }
}