package com.aster.flowtrain.di

import com.aster.data.article.ArticleEntityRepository
import com.aster.domain.article.ArticleRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.FlowPreview

/**
 * @author ichsanachmad
 */
@Module
@InstallIn(SingletonComponent::class)
@FlowPreview
abstract class ArticleRepositoryModule {
    @Binds
    abstract fun bindArticleRepository(articleEntityRepository: ArticleEntityRepository): ArticleRepository
}