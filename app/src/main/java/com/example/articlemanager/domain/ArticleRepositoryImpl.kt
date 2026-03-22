package com.example.articlemanager.domain

import com.example.articlemanager.presentation.model.Article
import com.example.articlemanager.data.ArticleRepository
import com.example.articlemanager.data.remote.ApiService
import com.example.articlemanager.mapper.toArticle

class ArticleRepositoryImpl(
    private val apiService: ApiService
) : ArticleRepository {
    override suspend fun getArticles(): List<Article> {
        return apiService.getArticles().map { it.toArticle() }
    }
}
