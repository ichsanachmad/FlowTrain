package com.aster.flowtrain.base.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

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

    protected abstract fun getViewBinding(): Binding
    protected abstract fun init()
}