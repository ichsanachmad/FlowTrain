package com.aster.flowtrain.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.fragment.app.findFragment
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.aster.flowtrain.R
import com.aster.flowtrain.databinding.ActivityMainBinding
import com.aster.webcontainer.WebContainer
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    companion object {
        private const val TAG = "MainActivity"
    }

    private val mainViewModel by viewModels<MainViewModel>()
    private val navHostFragment by lazy {
        supportFragmentManager.findFragmentById(binding.navHost.id) as NavHostFragment
    }

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        NavigationUI.setupWithNavController(binding.bottomNav, navHostFragment.navController)
    }
}