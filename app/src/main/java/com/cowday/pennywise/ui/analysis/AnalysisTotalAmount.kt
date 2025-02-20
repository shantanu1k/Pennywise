package com.cowday.pennywise.ui.analysis

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cowday.pennywise.R
import com.cowday.pennywise.data.TransactionType
import com.cowday.pennywise.ui.theme.PennywiseTheme

@Composable
fun AnalysisTotalAmount() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AnalysisTotalAmountItem(
            modifier = Modifier.weight(1f),
            icon = R.drawable.income_monochrome,
            transactionType = TransactionType.INCOME,
            amount = "2,31,534"
        )
        AnalysisTotalAmountItem(
            modifier = Modifier.weight(1f),
            icon = R.drawable.expense_monochrome,
            transactionType = TransactionType.EXPENSE,
            amount = "7,543"
        )
    }
}

@Preview
@Composable
fun AnalysisTotalAmountPreview() {
    PennywiseTheme {
        Surface {
            AnalysisTotalAmount()
        }
    }
}