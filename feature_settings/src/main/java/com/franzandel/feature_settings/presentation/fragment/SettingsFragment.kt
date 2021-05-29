package com.franzandel.feature_settings.presentation.fragment

import android.app.TimePickerDialog
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.TimePicker
import androidx.preference.ListPreference
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import androidx.preference.SwitchPreferenceCompat
import com.franzandel.core.extension.*
import com.franzandel.dicodingexpertsubmission.data.local.EncryptedPreferenceDataStore
import com.franzandel.dicodingexpertsubmission.di.AppComponent
import com.franzandel.dicodingexpertsubmission.external.alarmmanager.DailyAlarmManager
import com.franzandel.feature_settings.R
import com.franzandel.feature_settings.di.DaggerSettingsComponent
import dagger.hilt.android.EntryPointAccessors
import javax.inject.Inject
import com.franzandel.dicodingexpertsubmission.R as AppR

class SettingsFragment : PreferenceFragmentCompat(), TimePickerDialog.OnTimeSetListener {

    @Inject
    lateinit var sharedPreferences: SharedPreferences

    private val spcReminder by lazy {
        findPreference<SwitchPreferenceCompat>(getString(R.string.settings_reminder_key))!!
    }

    private val pReminderTime by lazy {
        findPreference<Preference>(getString(R.string.settings_reminder_time_key))!!
    }

    private val lpTheme by lazy {
        findPreference<ListPreference>(getString(AppR.string.settings_theme_key))!!
    }

    private val preferences by lazy {
        EncryptedPreferenceDataStore(sharedPreferences)
    }

    private val dailyAlarmManager by lazy {
        DailyAlarmManager(requireContext().applicationContext)
    }

    override fun onAttach(context: Context) {
        DaggerSettingsComponent.builder()
            .context(requireContext())
            .appComponent(
                EntryPointAccessors.fromApplication(
                    requireContext().applicationContext,
                    AppComponent::class.java
                )
            )
            .build()
            .inject(this)
        super.onAttach(context)
    }

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        preferenceManager.preferenceDataStore = preferences
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
            val themes = requireContext().resources.getStringArray(AppR.array.theme_values)
            selectedMode.toString().setNightMode(themes)
            true
        }
    }

    override fun onTimeSet(timePicker: TimePicker?, hour: Int, minute: Int) {
        val formattedHour = hour.addZeroPrefix()
        val formattedMinute = minute.addZeroPrefix()
        val time = "$formattedHour:$formattedMinute"

        pReminderTime.summary = time
        preferences.putString(getString(R.string.settings_reminder_time_key), time)
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