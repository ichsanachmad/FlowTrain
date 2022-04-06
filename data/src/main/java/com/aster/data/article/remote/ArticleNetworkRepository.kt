package com.aster.data.article.remote

import com.aster.data.article.ArticleEntityData
import com.aster.data.article.model.response.ArticleResponse
import com.aster.data.base.remote.flowSafeNetworkCall
import com.aster.domain.base.Result
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author ichsanachmad
 */
@Singleton
class ArticleNetworkRepository @Inject constructor(
    private val articleRemoteDataSource: ArticleRemoteDataSource
) : ArticleEntityData {
    override suspend fun getArticles(): Flow<Result<List<ArticleResponse>>> {
        return flowSafeNetworkCall {
            articleRemoteDataSource.getArticles("apple", "", "", "")
        }
    }
}