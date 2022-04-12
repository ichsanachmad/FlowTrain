package com.aster.data.article.local

import com.aster.data.article.ArticleEntityData
import com.aster.data.article.mapper.mapEntityToArticleList
import com.aster.data.article.model.entity.ArticleEntity
import com.aster.data.article.model.request.ArticleRequestParam
import com.aster.domain.article.model.Article
import com.aster.domain.base.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/**
 * @author ichsanachmad
 */
class ArticleLocalRepository @Inject constructor(
    private val articleDao: ArticleDao
) : ArticleEntityData {
    override suspend fun getArticles(articleRequestParam: ArticleRequestParam): Flow<Result<List<Article>>> {
        return articleDao.getArticles().map {
            Result.Success(it.mapEntityToArticleList())
        }
    }

    override suspend fun insertArticles(articles: List<ArticleEntity>): List<Long> {
        return articleDao.insertArticles(articles)
    }
}