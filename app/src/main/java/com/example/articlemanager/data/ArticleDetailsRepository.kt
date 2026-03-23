package com.example.articlemanager.data

import com.example.articlemanager.presentation.model.Article
import kotlinx.coroutines.flow.Flow

interface ArticleDetailsRepository {
    suspend fun getArticleById(articleId: Int): Flow<Article?>
}
