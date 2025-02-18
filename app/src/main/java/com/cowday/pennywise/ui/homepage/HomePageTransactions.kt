package com.cowday.pennywise.ui.homepage

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cowday.pennywise.R
import com.cowday.pennywise.data.CategoryType
import com.cowday.pennywise.data.ExpenseCategoryType
import com.cowday.pennywise.ui.theme.darkBlue
import com.cowday.pennywise.ui.theme.green

@Composable
fun HomePageTransactions(
    icon: Int,
    category: CategoryType,
    timestamp: String,
    transactionName: String,
    amount: String,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        TransactionLogo(icon = icon)
        Spacer(modifier = Modifier.width(2.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Max),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Column(
                modifier = Modifier.weight(1.5f)
            ) {
                Text(
                    text = category.getStrValue(),
                    style = MaterialTheme.typography.titleSmall,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1
                )
                Text(
                    text = timestamp,
                    style = MaterialTheme.typography.bodyLarge,
                    color = darkBlue,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1
                )
            }
            Spacer(
                modifier = Modifier
                    .fillMaxHeight()
                    .background(color = green)
                    .width(1.dp)
            )
            Text(
                modifier = Modifier.weight(1f),
                text = transactionName,
                style = MaterialTheme.typography.labelLarge,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1
            )
            Spacer(
                modifier = Modifier
                    .fillMaxHeight()
                    .background(color = green)
                    .width(1.dp)
            )
            Text(
                modifier = Modifier.weight(1f),
                text = if (category is ExpenseCategoryType) {
                    "-$$amount"
                } else {
                    "$$amount"
                },
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}

@Preview
@Composable
fun HomePageTransactionsPreview(modifier: Modifier = Modifier) {
    Surface {
        HomePageTransactions(
            icon = R.drawable.icon_rent,
            amount = "3,222",
            transactionName = "Monthly rent".repeat(3),
            timestamp = "16:06 - April 23",
            category = ExpenseCategoryType.RENT
        )
    }
}