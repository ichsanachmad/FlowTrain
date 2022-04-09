package com.aster.flowtrain.main

import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.aster.domain.base.Result
import com.aster.flowtrain.base.activity.BaseActivity
import com.aster.flowtrain.databinding.ActivityMainBinding
import com.aster.flowtrain.home.adapter.ArticlesAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {

    private val navHostFragment by lazy {
        supportFragmentManager.findFragmentById(binding.navHost.id) as NavHostFragment
    }

    override fun init() {
        NavigationUI.setupWithNavController(binding.bottomNav, navHostFragment.navController)
    }

    override fun getViewBinding(): ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)

}