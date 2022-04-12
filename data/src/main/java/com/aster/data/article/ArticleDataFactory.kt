package com.aster.data.article

import com.aster.data.article.local.ArticleLocalRepository
import com.aster.data.article.remote.ArticleNetworkRepository
import com.aster.data.article.remote.ArticleRemoteDataSource
import com.aster.data.base.factory.DataSourceFactory
import com.aster.data.base.source.DataSource
import kotlinx.coroutines.FlowPreview
import javax.inject.Inject

/**
 * @author ichsanachmad
 */
@OptIn(FlowPreview::class)
class ArticleDataFactory @Inject constructor(
    private val articleRemoteDataSource: ArticleNetworkRepository,
    private val articleLocalDataSource: ArticleLocalRepository,
): DataSourceFactory<ArticleEntityData> {
    override fun generateDataSource(dataSource: String): ArticleEntityData {
        return when(dataSource) {
            DataSource.NETWORK -> articleRemoteDataSource
            DataSource.LOCAL -> articleLocalDataSource
            else -> throw IllegalArgumentException()
        }
    }
}