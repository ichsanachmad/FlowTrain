package com.aster.domain.article

import com.aster.domain.article.model.Article
import com.aster.domain.base.Result
import kotlinx.coroutines.flow.Flow

/**
 * @author ichsanachmad
 */
interface ArticleRepository {
    suspend fun getArticles(trendCategory: String): Flow<Result<List<Article>>>
}