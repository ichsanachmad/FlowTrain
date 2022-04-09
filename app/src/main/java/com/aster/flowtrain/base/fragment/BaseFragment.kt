package com.aster.flowtrain.base.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

/**
 * @author ichsanachmad
 */
abstract class BaseFragment<Binding : ViewBinding> : Fragment() {
    open val binding by lazy { getViewBinding() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    protected abstract fun getViewBinding(): Binding
    protected abstract fun init()
}