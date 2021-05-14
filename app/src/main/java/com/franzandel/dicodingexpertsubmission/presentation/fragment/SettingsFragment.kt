package com.franzandel.dicodingexpertsubmission.presentation.fragment

import android.app.TimePickerDialog
import android.os.Bundle
import android.widget.TimePicker
import android.widget.Toast
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import androidx.preference.SwitchPreferenceCompat
import com.franzandel.dicodingexpertsubmission.R
import com.franzandel.dicodingexpertsubmission.core.extension.showTimePickerDialog

class SettingsFragment : PreferenceFragmentCompat(), TimePickerDialog.OnTimeSetListener {

    private val spcReminder by lazy {
        findPreference<SwitchPreferenceCompat>(getString(R.string.settings_reminder_key))!!
    }

    private val pReminderTime by lazy {
        findPreference<Preference>(getString(R.string.settings_reminder_time_key))!!
    }

    private val preferences by lazy {
        preferenceManager.sharedPreferences
    }

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey)

        spcReminder.setOnPreferenceClickListener {
            if (spcReminder.isChecked) {
                Toast.makeText(requireContext(), "ON!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(requireContext(), "OFF!", Toast.LENGTH_SHORT).show()
            }
            true
        }

        pReminderTime.setOnPreferenceClickListener {
            requireContext().showTimePickerDialog(this)
            true
        }

        pReminderTime.summary = preferences.getString(
            getString(R.string.settings_reminder_time_key),
            getString(R.string.settings_reminder_time_default_value)
        )
    }

    override fun onTimeSet(timePicker: TimePicker?, hour: Int, minute: Int) {
        val time = "$hour:$minute"
        pReminderTime.summary = time
        preferences.edit().putString(getString(R.string.settings_reminder_time_key), time).apply()
    }
}