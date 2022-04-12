package com.aster.data.article.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.aster.domain.article.model.Article
import com.aster.domain.article.model.Source

/**
 * @author ichsanachmad
 */
@Entity(tableName = "article")
data class ArticleEntity(
    val author: String?,
    @PrimaryKey
    val title: String,
    val description: String?,
    val url: String?,
    val publishedAt: String?,
    val content: String?,
    val id: String?,
    val name: String?,
    val newsImageUrl: String?,
) {
    fun toArticleDomain() = Article(
        author ?: "",
        title,
        description ?: "",
        url ?: "",
        publishedAt ?: "",
        content ?: "",
        newsImageUrl ?: "",
        Source(id ?: "", name ?: "")
    )
}
