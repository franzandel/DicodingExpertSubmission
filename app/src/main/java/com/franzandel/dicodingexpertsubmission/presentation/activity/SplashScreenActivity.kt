package com.franzandel.dicodingexpertsubmission.presentation.activity

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.franzandel.dicodingexpertsubmission.R
import com.franzandel.dicodingexpertsubmission.core.extension.goTo

class SplashScreenActivity : AppCompatActivity() {
    companion object {
        private const val TIME_OUT = 1000L
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        delayOneSecond()
    }

    private fun delayOneSecond() {
        Handler(Looper.getMainLooper()).postDelayed({
            kotlin.run {
                goTo(MainActivity::class.java)
                finish()
            }
        }, TIME_OUT)
    }
}