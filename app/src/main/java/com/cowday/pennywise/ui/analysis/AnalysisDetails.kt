package com.cowday.pennywise.ui.analysis

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.traceEventEnd
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cowday.pennywise.ui.common.Duration
import com.cowday.pennywise.ui.common.DurationRangeSwitcher

@Composable
fun AnalysisDetails(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.surface)
            .padding(horizontal = 16.dp, vertical = 24.dp)
            .verticalScroll(state = rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        DurationRangeSwitcher(
            durationRange = setOf(
                Duration.DAILY,
                Duration.WEEKLY,
                Duration.MONTHLY,
                Duration.YEARLY
            ),
            selectedDuration = Duration.DAILY
        )
        Spacer(modifier = Modifier.height(24.dp))
        TransactionGraph(
            modifier = Modifier.height(240.dp)
        )
        Spacer(modifier = Modifier.height(24.dp))
        AnalysisTotalAmount()
    }
}

@Preview
@Composable
fun AnalysisDetailsPreview() {
    AnalysisDetails()
}