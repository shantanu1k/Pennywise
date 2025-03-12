package com.cowday.pennywise.ui.categories.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.cowday.pennywise.data.ExpenseCategoryType
import com.cowday.pennywise.data.IncomeCategoryType
import com.cowday.pennywise.data.Transaction
import com.cowday.pennywise.data.TransactionType
import com.cowday.pennywise.data.groupTransactionByDate
import com.cowday.pennywise.ui.common.CustomButton
import com.cowday.pennywise.ui.theme.PennywiseTheme
import com.cowday.pennywise.ui.transactions.TransactionHistory
import java.math.BigDecimal

@Composable
fun CategoryTransactions(
    navController: NavController,
    categoryType: String? = null
) {
    val transactions by remember {
        mutableStateOf(
            listOf(
                Transaction("John Doe", "2025-02-01T14:30:00.000+0000", BigDecimal(50.75), "Grocery Shopping", ExpenseCategoryType.GROCERIES, "Purchased fruits and vegetables", TransactionType.EXPENSE),
                Transaction("Jane Smith", "2025-02-02T14:30:00.000+0000", BigDecimal(20.00), "Bus Ticket", ExpenseCategoryType.TRANSPORT, "Monthly bus pass", TransactionType.EXPENSE),
                Transaction("Mike Johnson", "2025-04-03T14:30:00.000+0000", BigDecimal(100.50), "Concert Ticket", ExpenseCategoryType.ENTERTAINMENT, "Bought tickets for the concert", TransactionType.EXPENSE),
                Transaction("Sarah Lee", "2025-04-04T14:30:00.000+0000", BigDecimal(200.00), "Electric Bill", ExpenseCategoryType.RENT, "Paid monthly electricity bill", TransactionType.EXPENSE),
                Transaction("David Miller", "2025-06-05T14:30:00.000+0000", BigDecimal(150.00), "Gym Membership", ExpenseCategoryType.MEDICINE, "Annual gym membership renewal", TransactionType.EXPENSE),
                Transaction("Emily Davis", "2025-06-06T14:30:00.000+0000", BigDecimal(75.00), "Clothing Store", ExpenseCategoryType.GIFTS, "Bought a new jacket", TransactionType.EXPENSE),
                Transaction("John Doe", "2025-11-07T14:30:00.000+0000", BigDecimal(500.00), "Salary", ExpenseCategoryType.MEDICINE, "Monthly salary received", TransactionType.EXPENSE),
                Transaction("Anna Brown", "2025-11-08T14:30:00.000+0000", BigDecimal(40.00), "Takeout Dinner", ExpenseCategoryType.FOOD, "Ordered dinner from a restaurant", TransactionType.EXPENSE),
                Transaction("Chris Wilson", "2025-08-09T14:30:00.000+0000", BigDecimal(30.00), "Taxi Fare", ExpenseCategoryType.TRANSPORT, "Taxi fare to the airport", TransactionType.EXPENSE),
                Transaction("Laura Harris", "2025-08-10T14:30:00.000+0000", BigDecimal(200.00), "Medical Checkup", ExpenseCategoryType.MEDICINE, "Routine medical checkup", TransactionType.EXPENSE)
            )
        )
    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TransactionHistory(
            groupTransactionByDate(transactions),
            modifier = Modifier.fillMaxHeight(0.9f)
        )
        Spacer(modifier = Modifier.height(16.dp))
        CustomButton("Add a transaction") { }
    }
}

@Preview
@Composable
private fun CategoryTransactionsPreview() {
    PennywiseTheme {
        Surface {
            CategoryTransactions(NavController(LocalContext.current), IncomeCategoryType.SALARY.getStrValue())
        }
    }
}