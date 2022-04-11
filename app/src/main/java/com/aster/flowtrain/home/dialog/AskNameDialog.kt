package com.aster.flowtrain.home.dialog

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.aster.domain.base.Result
import com.aster.flowtrain.base.dialog.BaseDialogFragment
import com.aster.flowtrain.databinding.FragmentAskNameBinding
import com.aster.flowtrain.main.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * @author ichsanachmad
 */
@AndroidEntryPoint
class AskNameDialog @Inject constructor() : BaseDialogFragment<FragmentAskNameBinding>() {

    private val mainViewModel by viewModels<MainViewModel>()

    override fun init() {
        onCollectSetName()
        binding.apply {
            btnSubmit.setOnClickListener {
                edtName.text?.let {
                    mainViewModel.setUserName(it.toString())
                }
            }
        }
    }

    private fun onCollectSetName() {
        lifecycleScope.launch {
            mainViewModel.setNameStateFlow.collect {
                when(it) {
                    is Result.Success -> dismiss()
                    
                    is Result.Error -> Log.e(TAG, "onCollectSetName: ${it.exception.message}", )
                }
            }
        }
    }

    override fun getViewBinding(): FragmentAskNameBinding =
        FragmentAskNameBinding.inflate(layoutInflater)

    companion object {
        const val TAG = "AskNameDialog"
    }
}