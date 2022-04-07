package com.aster.data.article.model.request

import retrofit2.http.Query

/**
 * @author ichsanachmad
 */
data class ArticleRequestParam(
    @Query("q")
    val query: String?,

    @Query("from")
    val from: String?,

    @Query("to")
    val to: String?,

    @Query("sortBy")
    val sortBy: String?
)
