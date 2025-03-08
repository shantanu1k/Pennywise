package com.cowday.pennywise.ui.categories

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.cowday.pennywise.data.ExpenseCategoryType
import com.cowday.pennywise.data.IncomeCategoryType
import com.cowday.pennywise.ui.common.AppBar
import com.cowday.pennywise.ui.homepage.FinanceSummary

@Composable
fun CategoryScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.primary)
            .padding(top = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AppBar("Categories")
        Spacer(modifier = Modifier.height(16.dp))
        FinanceSummary()
        Spacer(modifier = Modifier.height(24.dp))
        CategoryContainer(
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
private fun CategoryScreenPreview() {
    CategoryScreen(NavController(LocalContext.current))
}