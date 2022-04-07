package com.aster.domain.article.interactor

import com.aster.domain.annotation.DispatcherIO
import com.aster.domain.article.ArticleRepository
import com.aster.domain.article.model.Article
import com.aster.domain.base.Result
import com.aster.domain.base.usecase.FlowUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * @author ichsanachmad
 */
class GetArticles @Inject constructor(
    @DispatcherIO threadExecutor: CoroutineDispatcher,
    private val articleRepository: ArticleRepository
):FlowUseCase<String, List<Article>>(threadExecutor) {
    override suspend fun buildUseCase(params: String): Flow<Result<List<Article>>> {
        return articleRepository.getArticles(params)
    }
}