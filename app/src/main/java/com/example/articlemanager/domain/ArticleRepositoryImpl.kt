package com.example.articlemanager.domain

import com.example.articlemanager.data.ArticleRepository
import com.example.articlemanager.data.local.ArticleDao
import com.example.articlemanager.data.local.ArticleEntity
import com.example.articlemanager.data.remote.ApiService
import com.example.articlemanager.mapper.toArticle
import com.example.articlemanager.mapper.toArticleEntity
import com.example.articlemanager.presentation.model.Article
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ArticleRepositoryImpl(
    private val apiService: ApiService,
    private val articleDao: ArticleDao
) : ArticleRepository {

    override suspend fun observeArticles(): Flow<List<Article>> {
        return articleDao.getAllArticles().map { entities ->
            entities.map { it.toArticle() }
        }
    }

    override suspend fun getArticles() {
        val articles: List<ArticleEntity> = apiService.getArticles().map { it.toArticleEntity() }
        articleDao.insertArticles(articles)
    }
}
