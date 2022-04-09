package com.aster.flowtrain.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aster.domain.article.enum.TrendCategory
import com.aster.domain.article.interactor.GetArticles
import com.aster.domain.article.model.Article
import com.aster.domain.base.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * @author ichsanachmad
 */
@HiltViewModel
class MainViewModel @Inject constructor(
    private val getArticles: GetArticles
) : ViewModel() {
    private val _articleStateFlow = MutableStateFlow<Result<List<Article>>>(
        Result.Success(
            mutableListOf()
        )
    )
    val articleStateFlow: StateFlow<Result<List<Article>>> get() = _articleStateFlow

    fun getArticles() {
        viewModelScope.launch {
            getArticles.execute(TrendCategory.APPLE.value).collect {
                when (it) {
                    is Result.Success -> _articleStateFlow.emit(Result.Success(it.data))

                    is Result.Error -> _articleStateFlow.emit(Result.Error(it.exception))
                }
            }
        }
    }
}