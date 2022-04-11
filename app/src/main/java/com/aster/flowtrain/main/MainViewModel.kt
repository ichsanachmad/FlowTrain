package com.aster.flowtrain.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aster.domain.article.enum.TrendCategory
import com.aster.domain.article.interactor.GetArticles
import com.aster.domain.article.model.Article
import com.aster.domain.base.NoParams
import com.aster.domain.base.Result
import com.aster.domain.user.interactor.GetUserName
import com.aster.domain.user.interactor.SetUserName
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
    private val getArticles: GetArticles,
    private val setUserName: SetUserName,
    private val getUserName: GetUserName
) : ViewModel() {
    private val _articleStateFlow = MutableStateFlow<Result<List<Article>>>(
        Result.Success(
            mutableListOf()
        )
    )
    val articleStateFlow: StateFlow<Result<List<Article>>> get() = _articleStateFlow

    private val _setNameStateFlow = MutableStateFlow<Result<NoParams>>(
        Result.Success(NoParams)
    )
    val setNameStateFlow: StateFlow<Result<NoParams>> get() = _setNameStateFlow

    private val _getNameStateFlow = MutableStateFlow<Result<String>>(
        Result.Success("")
    )
    val getNameStateFlow: StateFlow<Result<String>> get() = _getNameStateFlow

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

    fun setUserName(name: String) {
        setUserName.invoke(name, onSuccess = {
            _setNameStateFlow.emit(Result.Success(NoParams))
        }, onError = {
            _setNameStateFlow.emit(Result.Error(it))
        })
    }

    fun getUserName(){
        viewModelScope.launch {
            getUserName.execute(NoParams).collect {
                when (it) {
                    is Result.Success -> _getNameStateFlow.emit(Result.Success(it.data))

                    is Result.Error -> _articleStateFlow.emit(Result.Error(it.exception))
                }
            }
        }
    }
}