package com.aster.data.article.remote

import com.aster.data.article.ArticleEntityData
import com.aster.data.article.mapper.mapToArticleList
import com.aster.data.article.model.entity.ArticleEntity
import com.aster.data.article.model.request.ArticleRequestParam
import com.aster.data.article.model.response.ArticleResponse
import com.aster.data.base.mapper.mapResultFlow
import com.aster.data.base.remote.flowSafeNetworkCall
import com.aster.domain.article.model.Article
import com.aster.domain.base.Result
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author ichsanachmad
 */
@Singleton
@FlowPreview
class ArticleNetworkRepository @Inject constructor(
    private val articleRemoteDataSource: ArticleRemoteDataSource
) : ArticleEntityData {
    override suspend fun getArticles(articleRequestParam: ArticleRequestParam): Flow<Result<List<Article>>> {
        return flowSafeNetworkCall {
            articleRequestParam.let {
                articleRemoteDataSource.getArticles(
                    it.query ?: "",
                    it.from ?: "",
                    it.to ?: "",
                    it.sortBy ?: ""
                )
            }
        }.mapResultFlow {
            it.mapToArticleList()
        }
    }

    override suspend fun insertArticles(articles: List<ArticleEntity>): List<Long> {
        throw IllegalArgumentException()
    }
}