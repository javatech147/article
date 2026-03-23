package com.example.articlemanager.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.articlemanager.di.AppContainer
import com.example.articlemanager.presentation.theme.ArticleManagerTheme

class MainActivity : ComponentActivity() {
    val appContainer by lazy {
        AppContainer(applicationContext)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArticleManagerTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    AppNavGraph(
                        appContainer = appContainer,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

sealed class Screen(val route: String) {
    object ArticleListScreen : Screen("article_list")
    object ArticleDetailsScreen : Screen("article_details/{article_id}") {
        fun createRoute(articleId: Int) = "article_details/$articleId"
    }
}
