package com.example.articlemanager.presentation.model

data class Article(
    val id: Int,
    val title: String,
    val description: String,
    val imageUrl: String?
)