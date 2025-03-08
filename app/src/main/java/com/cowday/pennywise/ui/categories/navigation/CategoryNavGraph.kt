package com.cowday.pennywise.ui.categories.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.cowday.pennywise.ui.categories.screens.CategoryOverview
import com.cowday.pennywise.ui.categories.screens.CategoryTransactions

@Composable
fun CategoryNavGraph(
    modifier: Modifier,
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = CategoryNavScreen.OVERVIEW.route,
        modifier = modifier
    ) {
        composable(CategoryNavScreen.OVERVIEW.route) {
            CategoryOverview(navController)
        }
        composable(CategoryNavScreen.TRANSACTIONS.route) {
            CategoryTransactions(navController)
        }
        composable(CategoryNavScreen.ADD_TRANSACTION.route) {
            CategoryTransactions(navController)
        }
    }
}