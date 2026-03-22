package com.example.articlemanager.data.remote

import com.example.articlemanager.data.model.ArticleDto
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter

class ApiService(
    private val ktorClient: KtorClient
) {

    suspend fun getArticles(): List<ArticleDto> {
        return ktorClient.client.get(GET_ARTICLES) {
            parameter("per_page", 10)
        }.body()
    }

    companion object {
        private const val GET_ARTICLES = "https://dev.to/api/articles"
    }
}
