package com.example.articlemanager.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "article")
data class ArticleEntity(
    @PrimaryKey val id: Int,
    val title: String,
    val description: String,
    val imageUrl: String?
)
