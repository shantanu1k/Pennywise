package com.cowday.pennywise.ui.transactions

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cowday.pennywise.R
import com.cowday.pennywise.data.ExpenseCategoryType
import com.cowday.pennywise.ui.homepage.HomePageTransactionHistoryItem

@Composable
fun TransactionHistory(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.surface)
            .padding(horizontal = 16.dp, vertical = 24.dp)
            .verticalScroll(state = rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LazyColumn {

        }
    }
}

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

@Preview
@Composable
private fun TransactionHistoryPreview(modifier: Modifier = Modifier) {
    TransactionHistory()
}