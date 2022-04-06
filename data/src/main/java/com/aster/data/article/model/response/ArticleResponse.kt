package com.aster.data.article.model.response

import com.aster.domain.article.model.Article
import com.google.gson.annotations.SerializedName

/**
 * @author ichsanachmad
 */

data class ArticleResponse(
    val author: String?,
    val title: String?,
    val description: String?,
    val url: String?,
    val publishedAt: String?,
    val content: String?,
    val source: SourceResponse?,

    @SerializedName("urlToImage")
    val newsImageUrl: String?,
) {
    fun toArticleDomain(): Article = Article(
        author = author ?: "",
        title = title ?: "",
        description = description ?: "",
        url = url ?: "",
        publishedAt = publishedAt ?: "",
        content = content ?: "",
        source = source?.toSourceDomain(),
        newsImageUrl = newsImageUrl ?: "",
    )
}
