package com.cowday.pennywise.ui.categories

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cowday.pennywise.data.CategoryType
import com.cowday.pennywise.data.ExpenseCategoryType
import com.cowday.pennywise.data.IncomeCategoryType

@Composable
fun CategoryList(
    categoryList: List<CategoryType>,
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.surface)
            .padding(horizontal = 16.dp, vertical = 24.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        items(categoryList) { category ->
            CategoryListItem(
                icon = category.getIcon(),
                categoryName = category.getStrValue()
            )
        }
    }
}

@Preview
@Composable
private fun CategoryListPreview() {
    CategoryList(
        IncomeCategoryType.entries + ExpenseCategoryType.entries
    )
}

