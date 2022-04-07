package com.aster.flowtrain.main

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aster.domain.DomainTest
import com.aster.domain.base.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * @author ichsanachmad
 */
@HiltViewModel
class MainViewModel @Inject constructor(
    private val domainTest: DomainTest
): ViewModel() {
    fun get(){
        viewModelScope.launch {

        }
    }
}