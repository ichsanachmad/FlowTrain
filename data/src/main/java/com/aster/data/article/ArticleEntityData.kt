package com.aster.data.article

import com.aster.data.article.model.request.ArticleRequestParam
import com.aster.data.article.model.response.ArticleResponse
import com.aster.domain.base.Result
import kotlinx.coroutines.flow.Flow

/**
 * @author ichsanachmad
 */
interface ArticleEntityData {
    suspend fun getArticles(articleRequestParam: ArticleRequestParam): Flow<Result<List<ArticleResponse>>>
}