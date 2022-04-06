package com.aster.data.article.mapper

import com.aster.data.article.model.response.ArticleResponse
import com.aster.domain.article.model.Article

/**
 * @author ichsanachmad
 */

fun List<ArticleResponse>?.mapToArticleList(): List<Article> =
    this?.map {
        it.toArticleDomain()
    }.orEmpty()