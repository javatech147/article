package com.example.articlemanager.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.articlemanager.data.ArticleRepository
import com.example.articlemanager.presentation.model.Article
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ArticleListViewModel(
    private val repository: ArticleRepository
) : ViewModel() {

    private val _articles: MutableStateFlow<List<Article>> = MutableStateFlow(listOf())
    val articles: StateFlow<List<Article>> = _articles


    init {
        getArticles()
        observeArticles()
    }

    private fun observeArticles() {
        viewModelScope.launch {
            repository.observeArticles().collect { articles ->
                _articles.value = articles
            }
        }
    }

    private fun getArticles() {
        viewModelScope.launch {
            repository.getArticles()
        }
    }
}
