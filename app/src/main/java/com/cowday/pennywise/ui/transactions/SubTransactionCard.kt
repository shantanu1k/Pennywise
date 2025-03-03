package com.cowday.pennywise.ui.transactions

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cowday.pennywise.R
import com.cowday.pennywise.data.TransactionType
import com.cowday.pennywise.ui.theme.PennywiseTheme
import com.cowday.pennywise.ui.theme.darkBlue
import com.cowday.pennywise.ui.theme.honeyDew

@Composable
fun SubTransactionCard(
    isSelected: Boolean,
    transactionType: TransactionType,
    amount: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val icon = if (transactionType == TransactionType.INCOME) {
        R.drawable.income_monochrome
    } else {
        R.drawable.expense_monochrome
    }

    val backgroundColor = if (isSelected) {
        darkBlue
    } else {
        honeyDew
    }

    val contentColor = if (isSelected) {
        Color.White
    } else {
        Color.Black
    }
    Box(
        modifier = modifier
            .clip(
                RoundedCornerShape(percent = 10)
            )
            .background(color = backgroundColor)
            .padding(8.dp)
            .clickable(
                indication = null,
                interactionSource = null,
                onClick = onClick,
            ),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(2.dp),
            modifier = Modifier.padding(vertical = 8.dp)
        ) {
            Icon(
                modifier = Modifier
                    .size(40.dp),
                painter = painterResource(icon),
                tint = contentColor,
                contentDescription = null
            )
            Text(
                text = transactionType.strValue,
                style = MaterialTheme.typography.bodySmall,
                color = contentColor
            )
            Text(
                text = "$$amount",
                style = MaterialTheme.typography.titleSmall,
                color = contentColor
            )
        }
    }
}

@Preview
@Composable
private fun SubTransactionCardPreview() {
    PennywiseTheme {
        SubTransactionCard(
            onClick = {},
            isSelected = true,
            transactionType = TransactionType.INCOME,
            amount = "43,111"
        )
    }
}