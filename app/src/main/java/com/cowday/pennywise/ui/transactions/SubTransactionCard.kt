package com.cowday.pennywise.ui.transactions

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cowday.pennywise.R
import com.cowday.pennywise.data.TransactionType
import com.cowday.pennywise.ui.theme.PennywiseTheme
import com.cowday.pennywise.ui.theme.honeyDew

@Composable
fun SubTransactionCard(
    transactionType: TransactionType,
    amount: String,
    modifier: Modifier = Modifier,
) {
    val icon = if (transactionType == TransactionType.INCOME) {
        R.drawable.income_monochrome
    } else {
        R.drawable.expense_monochrome
    }
    Box(
        modifier = modifier
            .padding(8.dp)
            .clip(
                RoundedCornerShape(percent = 10)
            )
            .background(color = honeyDew),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(vertical = 16.dp)
        ) {
            Icon(
                modifier = Modifier
                    .size(40.dp),
                painter = painterResource(icon),
                contentDescription = null
            )
            Text(
                text = transactionType.strValue,
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
private fun SubTransactionCardPreview() {
    PennywiseTheme {
        SubTransactionCard(
            transactionType = TransactionType.INCOME,
            amount = "43,111"
        )
    }
}