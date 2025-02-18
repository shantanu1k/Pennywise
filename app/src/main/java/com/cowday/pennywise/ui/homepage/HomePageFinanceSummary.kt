package com.cowday.pennywise.ui.homepage

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cowday.pennywise.R
import com.cowday.pennywise.ui.theme.PennywiseTheme
import com.cowday.pennywise.ui.theme.lightGreen

@Composable
fun HomePageFinanceSummary(
    modifier: Modifier = Modifier,
    income: String,
    expense: String,
) {
    Box(
        modifier = modifier
            .height(IntrinsicSize.Min)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            FinanceSummaryItemLabel(
                icon = R.drawable.income_monochrome,
                label = R.string.total_income,
                amount = "$$income"
            )
            Spacer(
                modifier = Modifier
                    .fillMaxHeight(fraction = 0.8f)
                    .background(color = lightGreen)
                    .width(1.dp)
            )
            FinanceSummaryItemLabel(
                icon = R.drawable.expense_monochrome,
                label = R.string.total_expense,
                amount = "-$$expense"
            )
        }
    }
}

@Composable
fun FinanceSummaryItemLabel(
    icon: Int,
    label: Int,
    amount: String,
) {
    Column(
        modifier = Modifier
            .padding(horizontal = 32.dp, vertical = 4.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(2.dp)
        ) {
            Icon(
                painter = painterResource(icon),
                contentDescription = null
            )
            Text(
                text = stringResource(label),
                style = MaterialTheme.typography.bodyLarge
            )
        }
        Text(
            text = amount,
            style = MaterialTheme.typography.titleMedium,
            color = Color.White
        )
    }
}

@Preview
@Composable
fun FinanceSummaryPreview() {
    PennywiseTheme {
        HomePageFinanceSummary(
            modifier = Modifier
                .background(color = MaterialTheme.colorScheme.primary),
            "3,222,111",
            "58,308",
        )
    }
}