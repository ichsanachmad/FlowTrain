package com.aster.data.di

import android.content.Context
import androidx.room.Room
import com.aster.data.article.local.ArticleDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

/**
 * @author ichsanachmad
 */
@Module
@InstallIn(SingletonComponent::class)
object LocalModule {

    @Provides
    fun providesArticleRoomDb(@ApplicationContext context: Context): ArticleDatabase {
        return Room
            .databaseBuilder(context, ArticleDatabase::class.java, "article_db")
            .build()
    }
}