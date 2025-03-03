package com.cowday.pennywise.ui.transactions

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.cowday.pennywise.data.Transaction
import com.cowday.pennywise.data.TransactionType
import com.cowday.pennywise.ui.common.AppBar
import com.cowday.pennywise.ui.theme.PennywiseTheme

@Composable
fun TransactionScreen(
    navController: NavController,
    transactions: Map<String, List<Transaction>>
) {
    var selectedTab by remember { mutableStateOf<TransactionType?>(null) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.primary)
            .padding(top = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AppBar("Transactions")
        TotalBalanceCard(
            amount = "34,656",
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
        )
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            SubTransactionCard(
                onClick = {
                    selectedTab = if (selectedTab == TransactionType.INCOME) {
                        null
                    } else {
                        TransactionType.INCOME
                    }
                },
                isSelected = selectedTab == TransactionType.INCOME,
                transactionType = TransactionType.INCOME,
                amount = "43,245",
                modifier = Modifier.weight(1f)
            )
            SubTransactionCard(
                onClick = {
                    selectedTab = if (selectedTab == TransactionType.EXPENSE) {
                        null
                    } else {
                        TransactionType.EXPENSE
                    }
                },
                isSelected = selectedTab == TransactionType.EXPENSE,
                transactionType = TransactionType.EXPENSE,
                amount = "23,245",
                modifier = Modifier.weight(1f)
            )
        }
        Spacer(modifier = Modifier.height(24.dp))
        TransactionHistory(
            transactionMap = transactions,
            modifier = Modifier.clip(
                RoundedCornerShape(
                    topStartPercent = 10,
                    topEndPercent = 10
                )
            )
        )
    }
}

@Preview
@Composable
private fun TransactionScreenPreview() {
    PennywiseTheme {
        TransactionScreen(
            NavController(LocalContext.current),
            mapOf()
        )
    }
}