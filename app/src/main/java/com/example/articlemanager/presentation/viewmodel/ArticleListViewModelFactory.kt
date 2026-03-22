package com.example.articlemanager.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.articlemanager.domain.ArticleRepositoryImpl

class ArticleListViewModelFactory(
    private val articleRepositoryImpl: ArticleRepositoryImpl
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ArticleListViewModel(articleRepositoryImpl) as T
    }
}
