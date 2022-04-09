package com.aster.flowtrain.sample

import com.aster.flowtrain.base.fragment.BaseFragment
import com.aster.flowtrain.databinding.FragmentProfileBinding

class ProfileFragment : BaseFragment<FragmentProfileBinding>() {
    override fun getViewBinding(): FragmentProfileBinding = FragmentProfileBinding.inflate(layoutInflater)

    override fun init() {
    }
}