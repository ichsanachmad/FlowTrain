package com.aster.data.article

import com.aster.data.article.model.response.ArticleResponse
import com.aster.domain.base.Result
import kotlinx.coroutines.flow.Flow

/**
 * @author ichsanachmad
 */
interface ArticleEntityData {
    suspend fun getArticles(): Flow<Result<List<ArticleResponse>>>
}