package com.cowday.pennywise.ui.homepage

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.cowday.pennywise.ui.common.BottomNavigationItem
import com.cowday.pennywise.ui.navigation.AnalysisScreen
import com.cowday.pennywise.ui.navigation.CategoryScreen
import com.cowday.pennywise.ui.navigation.HomeScreen
import com.cowday.pennywise.ui.navigation.PennywiseBottomNav
import com.cowday.pennywise.ui.navigation.PennywiseBottomNavScreen
import com.cowday.pennywise.ui.navigation.ProfileScreen
import com.cowday.pennywise.ui.navigation.TransactionScreen
import com.cowday.pennywise.ui.theme.PennywiseTheme
import com.cowday.pennywise.ui.theme.Typography
import com.cowday.pennywise.ui.theme.green
import com.cowday.pennywise.ui.theme.poppinsFontFamily

@Composable
fun HomeScreen() {
    val navController = rememberNavController()
    val selectedTab = remember { mutableStateOf<PennywiseBottomNav>(HomeScreen) }
    PennywiseTheme {
        Scaffold(
            topBar = {
                WelcomeText()
            },
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
                        },
                        modifier = Modifier.weight(1f),
                        isSelected = selectedTab.value == HomeScreen
                    )
                    BottomNavigationItem(
                        icon = AnalysisScreen.icon,
                        onClick = {
                            selectedTab.value = AnalysisScreen
                        },
                        modifier = Modifier
                            .weight(1f),
                        isSelected = selectedTab.value == AnalysisScreen
                    )
                    BottomNavigationItem(
                        icon = TransactionScreen.icon,
                        onClick = {
                            selectedTab.value = TransactionScreen
                        },
                        modifier = Modifier
                            .weight(1f),
                        isSelected = selectedTab.value == TransactionScreen
                    )
                    BottomNavigationItem(
                        icon = CategoryScreen.icon,
                        onClick = {
                            selectedTab.value = CategoryScreen
                        },
                        modifier = Modifier
                            .weight(1f),
                        isSelected = selectedTab.value == CategoryScreen
                    )
                    BottomNavigationItem(
                        icon = ProfileScreen.icon,
                        onClick = {
                            selectedTab.value = ProfileScreen
                        },
                        modifier = Modifier
                            .weight(1f),
                        isSelected = selectedTab.value == ProfileScreen
                    )
                }
            },
            modifier = Modifier.fillMaxSize()
        ) { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
                    .background(color = MaterialTheme.colorScheme.primary)
                    .padding(top = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                FinanceSummary()
                Spacer(modifier = Modifier.height(32.dp))
                HomePageTransactionHistory(
                    modifier = Modifier
                        .clip(
                            RoundedCornerShape(
                                topStartPercent = 10,
                                topEndPercent = 10
                            )
                        )
                )
            }
        }
    }
}

@Composable
fun WelcomeText(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(color = MaterialTheme.colorScheme.primary)
            .padding(16.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = "Hi, Welcome back",
            style = Typography.titleSmall
        )
        Text(
            text = "Good Morning",
            style = Typography.labelSmall
        )
    }
}

@Composable
fun FinanceSummary() {
    HomePageFinanceSummary(
        income = "2,365,565",
        expense = "4,333"
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PennywiseTheme {
        HomeScreen()
    }
}