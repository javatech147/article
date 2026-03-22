package com.example.articlemanager.mapper

import com.example.articlemanager.data.local.ArticleEntity
import com.example.articlemanager.presentation.model.Article
import com.example.articlemanager.data.model.ArticleDto

fun ArticleDto.toArticleEntity(): ArticleEntity {
    return ArticleEntity(
        id = id,
        title = title,
        description = description,
        imageUrl = imageUrl
    )
}