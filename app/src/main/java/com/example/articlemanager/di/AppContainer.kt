package com.example.articlemanager.di

import android.content.Context
import com.example.articlemanager.data.ArticleDetailsRepository
import com.example.articlemanager.data.ArticleRepository
import com.example.articlemanager.data.local.ArticleDB
import com.example.articlemanager.data.remote.ApiService
import com.example.articlemanager.data.remote.KtorClient
import com.example.articlemanager.domain.ArticleDetailsRepositoryImpl
import com.example.articlemanager.domain.ArticleRepositoryImpl

class AppContainer(context: Context) {

    private val database = ArticleDB.getInstance(context)
    private val dao = database.getDao()

    private val ktorClient = KtorClient
    private val apiService = ApiService(ktorClient)

    val articleRepository: ArticleRepository =
        ArticleRepositoryImpl(apiService, dao)

    val articleDetailsRepository: ArticleDetailsRepository =
        ArticleDetailsRepositoryImpl(dao)
}
