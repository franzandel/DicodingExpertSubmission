package com.franzandel.dicodingexpertsubmission.data.local

import android.content.SharedPreferences
import androidx.preference.PreferenceDataStore

/**
 * Created by Franz Andel on 29/05/21.
 * Android Engineer
 */

class EncryptedPreferenceDataStore(
    private val sharedPreferences: SharedPreferences
) : PreferenceDataStore() {

    override fun putString(key: String, value: String?) {
        sharedPreferences.edit().putString(key, value).apply()
    }

    override fun putStringSet(key: String, values: Set<String>?) {
        sharedPreferences.edit().putStringSet(key, values).apply()
    }

    override fun putInt(key: String, value: Int) {
        sharedPreferences.edit().putInt(key, value).apply()
    }

    override fun putLong(key: String, value: Long) {
        sharedPreferences.edit().putLong(key, value).apply()
    }

    override fun putFloat(key: String, value: Float) {
        sharedPreferences.edit().putFloat(key, value).apply()
    }

    override fun putBoolean(key: String, value: Boolean) {
        sharedPreferences.edit().putBoolean(key, value).apply()
    }

    override fun getString(key: String, defValue: String?): String? =
        sharedPreferences.getString(key, defValue)

    override fun getStringSet(key: String, defValues: Set<String>?): Set<String>? =
        sharedPreferences.getStringSet(key, defValues)

    override fun getInt(key: String, defValue: Int): Int =
        sharedPreferences.getInt(key, defValue)

    override fun getLong(key: String, defValue: Long): Long =
        sharedPreferences.getLong(key, defValue)

    override fun getFloat(key: String, defValue: Float): Float =
        sharedPreferences.getFloat(key, defValue)

    override fun getBoolean(key: String, defValue: Boolean): Boolean =
        sharedPreferences.getBoolean(key, defValue)
}