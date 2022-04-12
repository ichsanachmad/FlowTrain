package com.aster.data.article.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.aster.data.article.model.entity.ArticleEntity

/**
 * @author ichsanachmad
 */
@Database(entities = [ArticleEntity::class], version = ArticleDatabase.DB_VERSION)
abstract class ArticleDatabase : RoomDatabase() {
    companion object {
        const val DB_VERSION = 1
    }

    abstract fun articleDao(): ArticleDao
}