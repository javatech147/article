package com.example.articlemanager.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.articlemanager.data.ArticleDetailsRepository
import com.example.articlemanager.presentation.model.Article
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ArticleDetailsViewModel(
    private val articleDetailsRepository: ArticleDetailsRepository
) : ViewModel() {

    private val _article: MutableStateFlow<Article?> = MutableStateFlow(null)
    val article: StateFlow<Article?> = _article

    fun getArticleById(articleId: Int) {
        viewModelScope.launch {
            articleDetailsRepository.getArticleById(articleId = articleId).collect { article ->
                _article.value = article
            }
        }
    }
}
