package com.franzandel.dicodingexpertsubmission.presentation.activity

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.franzandel.dicodingexpertsubmission.R
import com.franzandel.dicodingexpertsubmission.core.extension.observe
import com.franzandel.dicodingexpertsubmission.presentation.vm.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.getGameScreenshots("5286")

        observe(viewModel.gameScreenshots) {
            Log.d("1234", it.toString())
        }

        observe(viewModel.gameScreenshotsError) {
            Log.d("1234", it)
        }
    }
}