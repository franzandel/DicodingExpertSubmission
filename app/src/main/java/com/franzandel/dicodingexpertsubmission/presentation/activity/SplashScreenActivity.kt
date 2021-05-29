package com.franzandel.dicodingexpertsubmission.presentation.activity

import android.content.SharedPreferences
import android.os.Handler
import android.os.Looper
import com.franzandel.core.extension.goTo
import com.franzandel.core.extension.setNightMode
import com.franzandel.core.presentation.activity.BaseActivity
import com.franzandel.dicodingexpertsubmission.R
import com.franzandel.dicodingexpertsubmission.databinding.ActivitySplashScreenBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SplashScreenActivity : BaseActivity<ActivitySplashScreenBinding>() {

    companion object {
        private const val TIME_OUT = 1000L
    }

    @Inject
    lateinit var sharedPreferences: SharedPreferences

    override fun getViewBinding(): ActivitySplashScreenBinding =
        ActivitySplashScreenBinding.inflate(layoutInflater)

    override fun onActivityCreated() {
        setupThemes()
        delayOneSecond()
    }

    private fun setupThemes() {
        val themes = resources.getStringArray(R.array.theme_values)
        val selectedMode = sharedPreferences.getString(getString(R.string.settings_theme_key), "")
        selectedMode.toString().setNightMode(themes)
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