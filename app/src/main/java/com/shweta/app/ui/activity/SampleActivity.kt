package com.shweta.app.ui.activity

import android.view.Gravity
import androidx.activity.viewModels
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import com.shweta.app.R
import com.shweta.app.base.BaseAppCompatActivity
import com.shweta.app.databinding.ActivitySampleBinding
import com.shweta.app.viewmodel.SampleViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SampleActivity : BaseAppCompatActivity<ActivitySampleBinding, SampleViewModel>() {
    override val viewModel: SampleViewModel by viewModels()

    override fun getLayoutResId(): Int = R.layout.activity_sample

    override fun initialize() {
        super.initialize()
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.my_nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        setupBottomNavMenu(navController)

        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_about,
                R.id.nav_policy,
                R.id.nav_my_downloads,
                R.id.nav_change_password,
                R.id.nav_discover_people,
                R.id.nav_logout
            ), binding.drawerLayout
        )
//        setupActionBarWithNavController(navController, appBarConfiguration)
        binding.navView.setupWithNavController(navController)

        //binding.drawerLayout.closeDrawer(GravityCompat.START)
    }

    override fun initializeObservers(viewModel: SampleViewModel) {
        super.initializeObservers(viewModel)
    }

    private fun setupBottomNavMenu(navController: NavController) {
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNav?.setupWithNavController(navController)
    }
}
