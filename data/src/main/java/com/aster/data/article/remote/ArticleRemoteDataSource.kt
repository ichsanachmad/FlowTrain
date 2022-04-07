package com.aster.data.article.remote

import com.aster.data.article.model.request.ArticleRequestParam
import com.aster.data.article.model.response.ArticleResponse
import com.aster.domain.base.response.BaseResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @author ichsanachmad
 */

interface ArticleRemoteDataSource {
    @GET("everything")
    suspend fun getArticles(
        @Query("q")
        query: String,

        @Query("from")
        from: String,

        @Query("to")
        to: String,

        @Query("sortBy")
        sortBy: String
    ): Response<BaseResponse<List<ArticleResponse>>>
}