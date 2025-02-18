package com.cowday.pennywise.ui.homepage

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cowday.pennywise.R
import com.cowday.pennywise.data.CategoryType
import com.cowday.pennywise.data.ExpenseCategoryType
import com.cowday.pennywise.ui.common.Duration
import com.cowday.pennywise.ui.common.DurationRangeSwitcher

@Composable
fun HomePageTransactionHistory(
    modifier: Modifier = Modifier,
    transactions: List<HomePageTransactionHistoryItem> = homePageTransactionHistory
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.surface)
    ) {
        Column(
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            DurationRangeSwitcher(
                durationRange = setOf(
                    Duration.DAILY, Duration.WEEKLY, Duration.MONTHLY
                ),
                selectedDuration = Duration.DAILY
            )

            Spacer(modifier = Modifier.height(16.dp))

            transactions.forEach {
                HomePageTransactions(
                    icon = it.icon,
                    category = it.category,
                    timestamp = it.timestamp,
                    transactionName = it.transactionName,
                    amount = it.amount
                )
                Spacer(modifier = Modifier.height(4.dp))
            }
        }
    }
}

@Preview
@Composable
fun HomePageTransactionHistoryPreview(modifier: Modifier = Modifier) {
    HomePageTransactionHistory()
}

data class HomePageTransactionHistoryItem(
    val icon: Int,
    val category: CategoryType,
    val timestamp: String,
    val transactionName: String,
    val amount: String,
)

val homePageTransactionHistory = listOf(
    HomePageTransactionHistoryItem(
        icon = R.drawable.icon_gift,
        category = ExpenseCategoryType.GIFTS,
        timestamp = "12:01, Dec 4",
        transactionName = "A Gift",
        amount = "324"
    ),
    HomePageTransactionHistoryItem(
        icon = R.drawable.icon_medicine,
        category = ExpenseCategoryType.MEDICINE,
        timestamp = "10:44, Sept 30",
        transactionName = "Paracetamol",
        amount = "20"
    ),
    HomePageTransactionHistoryItem(
        icon = R.drawable.icon_transport,
        category = ExpenseCategoryType.TRANSPORT,
        timestamp = "3:19, Jan 17",
        transactionName = "Bus",
        amount = "16"
    )
)
