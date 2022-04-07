package com.aster.data.article

import com.aster.data.article.mapper.mapToArticleList
import com.aster.data.base.mapper.mapResultFlow
import com.aster.data.base.source.DataSource
import com.aster.domain.article.ArticleRepository
import com.aster.domain.article.model.Article
import com.aster.domain.base.Result
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author ichsanachmad
 */
@FlowPreview
@Singleton
class ArticleEntityRepository @Inject constructor(
    private val articleDataFactory: ArticleDataFactory
) : ArticleRepository {

    override suspend fun getArticles(): Flow<Result<List<Article>>> {
        return articleNetworkDataFactory.getArticles().mapResultFlow {
            it.mapToArticleList()
        }
    }

    private val articleNetworkDataFactory by lazy { articleDataFactory.generateDataSource(DataSource.NETWORK) }
}