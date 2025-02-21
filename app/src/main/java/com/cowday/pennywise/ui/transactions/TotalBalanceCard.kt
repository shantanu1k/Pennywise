package com.cowday.pennywise.ui.transactions

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cowday.pennywise.ui.theme.PennywiseTheme
import com.cowday.pennywise.ui.theme.honeyDew

@Composable
fun TotalBalanceCard(
    amount: String
) {
    Box(
        modifier = Modifier
            .padding(8.dp)
            .clip(
                RoundedCornerShape(percent = 10)
            )
            .fillMaxWidth()
            .background(color = honeyDew),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(vertical = 16.dp)
        ) {
            Text(
                text = "Total Balance",
                style = MaterialTheme.typography.bodySmall
            )
            Text(
                text = "$$amount",
                style = MaterialTheme.typography.titleSmall
            )
        }
    }
}

@Preview
@Composable
private fun TotalBalanceCardPreview(modifier: Modifier = Modifier) {
    PennywiseTheme {
        TotalBalanceCard("23,756")
    }
}