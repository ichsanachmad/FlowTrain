package com.aster.data.article

import com.aster.data.article.mapper.mapToArticleList
import com.aster.data.article.mapper.toArticleEntity
import com.aster.data.article.model.request.ArticleRequestParam
import com.aster.data.base.mapper.mapResultFlow
import com.aster.data.base.source.DataSource
import com.aster.domain.article.ArticleRepository
import com.aster.domain.article.model.Article
import com.aster.domain.base.Result
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.*
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

    override suspend fun getArticles(trendCategory: String): Flow<Result<List<Article>>> {
        val articleRequestParam = ArticleRequestParam(
            query = trendCategory,
            from = "",
            to = "",
            sortBy = ""
        )
        return articleNetworkDataFactory.getArticles(articleRequestParam).flatMapConcat {
            when (it) {
                is Result.Success -> {
                    articleLocalDataFactory.insertArticles(
                        it.data?.map { articles -> articles.toArticleEntity() }
                            ?: listOf())
                    flowOf(it)
                }

                is Result.Error -> articleLocalDataFactory.getArticles(articleRequestParam)

                else -> throw IllegalStateException()
            }
        }
    }

    private val articleNetworkDataFactory by lazy { articleDataFactory.generateDataSource(DataSource.NETWORK) }
    private val articleLocalDataFactory by lazy { articleDataFactory.generateDataSource(DataSource.LOCAL) }
}