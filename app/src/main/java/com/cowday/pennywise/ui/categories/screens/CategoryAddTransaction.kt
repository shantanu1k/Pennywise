package com.cowday.pennywise.ui.categories.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.cowday.pennywise.ui.common.CalendarButton
import com.cowday.pennywise.ui.common.CustomButton
import com.cowday.pennywise.ui.common.CustomTextInputField
import com.cowday.pennywise.ui.theme.PennywiseTheme

@Composable
fun CategoryAddTransaction(
    navController: NavController,
    categoryType: String? = null
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        CustomTextInputField(
            label = { Text(text = "Date") },
            trailingIcon = {
                CalendarButton(
                    onClick = {

                    },
                )
            }
        )
        CustomTextInputField(
            label = { Text(text = "Amount") }
        )
        CustomTextInputField(
            label = { Text(text = "Expense title") }
        )
        CustomTextInputField(
            label = { Text(text = "Message") }
        )
        Spacer(modifier = Modifier.height(16.dp))
        CustomButton("Save") { }
        
    }
}

@Preview
@Composable
private fun CategoryAddTransactionPreview() {
    PennywiseTheme {
        Surface {
            CategoryAddTransaction(NavController(LocalContext.current))
        }
    }
}