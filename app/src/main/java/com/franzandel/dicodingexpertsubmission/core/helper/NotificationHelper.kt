package com.franzandel.dicodingexpertsubmission.core.helper

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.media.RingtoneManager
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import com.franzandel.dicodingexpertsubmission.R

/**
 * Created by Franz Andel on 15/05/21.
 * Android Engineer
 */

class NotificationHelper(private val applicationContext: Context) {

    companion object {
        const val DAILY_REMINDER_ID = 100
        private const val DAILY_REMINDER_CHANNEL_ID = "daily_reminder_channel"
        private const val DAILY_REMINDER_CHANNEL_NAME = "Daily Reminder Channel"
    }

    private val notificationManager =
        applicationContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
    private val defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
    private val defaultVibrationPattern = longArrayOf(1000, 1000)

    @RequiresApi(Build.VERSION_CODES.O)
    private fun createReminderChannel() = with(applicationContext) {
        val channel = android.app.NotificationChannel(
            DAILY_REMINDER_CHANNEL_ID,
            DAILY_REMINDER_CHANNEL_NAME,
            NotificationManager.IMPORTANCE_DEFAULT
        ).apply {
            enableVibration(true)
            vibrationPattern = defaultVibrationPattern
        }

        notificationManager.createNotificationChannel(channel)
    }

    private fun NotificationCompat.Builder.buildReminderStyle() =
        this.apply {
            setVibrate(defaultVibrationPattern)
            color = ContextCompat.getColor(applicationContext, android.R.color.transparent)
        }

    private fun NotificationCompat.Builder.buildStandardStyle(
        title: String,
        body: String,
        intent: PendingIntent
    ) = this.apply {
        setAutoCancel(true)
        setSmallIcon(R.drawable.ic_launcher_foreground)
        setContentTitle(title)
        setContentText(body)
        setStyle(NotificationCompat.BigTextStyle().bigText(body))
        setSound(defaultSoundUri)
        setContentIntent(intent)
    }

    fun sendReminderNotification(
        notificationId: Int,
        title: String,
        body: String,
        intent: PendingIntent
    ) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) createReminderChannel()

        val builder =
            NotificationCompat.Builder(applicationContext, DAILY_REMINDER_CHANNEL_ID)
                .buildStandardStyle(title, body, intent)
                .buildReminderStyle()

        notificationManager.notify(notificationId, builder.build())
    }
}