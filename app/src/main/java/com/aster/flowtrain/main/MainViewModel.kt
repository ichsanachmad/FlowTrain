package com.aster.flowtrain.main

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aster.domain.article.enum.TrendCategory
import com.aster.domain.article.interactor.GetArticles
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
    private val getArticles: GetArticles
): ViewModel() {
    fun get(){
        viewModelScope.launch {
            getArticles.execute(TrendCategory.APPLE.value).collect {}
        }
    }
}