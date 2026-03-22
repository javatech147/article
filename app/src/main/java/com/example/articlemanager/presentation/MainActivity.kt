package com.example.articlemanager.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.articlemanager.data.local.ArticleDB
import com.example.articlemanager.data.remote.ApiService
import com.example.articlemanager.data.remote.KtorClient
import com.example.articlemanager.domain.ArticleRepositoryImpl
import com.example.articlemanager.presentation.theme.ArticleManagerTheme
import com.example.articlemanager.presentation.ui.ArticleListScreen
import com.example.articlemanager.presentation.viewmodel.ArticleListViewModel
import com.example.articlemanager.presentation.viewmodel.ArticleListViewModelFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArticleManagerTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    // Manual DI
                    val ktorClient = KtorClient
                    val apiService = ApiService(ktorClient)

                    val articleDb = ArticleDB.getInstance(context = this)
                    val articleRepositoryImpl = ArticleRepositoryImpl(
                        apiService = apiService,
                        articleDao = articleDb.getDao()
                    )

                    val articleListViewModelFactory =
                        ArticleListViewModelFactory(articleRepositoryImpl = articleRepositoryImpl)
                    val articleViewModel by viewModels<ArticleListViewModel> { articleListViewModelFactory }


                    ArticleListScreen(
                        modifier = Modifier.padding(innerPadding),
                        articleListViewModel = articleViewModel
                    )
                }
            }
        }
    }
}
