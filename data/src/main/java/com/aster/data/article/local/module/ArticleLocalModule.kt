package com.aster.data.article.local.module

import com.aster.data.article.local.ArticleDao
import com.aster.data.article.local.ArticleDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * @author ichsanachmad
 */
@Module
@InstallIn(SingletonComponent::class)
object ArticleLocalModule {
    @Provides
    fun providesArticleDao(articleDatabase: ArticleDatabase): ArticleDao {
        return articleDatabase.articleDao()
    }
}