package com.cowday.pennywise.ui.analysis

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cowday.pennywise.R
import com.cowday.pennywise.data.TransactionType
import com.cowday.pennywise.ui.theme.PennywiseTheme
import com.cowday.pennywise.ui.theme.darkBlue
import com.cowday.pennywise.ui.theme.green

@Composable
fun AnalysisTotalAmountItem(
    icon: Int,
    transactionType: TransactionType,
    amount: String,
    modifier: Modifier = Modifier,
) {
    val iconTint = if (transactionType == TransactionType.EXPENSE) {
        darkBlue
    } else {
        green
    }

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            modifier = Modifier.size(40.dp),
            tint = iconTint,
            painter = painterResource(icon),
            contentDescription = null
        )
        Text(
            modifier = Modifier,
            text = transactionType.strValue,
            style = MaterialTheme.typography.labelLarge
        )
        Text(
            modifier = Modifier,
            text = "$$amount",
            style = MaterialTheme.typography.titleMedium
        )
    }
}

@Preview
@Composable
fun AnalysisTotalAmountItemPreview() {
    PennywiseTheme {
        Row {
            Surface {
                AnalysisTotalAmountItem(
                    icon = R.drawable.income_monochrome,
                    transactionType = TransactionType.INCOME,
                    "1,222"
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
            Surface {
                AnalysisTotalAmountItem(
                    icon = R.drawable.expense_monochrome,
                    transactionType = TransactionType.EXPENSE,
                    "1,222"
                )
            }
        }
    }
}