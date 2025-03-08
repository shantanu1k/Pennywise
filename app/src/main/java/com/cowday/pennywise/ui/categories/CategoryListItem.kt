package com.cowday.pennywise.ui.categories

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cowday.pennywise.R
import com.cowday.pennywise.ui.theme.PennywiseTheme
import com.cowday.pennywise.ui.theme.blue

@Composable
fun CategoryListItem(
    icon: Int,
    categoryName: String
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Icon(
            modifier = Modifier
                .clip(RoundedCornerShape(24))
                .background(color = blue)
                .padding(16.dp)
                .size(40.dp),
            painter = painterResource(icon),
            contentDescription = null
        )
        Text(
            text = categoryName,
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Preview
@Composable
private fun CategoryListItemPreview() {
    PennywiseTheme {
        Surface {
            CategoryListItem(
                icon = R.drawable.icon_gift,
                categoryName = stringResource(R.string.label_gift)
            )
        }
    }
}