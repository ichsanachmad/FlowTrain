package com.aster.flowtrain.home

import android.util.Log
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.aster.domain.article.model.Article
import com.aster.domain.base.Result
import com.aster.flowtrain.base.fragment.BaseFragment
import com.aster.flowtrain.databinding.FragmentHomeBinding
import com.aster.flowtrain.home.adapter.ArticlesAdapter
import com.aster.flowtrain.home.dialog.AskNameDialog
import com.aster.flowtrain.main.MainViewModel
import com.aster.webcontainer.WebContainer
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    private val mainViewModel by viewModels<MainViewModel>()

    @Inject
    lateinit var articlesAdapter: ArticlesAdapter

    @Inject
    lateinit var askNameDialog: AskNameDialog

    override fun getViewBinding(): FragmentHomeBinding = FragmentHomeBinding.inflate(layoutInflater)
    override fun init() {
        setupArticleRv()
        mainViewModel.run {
            getUserName()
            getArticles()
        }
        onCollectName()
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
                when (it) {
                    is Result.Success -> articlesAdapter.updateItems(it.data ?: listOf())
                }
            }
        }
    }

    private fun onArticleItemClick(article: Article) {
        WebContainer.launch(article.url)
    }

    private fun onCollectName() {
        lifecycleScope.launch {
            mainViewModel.getNameStateFlow.collect {
                when (it) {
                    is Result.Success -> {
                        it.data?.let { name->
                            if (name.isEmpty()) {
                                showAskNameDialog()
                            } else {
                                Toast.makeText(
                                    requireActivity(),
                                    "Hello ${it.data}",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                    }

                    is Result.Error -> Log.e(TAG, "onCollectName: ${it.exception}")
                }
            }
        }
    }

    private fun showAskNameDialog() {
        askNameDialog.show(childFragmentManager, AskNameDialog.TAG)
    }

    companion object {
        private const val TAG = "HomeFragment"
    }
}