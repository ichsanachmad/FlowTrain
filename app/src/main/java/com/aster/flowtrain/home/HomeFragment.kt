package com.aster.flowtrain.home

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.aster.domain.base.Result
import com.aster.flowtrain.base.fragment.BaseFragment
import com.aster.flowtrain.databinding.FragmentHomeBinding
import com.aster.flowtrain.home.adapter.ArticlesAdapter
import com.aster.flowtrain.main.MainViewModel
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
        binding.rvArticle.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = articlesAdapter
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
}