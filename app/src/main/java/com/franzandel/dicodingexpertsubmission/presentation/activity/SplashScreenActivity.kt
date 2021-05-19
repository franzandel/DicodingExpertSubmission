package com.franzandel.dicodingexpertsubmission.presentation.activity

import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatDelegate
import androidx.preference.PreferenceManager
import com.franzandel.core.extension.goTo
import com.franzandel.core.presentation.activity.BaseActivity
import com.franzandel.dicodingexpertsubmission.R
import com.franzandel.dicodingexpertsubmission.databinding.ActivitySplashScreenBinding

class SplashScreenActivity : BaseActivity<ActivitySplashScreenBinding>() {

    companion object {
        private const val TIME_OUT = 1000L
    }

    override fun getViewBinding(): ActivitySplashScreenBinding =
        ActivitySplashScreenBinding.inflate(layoutInflater)

    override fun onActivityCreated() {
        setupThemes()
        delayOneSecond()
    }

    private fun setupThemes() {
        val themes = resources.getStringArray(R.array.theme_values)
        val preferences = PreferenceManager.getDefaultSharedPreferences(applicationContext)
        val selectedMode = preferences.getString(getString(R.string.settings_theme_key), "")

        val mode = when (selectedMode.toString()) {
            themes.first() -> AppCompatDelegate.MODE_NIGHT_NO
            themes[1] -> AppCompatDelegate.MODE_NIGHT_YES
            else -> AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM
        }

        AppCompatDelegate.setDefaultNightMode(mode)
    }

    private fun delayOneSecond() {
        Handler(Looper.getMainLooper()).postDelayed({
            kotlin.run {
                goTo(DashboardActivity::class.java)
                finish()
            }
        }, TIME_OUT)
    }
}