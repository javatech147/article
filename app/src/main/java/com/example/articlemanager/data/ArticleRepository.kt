package com.example.articlemanager.data

import com.example.articlemanager.presentation.model.Article
import com.example.articlemanager.data.MockArticleProvider

interface ArticleRepository {
    //    suspend fun getArticles(): List<Article> {
//        return MockArticleProvider.articles
//    }
    suspend fun getArticles(): List<Article>
}