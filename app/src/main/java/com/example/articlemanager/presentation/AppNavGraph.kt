package com.example.articlemanager.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.articlemanager.di.AppContainer
import com.example.articlemanager.presentation.ui.ArticleDetails
import com.example.articlemanager.presentation.ui.ArticleListScreen
import com.example.articlemanager.presentation.viewmodel.ArticleDetailsViewModel
import com.example.articlemanager.presentation.viewmodel.ArticleDetailsViewModelFactory
import com.example.articlemanager.presentation.viewmodel.ArticleListViewModel
import com.example.articlemanager.presentation.viewmodel.ArticleListViewModelFactory

@Composable
fun AppNavGraph(appContainer: AppContainer, modifier: Modifier) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.ArticleListScreen.route) {
        composable(Screen.ArticleListScreen.route) {
            val articleListViewModelFactory =
                ArticleListViewModelFactory(articleRepository = appContainer.articleRepository)
            val articleListViewModel: ArticleListViewModel = viewModel(
                factory = articleListViewModelFactory
            )
            ArticleListScreen(
                modifier = modifier,
                articleListViewModel = articleListViewModel,
                onArticleClick = { articleId ->
                    navController.navigate(route = Screen.ArticleDetailsScreen.createRoute(articleId = articleId))
                })
        }

        composable(Screen.ArticleDetailsScreen.route) { backStackEntry ->
            val articleDetailsViewModelFactory =
                ArticleDetailsViewModelFactory(articleDetailsRepository = appContainer.articleDetailsRepository)
            val articleDetailsViewModel: ArticleDetailsViewModel = viewModel(
                factory = articleDetailsViewModelFactory
            )

            val articleId = backStackEntry.arguments?.getInt("article_id") ?: 0

            ArticleDetails(
                modifier = modifier,
                articleId = articleId,
                articleDetailsViewModel = articleDetailsViewModel
            )
        }
    }
}
