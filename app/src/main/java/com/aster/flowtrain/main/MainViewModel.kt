package com.aster.flowtrain.main

import androidx.lifecycle.ViewModel
import com.aster.domain.DomainTest
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * @author ichsanachmad
 */
@HiltViewModel
class MainViewModel @Inject constructor(
    domainTest: DomainTest
): ViewModel() {
    val a = domainTest.a()
}