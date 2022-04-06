package com.aster.data.article

import com.aster.data.article.remote.ArticleNetworkRepository
import com.aster.data.article.remote.ArticleRemoteDataSource
import com.aster.data.base.factory.DataSourceFactory
import com.aster.data.base.source.DataSource
import javax.inject.Inject

/**
 * @author ichsanachmad
 */
class ArticleDataFactory @Inject constructor(
    private val articleRemoteDataSource: ArticleNetworkRepository
): DataSourceFactory<ArticleEntityData> {
    override fun generateDataSource(dataSource: String): ArticleEntityData {
        return when(dataSource) {
            DataSource.NETWORK -> articleRemoteDataSource

            else -> throw IllegalArgumentException()
        }
    }
}