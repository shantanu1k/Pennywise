package com.cowday.pennywise.ui.categories.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.cowday.pennywise.ui.categories.screens.CategoryAddTransaction
import com.cowday.pennywise.ui.categories.screens.CategoryOverview
import com.cowday.pennywise.ui.categories.screens.CategoryTransactions

@Composable
fun CategoryNavGraph(
    modifier: Modifier,
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = CategoryOverview.route,
        modifier = modifier
    ) {
        composable(CategoryOverview.route) {
            CategoryOverview(navController)
        }
        composable(
            route = CategoryTransactions.routeWithArgs,
            arguments = CategoryTransactions.arguments
        ) {
            val categoryType = it.arguments?.getString(CategoryTransactions.categoryType)
            CategoryTransactions(navController, categoryType)
        }
        composable(
            route = CategoryAddTransaction.routeWithArgs,
            arguments = CategoryAddTransaction.arguments
        ) {
            val categoryType = it.arguments?.getString(CategoryAddTransaction.categoryType)
            CategoryAddTransaction(navController, categoryType)
        }
    }
}