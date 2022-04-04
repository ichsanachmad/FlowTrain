package com.aster.domain.base

import java.lang.Exception

/**
 * @author ichsanachmad
 */
sealed class Result<out T> {
    data class Success<T>(val data: T) : Result<T>()
    data class Error(val exception: Exception) : Result<Nothing>()
    object Loading : Result<Nothing>()
}