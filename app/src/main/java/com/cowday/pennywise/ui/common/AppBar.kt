package com.cowday.pennywise.ui.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cowday.pennywise.R
import com.cowday.pennywise.ui.theme.PennywiseTheme

@Composable
fun AppBar(title: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Icon(
            modifier = Modifier
                .weight(0.1f)
                .height(16.dp),
            painter = painterResource(R.drawable.icon_back),
            contentDescription = null
        )
        Text(
            modifier = Modifier.weight(0.8f),
            text = title,
            style = MaterialTheme.typography.titleMedium,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.weight(0.1f))
    }
}

@Preview
@Composable
private fun AppBarPreview() {
    PennywiseTheme {
        Surface {
            AppBar("Transactions")
        }
    }
}