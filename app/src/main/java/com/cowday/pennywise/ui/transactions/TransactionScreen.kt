package com.cowday.pennywise.ui.transactions

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.cowday.pennywise.data.TransactionType
import com.cowday.pennywise.ui.common.AppBar
import com.cowday.pennywise.ui.theme.PennywiseTheme

@Composable
fun TransactionScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.primary)
            .padding(top = 16.dp)
            .padding(horizontal = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AppBar("Transactions")
        TotalBalanceCard("34,656")
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            SubTransactionCard(
                transactionType = TransactionType.INCOME,
                amount = "43,245",
                modifier = Modifier.weight(1f)
            )
            SubTransactionCard(
                transactionType = TransactionType.EXPENSE,
                amount = "23,245",
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Preview
@Composable
private fun TransactionScreenPreview() {
    PennywiseTheme {
        TransactionScreen(NavController(LocalContext.current))
    }
}