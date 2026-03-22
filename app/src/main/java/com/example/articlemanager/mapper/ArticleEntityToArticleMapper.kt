package com.example.articlemanager.mapper

import com.example.articlemanager.data.local.ArticleEntity
import com.example.articlemanager.presentation.model.Article

fun ArticleEntity.toArticle(): Article {
    return Article(
        id = id,
        title = title,
        description = description,
        imageUrl = imageUrl
    )
}
