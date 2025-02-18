package com.cowday.pennywise.ui.common

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cowday.pennywise.R
import com.cowday.pennywise.ui.theme.green

@Composable
fun BottomNavigationItem(
    icon: Int,
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val bgColor = if (isSelected) {
        green
    } else {
        Color.Transparent
    }
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(percent = 40))
            .background(color = bgColor)
            .padding(16.dp)
            .size(24.dp)
            .clickable(
                interactionSource = null,
                indication = null,
                onClick = { onClick() }
            ),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = painterResource(icon),
            tint = MaterialTheme.colorScheme.onPrimary,
            contentDescription = null
        )
    }
}

@Preview
@Composable
fun BottomNavigationItemPreview(modifier: Modifier = Modifier) {
    BottomNavigationItem(R.drawable.icon_home, true, {})
}