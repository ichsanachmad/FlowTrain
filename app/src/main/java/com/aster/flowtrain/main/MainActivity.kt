package com.aster.flowtrain.main

import androidx.activity.viewModels
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.aster.flowtrain.base.BaseActivity
import com.aster.flowtrain.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {

    private val mainViewModel by viewModels<MainViewModel>()
    private val navHostFragment by lazy {
        supportFragmentManager.findFragmentById(binding.navHost.id) as NavHostFragment
    }

    override fun init() {
        mainViewModel.get()
        NavigationUI.setupWithNavController(binding.bottomNav, navHostFragment.navController)
    }

    override fun getViewBinding(): ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)

}