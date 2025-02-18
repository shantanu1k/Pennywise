package com.cowday.pennywise.ui.navigation

import com.cowday.pennywise.R

sealed interface PennywiseBottomNav {
    val icon: Int
    val route: String
}

data object HomeScreen: PennywiseBottomNav {
    override val icon: Int = R.drawable.icon_home
    override val route: String = PennywiseBottomNavScreen.HOME.route
}

data object AnalysisScreen: PennywiseBottomNav {
    override val icon: Int = R.drawable.icon_analysis
    override val route: String = PennywiseBottomNavScreen.ANALYSIS.route
}

data object TransactionScreen: PennywiseBottomNav {
    override val icon: Int = R.drawable.icon_transaction
    override val route: String = PennywiseBottomNavScreen.TRANSACTION.route
}

data object CategoryScreen: PennywiseBottomNav {
    override val icon: Int = R.drawable.icon_category
    override val route: String = PennywiseBottomNavScreen.CATEGORIES.route
}

data object ProfileScreen: PennywiseBottomNav {
    override val icon: Int = R.drawable.icon_profile
    override val route: String = PennywiseBottomNavScreen.PROFILE.route
}

enum class PennywiseBottomNavScreen(val route: String) {
    HOME("Home"),
    ANALYSIS("Analysis"),
    TRANSACTION("Transaction"),
    CATEGORIES("Categories"),
    PROFILE("Profile");
}