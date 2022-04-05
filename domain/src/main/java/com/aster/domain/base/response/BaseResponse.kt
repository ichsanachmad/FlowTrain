package com.aster.domain.base.response

/**
 * @author ichsanachmad
 */
data class BaseResponse<T>(
    val status: String,
    val totalResults: Int,
    val articles: T?
)
