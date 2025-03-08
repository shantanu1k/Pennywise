package com.cowday.pennywise.ui.categories.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.cowday.pennywise.data.ExpenseCategoryType
import com.cowday.pennywise.data.IncomeCategoryType
import com.cowday.pennywise.ui.categories.CategoryListItem
import com.cowday.pennywise.ui.theme.PennywiseTheme

@Composable
fun CategoryOverview(navController: NavController) {
    val categoryList = remember {
        mutableStateOf(ExpenseCategoryType.entries + IncomeCategoryType.entries)
    }
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = Modifier,
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        items(categoryList.value) { category ->
            CategoryListItem(
                icon = category.getIcon(),
                categoryName = category.getStrValue()
            )
        }
    }
}

@Preview
@Composable
private fun CategoryOverviewPreview() {
    PennywiseTheme {
        Surface {
            CategoryOverview(NavController(LocalContext.current))
        }
    }
}