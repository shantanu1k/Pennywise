package com.cowday.pennywise.ui.homepage

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cowday.pennywise.ui.theme.PennywiseTheme
import com.cowday.pennywise.ui.theme.Typography
import com.cowday.pennywise.ui.theme.poppinsFontFamily

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    PennywiseTheme {
        Scaffold(
            topBar = {
                WelcomeText()
            },
            modifier = Modifier.fillMaxSize()
        ) { innerPadding ->
            Column(
                modifier = modifier
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

@Preview
@Composable
fun WelcomeTextPreview() {
    HomeScreen()
}