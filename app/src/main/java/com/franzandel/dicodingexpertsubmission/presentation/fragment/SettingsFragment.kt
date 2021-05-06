package com.franzandel.dicodingexpertsubmission.presentation.fragment

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import com.franzandel.dicodingexpertsubmission.R

class SettingsFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey)
    }
}