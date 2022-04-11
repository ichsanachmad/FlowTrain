package com.aster.flowtrain.di

import com.aster.data.article.ArticleEntityRepository
import com.aster.data.user.UserEntityRepository
import com.aster.domain.article.ArticleRepository
import com.aster.domain.user.UserRepository
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
abstract class RepositoryModule {
    @Binds
    abstract fun bindArticleRepository(articleEntityRepository: ArticleEntityRepository): ArticleRepository

    @Binds
    abstract fun bindUserRepository(userEntityRepository: UserEntityRepository): UserRepository
}