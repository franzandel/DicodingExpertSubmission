package com.franzandel.dicodingexpertsubmission.core.alarmmanager

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent

/**
 * Created by Franz Andel on 15/05/21.
 * Android Engineer
 */

abstract class BaseAlarmManager(protected val applicationContext: Context) {

    companion object {
        private const val REPEAT_REQUEST_CODE = 101
    }

    abstract fun getIntent(): Intent
    abstract fun getTimeToFirstTrigger(expectedHour: Int, expectedMinute: Int): Long

    fun setRepeatingAlarm(expectedHour: Int, expectedMinute: Int) {
        val alarmManager = getAlarmManager(applicationContext)
        val pendingIntent = getPendingIntent(applicationContext)

        alarmManager.setInexactRepeating(
            AlarmManager.RTC_WAKEUP,
            getTimeToFirstTrigger(expectedHour, expectedMinute),
            AlarmManager.INTERVAL_DAY,
            pendingIntent
        )
    }

    fun cancelAlarm() {
        val alarmManager = getAlarmManager(applicationContext)
        val pendingIntent = getPendingIntent(applicationContext)

        pendingIntent.cancel()
        alarmManager.cancel(pendingIntent)
    }

    fun isAlarmSet(): Boolean =
        PendingIntent.getBroadcast(
            applicationContext,
            REPEAT_REQUEST_CODE,
            getIntent(),
            PendingIntent.FLAG_NO_CREATE
        ) != null

    private fun getAlarmManager(context: Context): AlarmManager =
        context.getSystemService(Context.ALARM_SERVICE) as AlarmManager

    private fun getPendingIntent(context: Context): PendingIntent =
        PendingIntent.getBroadcast(context, REPEAT_REQUEST_CODE, getIntent(), 0)
}