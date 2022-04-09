package com.aster.flowtrain.home

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.aster.domain.article.model.Article
import com.aster.domain.base.Result
import com.aster.flowtrain.base.fragment.BaseFragment
import com.aster.flowtrain.databinding.FragmentHomeBinding
import com.aster.flowtrain.home.adapter.ArticlesAdapter
import com.aster.flowtrain.main.MainViewModel
import com.aster.webcontainer.WebContainer
import com.aster.webcontainer.extension.isUrl
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment: BaseFragment<FragmentHomeBinding>() {

    private val mainViewModel by viewModels<MainViewModel>()

    @Inject
    lateinit var articlesAdapter: ArticlesAdapter

    override fun getViewBinding(): FragmentHomeBinding = FragmentHomeBinding.inflate(layoutInflater)
    override fun init() {
        setupArticleRv()
        mainViewModel.getArticles()
        onCollectArticles()
    }

    private fun setupArticleRv() {
        articlesAdapter.apply ArticleAdapter@{
            setOnItemClickListener {
                onArticleItemClick(this.getItem(it))
            }
            binding.rvArticle.apply {
                layoutManager = LinearLayoutManager(context)
                adapter = this@ArticleAdapter
            }
        }
    }

    private fun onCollectArticles() {
        lifecycleScope.launch {
            mainViewModel.articleStateFlow.collect {
                when(it) {
                    is Result.Success -> articlesAdapter.updateItems(it.data ?: listOf())
                }
            }
        }
    }

    private fun onArticleItemClick(article: Article) {
        WebContainer.launch(article.url)
    }
}