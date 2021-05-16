package com.franzandel.dicodingexpertsubmission.presentation.fragment

import android.app.TimePickerDialog
import android.os.Bundle
import android.widget.TimePicker
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_NO
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_YES
import androidx.preference.ListPreference
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import androidx.preference.SwitchPreferenceCompat
import com.franzandel.core.extension.addZeroPrefix
import com.franzandel.core.extension.getHourAndMinute
import com.franzandel.core.extension.showImageToast
import com.franzandel.core.extension.showTimePickerDialog
import com.franzandel.dicodingexpertsubmission.R
import com.franzandel.dicodingexpertsubmission.external.alarmmanager.DailyAlarmManager

class SettingsFragment : PreferenceFragmentCompat(), TimePickerDialog.OnTimeSetListener {

    private val spcReminder by lazy {
        findPreference<SwitchPreferenceCompat>(getString(R.string.settings_reminder_key))!!
    }

    private val pReminderTime by lazy {
        findPreference<Preference>(getString(R.string.settings_reminder_time_key))!!
    }

    private val lpTheme by lazy {
        findPreference<ListPreference>(getString(R.string.settings_theme_key))!!
    }

    private val preferences by lazy {
        preferenceManager.sharedPreferences
    }

    private val dailyAlarmManager by lazy {
        DailyAlarmManager(
            requireContext().applicationContext
        )
    }

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey)
        setupListeners()
        pReminderTime.summary = getReminderTime()
    }

    private fun setupListeners() {
        spcReminder.setOnPreferenceClickListener {
            if (spcReminder.isChecked) {
                val reminderTimePair = getReminderTime().getHourAndMinute()
                val expectedHour = reminderTimePair.first
                val expectedMinute = reminderTimePair.second

                dailyAlarmManager.setRepeatingAlarm(expectedHour, expectedMinute)
                showCheckedToast(getString(R.string.settings_reminder_success_turned_on))
            } else {
                dailyAlarmManager.cancelAlarm()
                showCheckedToast(getString(R.string.settings_reminder_success_turned_off))
            }
            true
        }

        pReminderTime.setOnPreferenceClickListener {
            requireContext().showTimePickerDialog(this)
            true
        }

        lpTheme.setOnPreferenceChangeListener { _, selectedMode ->
            val themes = requireContext().resources.getStringArray(R.array.theme_values)

            val mode = when (selectedMode.toString()) {
                themes.first() -> MODE_NIGHT_NO
                themes[1] -> MODE_NIGHT_YES
                else -> AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM
            }

            AppCompatDelegate.setDefaultNightMode(mode)
            true
        }
    }

    override fun onTimeSet(timePicker: TimePicker?, hour: Int, minute: Int) {
        val formattedHour = hour.addZeroPrefix()
        val formattedMinute = minute.addZeroPrefix()
        val time = "$formattedHour:$formattedMinute"

        pReminderTime.summary = time
        preferences.edit().putString(getString(R.string.settings_reminder_time_key), time).apply()
        dailyAlarmManager.setRepeatingAlarm(hour, minute)

        showCheckedToast(getString(R.string.settings_reminder_success_change_time))
    }

    private fun getReminderTime(): String = preferences.getString(
        getString(R.string.settings_reminder_time_key),
        getString(R.string.settings_reminder_time_default_value)
    ) ?: getString(R.string.settings_reminder_time_default_value)

    private fun showCheckedToast(message: String) {
        requireContext().showImageToast(R.drawable.ic_baseline_check_circle_24, message)
    }
}