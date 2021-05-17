package com.franzandel.feature_home.presentation.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.franzandel.dicodingexpertsubmission.di.AppComponent
import com.franzandel.feature_home.R
import com.franzandel.feature_home.databinding.ActivityDashboardBinding
import com.franzandel.feature_home.di.DaggerHomeComponent
import dagger.hilt.android.EntryPointAccessors

class DashboardActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDashboardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        DaggerHomeComponent.builder()
            .context(this)
            .appComponent(
                EntryPointAccessors.fromApplication(
                    applicationContext,
                    AppComponent::class.java
                )
            )
            .build()
            .inject(this)

        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupBottomNavigation()
    }

    private fun setupBottomNavigation() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        binding.navView.setupWithNavController(navController)
    }
}