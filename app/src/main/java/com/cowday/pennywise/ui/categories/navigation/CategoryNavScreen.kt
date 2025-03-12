package com.cowday.pennywise.ui.categories.navigation

import androidx.navigation.NavType
import androidx.navigation.navArgument


sealed interface CategoryNavScreen {
    val route: String
}

data object CategoryOverview: CategoryNavScreen {
    override val route: String = "Overview"
}

data object CategoryTransactions: CategoryNavScreen {
    override val route: String = "Transactions"
    const val categoryType = "categoryType"
    val routeWithArgs = "$route/{$categoryType}"
    val arguments = listOf(
        navArgument(categoryType) {
            type = NavType.StringType
        }
    )
}

data object CategoryAddTransaction: CategoryNavScreen {
    override val route: String = "Add Transaction"
    const val categoryType = "categoryType"
    val routeWithArgs = "$route/{$categoryType}"
    val arguments = listOf(
        navArgument(categoryType) {
            type = NavType.StringType
        }
    )
}
