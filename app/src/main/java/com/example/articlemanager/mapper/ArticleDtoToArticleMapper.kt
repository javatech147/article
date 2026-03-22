package com.example.articlemanager.mapper

import com.example.articlemanager.presentation.model.Article
import com.example.articlemanager.data.model.ArticleDto

fun ArticleDto.toArticle(): Article {
    return Article(
        id = id,
        title = title,
        description = description,
        imageUrl = imageUrl
    )
}