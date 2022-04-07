package com.aster.flowtrain.base

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * @author ichsanachmad
 */
abstract class BaseActivity<Binding : ViewBinding> :
    AppCompatActivity() {

    open val binding by lazy { getViewBinding() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        init()
    }

    protected abstract fun init()
    protected abstract fun getViewBinding(): Binding
}