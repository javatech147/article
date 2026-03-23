package com.example.articlemanager.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.articlemanager.data.ArticleDetailsRepository

class ArticleDetailsViewModelFactory(
    private val articleDetailsRepository: ArticleDetailsRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ArticleDetailsViewModel(articleDetailsRepository) as T
    }
}
