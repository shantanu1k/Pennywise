package com.cowday.pennywise.ui.homepage

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cowday.pennywise.R
import com.cowday.pennywise.ui.theme.darkBlue

@Composable
fun TransactionLogo(
    icon: Int
) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(percent = 40))
            .background(color = darkBlue)
            .padding(16.dp)
            .size(24.dp),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = painterResource(icon),
            tint = Color.White,
            contentDescription = null
        )
    }
}

@Preview
@Composable
fun TransactionLogoPreview() {
    TransactionLogo(R.drawable.icon_gift)
}
