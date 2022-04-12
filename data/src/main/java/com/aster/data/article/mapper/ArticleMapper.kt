package com.aster.data.article.mapper

import androidx.room.PrimaryKey
import com.aster.data.article.model.entity.ArticleEntity
import com.aster.data.article.model.response.ArticleResponse
import com.aster.domain.article.model.Article

/**
 * @author ichsanachmad
 */

fun List<ArticleResponse>?.mapToArticleList(): List<Article> =
    this?.map {
        it.toArticleDomain()
    }.orEmpty()

fun List<ArticleEntity>?.mapEntityToArticleList(): List<Article> =
    this?.map {
        it.toArticleDomain()
    }.orEmpty()

fun Article.toArticleEntity() = ArticleEntity(
    author = author,
    title = title,
    description = description,
    url = url,
    publishedAt = publishedAt,
    content = content,
    id = source?.id,
    name = source?.name,
    newsImageUrl = newsImageUrl
)