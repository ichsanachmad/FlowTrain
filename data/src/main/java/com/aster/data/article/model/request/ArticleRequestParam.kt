package com.aster.data.article.model.request

/**
 * @author ichsanachmad
 */
data class ArticleRequestParam(
    val query: String?,
    val from: String?,
    val to: String?,
    val sortBy: String?
)
