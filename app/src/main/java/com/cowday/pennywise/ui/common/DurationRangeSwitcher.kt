package com.cowday.pennywise.ui.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cowday.pennywise.ui.theme.green

enum class Duration(val strValue: String) {
    DAILY("Daily"),
    WEEKLY("Weekly"),
    MONTHLY("Monthly"),
    YEARLY("Yearly");
}

@Composable
fun DurationRangeSwitcher(
    durationRange: Set<Duration>,
    selectedDuration: Duration,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(percent = 36))
            .background(color = MaterialTheme.colorScheme.tertiary)
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        durationRange.forEach {
            DurationRangeItem(
                duration = it,
                isSelected = it == selectedDuration,
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
fun DurationRangeItem(
    duration: Duration,
    isSelected: Boolean,
    modifier: Modifier = Modifier,
) {
    val bgColor = if (isSelected) {
        green
    } else {
        MaterialTheme.colorScheme.tertiary
    }
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(percent = 36))
            .background(color = bgColor)
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(text = duration.strValue)
    }
}

@Preview
@Composable
fun DurationRangeSwitcherPreview() {
    DurationRangeSwitcher(
        setOf(Duration.DAILY, Duration.WEEKLY, Duration.MONTHLY),
        Duration.DAILY
    )
}