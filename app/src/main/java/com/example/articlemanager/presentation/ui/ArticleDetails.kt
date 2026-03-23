package com.example.articlemanager.presentation.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.articlemanager.presentation.viewmodel.ArticleDetailsViewModel

@Composable
fun ArticleDetails(
    modifier: Modifier = Modifier,
    articleId: Int,
    articleDetailsViewModel: ArticleDetailsViewModel
) {

    LaunchedEffect(articleId) {
        // Code inside LaunchedEffect will execute only once or if the key(articleId) is changed.
        articleDetailsViewModel.getArticleById(articleId = articleId)
    }

    val article by articleDetailsViewModel.article.collectAsState()

    if (article == null) {
        Text(text = "loading..")
    } else {
        Column(modifier = modifier.padding(horizontal = 16.dp)) {
            Text(text = article?.title.orEmpty(), modifier = Modifier.padding(vertical = 8.dp))
            Text(
                text = article?.description.orEmpty(),
                modifier = Modifier.padding(vertical = 8.dp)
            )
        }
    }
}
