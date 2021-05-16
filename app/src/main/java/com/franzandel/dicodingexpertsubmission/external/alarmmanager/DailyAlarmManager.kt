package com.franzandel.dicodingexpertsubmission.external.alarmmanager

import android.content.Context
import android.content.Intent
import com.franzandel.core.alarmmanager.BaseAlarmManager
import com.franzandel.dicodingexpertsubmission.external.helper.CalendarHelper
import com.franzandel.dicodingexpertsubmission.external.receiver.DailyAlarmReceiver

/**
 * Created by Franz Andel on 15/05/21.
 * Android Engineer
 */

class DailyAlarmManager(applicationContext: Context) : BaseAlarmManager(applicationContext) {

    private val calendarHelper = CalendarHelper()

    override fun getIntent(): Intent = Intent(applicationContext, DailyAlarmReceiver::class.java)

    override fun getTimeToFirstTrigger(expectedHour: Int, expectedMinute: Int): Long =
        calendarHelper.getExpectedTimeInterval(expectedHour, expectedMinute)
}