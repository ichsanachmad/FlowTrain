package com.aster.data.article

import com.aster.data.article.model.entity.ArticleEntity
import com.aster.data.article.model.request.ArticleRequestParam
import com.aster.domain.article.model.Article
import com.aster.domain.base.Result
import kotlinx.coroutines.flow.Flow

/**
 * @author ichsanachmad
 */
interface ArticleEntityData {
    suspend fun getArticles(articleRequestParam: ArticleRequestParam): Flow<Result<List<Article>>>

    suspend fun insertArticles(articles: List<ArticleEntity>): List<Long>
}