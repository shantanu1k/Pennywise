package com.cowday.pennywise.ui.categories

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.cowday.pennywise.ui.categories.navigation.CategoryNavGraph

@Composable
fun CategoryContainer(
    modifier: Modifier = Modifier
) {
    CategoryNavGraph(
        modifier = modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.surface)
            .padding(horizontal = 16.dp, vertical = 24.dp),
        navController = rememberNavController()
    )
}

@Preview
@Composable
private fun CategoryContainerPreview() {
    CategoryContainer()
}

