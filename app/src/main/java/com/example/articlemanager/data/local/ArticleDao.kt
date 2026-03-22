package com.example.articlemanager.data.local

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface ArticleDao {

    @Query("SELECT * FROM article")
    fun getAllArticles(): Flow<List<ArticleEntity>>

    @Upsert
    suspend fun insertArticles(articles: List<ArticleEntity>)

    @Query("DELETE FROM article")
    suspend fun deleteAllArticles()
}
