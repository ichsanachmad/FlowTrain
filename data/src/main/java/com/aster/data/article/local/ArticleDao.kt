package com.aster.data.article.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.aster.data.article.model.entity.ArticleEntity
import kotlinx.coroutines.flow.Flow

/**
 * @author ichsanachmad
 */

@Dao
interface ArticleDao {
    @Query("SELECT * FROM article")
    fun getArticles(): Flow<List<ArticleEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertArticles(articles: List<ArticleEntity>): List<Long>
}