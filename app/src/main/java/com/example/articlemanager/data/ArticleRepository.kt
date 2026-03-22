package com.example.articlemanager.data

import com.example.articlemanager.presentation.model.Article
import kotlinx.coroutines.flow.Flow

interface ArticleRepository {
    suspend fun observeArticles(): Flow<List<Article>>

    suspend fun getArticles()
}
