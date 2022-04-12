package com.aster.data.article.remote.module

import com.aster.data.article.remote.ArticleRemoteDataSource
import com.aster.data.retrofit.NewsRetrofit
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

/**
 * @author ichsanachmad
 */
@Module
@InstallIn(SingletonComponent::class)
object ArticleRemoteModule {
    @Provides
    fun providesArticleRemoteDataSource(@NewsRetrofit retrofit: Retrofit): ArticleRemoteDataSource =
        retrofit.create(ArticleRemoteDataSource::class.java)
}