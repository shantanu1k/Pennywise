package com.cowday.pennywise.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.cowday.pennywise.ui.common.BottomNavigationItem
import com.cowday.pennywise.ui.homepage.HomeScreen
import com.cowday.pennywise.ui.navigation.AnalysisScreen
import com.cowday.pennywise.ui.navigation.CategoryScreen
import com.cowday.pennywise.ui.navigation.HomeScreen
import com.cowday.pennywise.ui.navigation.PennywiseBottomNav
import com.cowday.pennywise.ui.navigation.PennywiseBottomNavGraph
import com.cowday.pennywise.ui.navigation.ProfileScreen
import com.cowday.pennywise.ui.navigation.TransactionScreen
import com.cowday.pennywise.ui.theme.PennywiseTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val selectedTab = remember { mutableStateOf<PennywiseBottomNav>(HomeScreen) }
            PennywiseTheme {
                Scaffold(
                    bottomBar = {
                        BottomAppBar(
                            modifier = Modifier
                                .clip(
                                    RoundedCornerShape(
                                        topStartPercent = 50,
                                        topEndPercent = 50
                                    )
                                ),
                            contentPadding = PaddingValues(horizontal = 24.dp),
                            containerColor = MaterialTheme.colorScheme.tertiary,
                        ) {
                            BottomNavigationItem(
                                icon = HomeScreen.icon,
                                onClick = {
                                    selectedTab.value = HomeScreen
                                    navController.navigate(HomeScreen.route)
                                },
                                modifier = Modifier.weight(1f),
                                isSelected = selectedTab.value == HomeScreen
                            )
                            BottomNavigationItem(
                                icon = AnalysisScreen.icon,
                                onClick = {
                                    selectedTab.value = AnalysisScreen
                                    navController.navigate(AnalysisScreen.route)
                                },
                                modifier = Modifier
                                    .weight(1f),
                                isSelected = selectedTab.value == AnalysisScreen
                            )
                            BottomNavigationItem(
                                icon = TransactionScreen.icon,
                                onClick = {
                                    selectedTab.value = TransactionScreen
                                    navController.navigate(TransactionScreen.route)
                                },
                                modifier = Modifier
                                    .weight(1f),
                                isSelected = selectedTab.value == TransactionScreen
                            )
                            BottomNavigationItem(
                                icon = CategoryScreen.icon,
                                onClick = {
                                    selectedTab.value = CategoryScreen
                                    navController.navigate(CategoryScreen.route)
                                },
                                modifier = Modifier
                                    .weight(1f),
                                isSelected = selectedTab.value == CategoryScreen
                            )
                            BottomNavigationItem(
                                icon = ProfileScreen.icon,
                                onClick = {
                                    selectedTab.value = ProfileScreen
                                    navController.navigate(ProfileScreen.route)
                                },
                                modifier = Modifier
                                    .weight(1f),
                                isSelected = selectedTab.value == ProfileScreen
                            )
                        }
                    },
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    PennywiseBottomNavGraph(Modifier.padding(innerPadding), navController)
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PennywiseTheme {
        HomeScreen()
    }
}