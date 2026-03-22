package com.example.articlemanager.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.articlemanager.domain.ArticleRepositoryImpl
import com.example.articlemanager.presentation.model.Article

@Composable
fun MyApp(
    modifier: Modifier,
    articleRepository: ArticleRepositoryImpl
) {
    val articles = remember { mutableStateOf<List<Article>>(emptyList()) }
    LaunchedEffect(Unit) {
        articles.value = articleRepository.getArticles()
    }

    LazyColumn(modifier = modifier) {
        items(items = articles.value) { article ->
            ItemArticle(article = article)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ItemArticle(article: Article? = null) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = article?.title.orEmpty(),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        )

        Text(
            text = article?.description.orEmpty(),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        )
    }
}
