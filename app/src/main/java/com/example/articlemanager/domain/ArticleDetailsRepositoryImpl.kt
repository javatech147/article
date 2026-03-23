package com.example.articlemanager.domain

import com.example.articlemanager.data.ArticleDetailsRepository
import com.example.articlemanager.data.local.ArticleDao
import com.example.articlemanager.mapper.toArticle
import com.example.articlemanager.presentation.model.Article
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ArticleDetailsRepositoryImpl(
    private val articleDao: ArticleDao
) : ArticleDetailsRepository {
    override suspend fun getArticleById(articleId: Int): Flow<Article?> {
        return articleDao.getArticleById(articleId = articleId).map { it?.toArticle() }
    }
}
