package com.franzandel.dicodingexpertsubmission.presentation.activity

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import com.franzandel.dicodingexpertsubmission.R
import com.franzandel.dicodingexpertsubmission.core.extension.observe
import com.franzandel.dicodingexpertsubmission.databinding.ActivityMainBinding
import com.franzandel.dicodingexpertsubmission.presentation.vm.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DashboardActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupBottomNavigation()

        viewModel.getGameScreenshots("5286")

        observe(viewModel.gameScreenshots) {
            Log.d("1234", it.toString())
        }

        observe(viewModel.gameScreenshotsError) {
            Log.d("1234", it)
        }
    }

    private fun setupBottomNavigation() {
        val navHostFragment =
//            supportFragmentManager.findFragmentById(binding.navHostFragment.id) as NavHostFragment
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        binding.navView.setupWithNavController(navController)
    }
}