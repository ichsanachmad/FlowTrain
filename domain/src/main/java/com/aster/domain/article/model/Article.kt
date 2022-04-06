package com.aster.domain.article.model

/**
 * @author ichsanachmad
 */
data class Article(
    val author: String,
    val title: String,
    val description: String,
    val url: String,
    val publishedAt: String,
    val content: String,
    val newsImageUrl: String,
    val source: Source?,
)
