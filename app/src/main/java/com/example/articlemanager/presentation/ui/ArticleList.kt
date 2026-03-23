package com.example.articlemanager.presentation.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.articlemanager.presentation.model.Article
import com.example.articlemanager.presentation.viewmodel.ArticleListViewModel

@Composable
fun ArticleListScreen(
    modifier: Modifier = Modifier,
    articleListViewModel: ArticleListViewModel,
    onArticleClick: (Int) -> Unit
) {
    val articles = articleListViewModel.articles.collectAsState()
    LazyColumn(modifier = modifier) {
        items(items = articles.value) { article ->
            ItemArticle(article = article, onItemClick = onArticleClick)
        }
    }
}

@Composable
fun ItemArticle(
    article: Article,
    onItemClick: (Int) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .clickable { onItemClick(article.id) }
            .padding(vertical = 12.dp),
    ) {
        Text(
            text = article.title.orEmpty(),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        )

        Text(
            text = article.description.orEmpty(),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        )
    }
}
