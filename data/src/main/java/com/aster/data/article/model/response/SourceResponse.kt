package com.aster.data.article.model.response

import com.aster.domain.article.model.Source

/**
 * @author ichsanachmad
 */
data class SourceResponse(
    val id: String?,
    val name: String?,
) {
    fun toSourceDomain(): Source = Source(
        id = this.id ?: "",
        name = this.name ?: ""
    )
}
