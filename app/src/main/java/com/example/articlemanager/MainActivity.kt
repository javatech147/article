package com.example.articlemanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.articlemanager.data.remote.ApiService
import com.example.articlemanager.data.remote.KtorClient
import com.example.articlemanager.domain.ArticleRepositoryImpl
import com.example.articlemanager.ui.theme.ArticleManagerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArticleManagerTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val ktorClient = KtorClient
                    val apiService = ApiService(ktorClient)
                    val articleRepository = ArticleRepositoryImpl(apiService)

                    MyApp(
                        modifier = Modifier.padding(innerPadding),
                        articleRepository = articleRepository
                    )
                }
            }
        }
    }
}
