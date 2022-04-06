package com.aster.data.article.remote

import com.aster.data.article.model.response.ArticleResponse
import com.aster.domain.base.Result
import kotlinx.coroutines.flow.Flow

/**
 * @author ichsanachmad
 */
interface ArticleRemoteEntityData {
    suspend fun getArticles(): Flow<Result<List<ArticleResponse>>>
}