package com.franzandel.dicodingexpertsubmission.presentation.activity

import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.franzandel.core.presentation.activity.BaseActivity
import com.franzandel.dicodingexpertsubmission.R
import com.franzandel.dicodingexpertsubmission.databinding.ActivityDashboardBinding
import dagger.hilt.android.AndroidEntryPoint

//@AndroidEntryPoint
//class DashboardActivity : AppCompatActivity() {
//
//    private lateinit var binding: ActivityDashboardBinding
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = ActivityDashboardBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        setupBottomNavigation()
//    }
//
//    private fun setupBottomNavigation() {
//        val navHostFragment =
//            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
//        val navController = navHostFragment.navController
//        binding.navView.setupWithNavController(navController)
//    }
//}

@AndroidEntryPoint
class DashboardActivity : BaseActivity<ActivityDashboardBinding>() {

    override fun getViewBinding(): ActivityDashboardBinding =
        ActivityDashboardBinding.inflate(layoutInflater)

    override fun onActivityCreated() {
        setupBottomNavigation()
    }

    private fun setupBottomNavigation() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        binding.navView.setupWithNavController(navController)
    }
}