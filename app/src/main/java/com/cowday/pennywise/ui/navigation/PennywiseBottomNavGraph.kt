package com.cowday.pennywise.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.cowday.pennywise.ui.analysis.AnalysisScreen
import com.cowday.pennywise.ui.categories.CategoryScreen
import com.cowday.pennywise.ui.homepage.HomeScreen
import com.cowday.pennywise.ui.profile.ProfileScreen
import com.cowday.pennywise.ui.transactions.TransactionScreen

@Composable
fun PennywiseBottomNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = PennywiseBottomNavScreen.HOME.route,
    ) {
        composable(route = PennywiseBottomNavScreen.HOME.route) {
            HomeScreen()
        }
        composable(route = PennywiseBottomNavScreen.ANALYSIS.route) {
            AnalysisScreen(navController)
        }
        composable(route = PennywiseBottomNavScreen.TRANSACTION.route) {
            TransactionScreen(navController)
        }
        composable(route = PennywiseBottomNavScreen.CATEGORIES.route) {
            CategoryScreen(navController)
        }
        composable(route = PennywiseBottomNavScreen.PROFILE.route) {
            ProfileScreen(navController)
        }
    }
}