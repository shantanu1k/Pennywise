package com.cowday.pennywise.ui.common

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cowday.pennywise.R
import com.cowday.pennywise.ui.theme.PennywiseTheme
import com.cowday.pennywise.ui.theme.green

@Composable
fun CalendarButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Icon(
        painter = painterResource(R.drawable.ic_calendar),
        contentDescription = null,
        modifier = modifier
            .clip(RoundedCornerShape(percent = 36))
            .background(color = green)
            .padding(8.dp)
            .size(24.dp)
            .clickable(
                enabled = true,
                indication = null,
                interactionSource = null,
                onClick = {}
            )
    )
}

@Preview
@Composable
private fun CalendarButtonPreview() {
    PennywiseTheme {
        Surface {
            CalendarButton({})
        }
    }
}