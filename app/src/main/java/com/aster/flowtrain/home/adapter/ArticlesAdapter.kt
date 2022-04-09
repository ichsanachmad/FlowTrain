package com.aster.flowtrain.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.marginBottom
import androidx.viewbinding.ViewBinding
import coil.load
import com.aster.domain.article.model.Article
import com.aster.flowtrain.base.extension.dpToPx
import com.aster.flowtrain.base.extension.setMargins
import com.aster.flowtrain.base.recyclerview.BaseAdapter
import com.aster.flowtrain.base.recyclerview.BaseViewHolder
import com.aster.flowtrain.databinding.ListItemArticleBinding
import javax.inject.Inject

/**
 * @author ichsanachmad
 */
class ArticlesAdapter @Inject constructor() :
    BaseAdapter<ArticlesAdapter.ArticleViewHolder, Article>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ArticlesAdapter.ArticleViewHolder {
        val view =
            ListItemArticleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ArticleViewHolder(view)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)
        if (position == getItems().size - 1) holder.addMarginBottom()
    }

    inner class ArticleViewHolder(private val view: ListItemArticleBinding) :
        BaseViewHolder<Article>(view) {
        override fun onBind(data: Article) {
            view.apply {
                ivPoster.load(data.newsImageUrl)
                tvTitle.text = data.title
                tvDescription.text = data.description
            }
        }

        fun addMarginBottom() {
            itemView.rootView.setMargins(null, null, null, dpToPx(16f))
        }
    }
}