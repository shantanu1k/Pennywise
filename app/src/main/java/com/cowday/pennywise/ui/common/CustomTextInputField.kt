package com.cowday.pennywise.ui.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cowday.pennywise.ui.theme.PennywiseTheme
import com.cowday.pennywise.ui.theme.lightGreen

@Composable
fun CustomTextInputField(
    label: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null
) {
    Column(
        modifier = Modifier
            .padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(2.dp)
    ) {
        label?.invoke()
        TextField(
            value = "Some Text",
            onValueChange = { },
            modifier = Modifier
                .clip(RoundedCornerShape(percent = 40))
                .background(color = lightGreen)
                .padding(horizontal = 8.dp),
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = lightGreen,
                focusedContainerColor = lightGreen,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            trailingIcon = trailingIcon,
        )
    }
}

@Preview
@Composable
private fun CustomTextInputFieldPreview() {
    PennywiseTheme {
        Surface {
            CustomTextInputField(
                label = { Text(text = "Label") },
                trailingIcon = { CalendarButton({}) }
            )
        }
    }
}