package com.cowday.pennywise.ui.analysis

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import co.yml.charts.axis.AxisData
import co.yml.charts.common.components.Legends
import co.yml.charts.common.model.LegendsConfig
import co.yml.charts.common.utils.DataUtils
import co.yml.charts.ui.barchart.GroupBarChart
import co.yml.charts.ui.barchart.models.BarPlotData
import co.yml.charts.ui.barchart.models.BarStyle
import co.yml.charts.ui.barchart.models.GroupBarChartData
import co.yml.charts.ui.barchart.models.GroupSeparatorConfig
import com.cowday.pennywise.R
import com.cowday.pennywise.ui.theme.PennywiseTheme
import com.cowday.pennywise.ui.theme.blue
import com.cowday.pennywise.ui.theme.darkBlue
import com.cowday.pennywise.ui.theme.green
import com.cowday.pennywise.ui.theme.lightGreen

@Composable
fun TransactionGraph(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(percent = 16))
            .background(color = lightGreen)
            .padding(24.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
        ) {
            Text(
                text = stringResource(R.string.label_income_and_expenses),
                style = MaterialTheme.typography.titleMedium
            )
            VerticalGroupBarChart()
        }
    }
}

@Composable
fun VerticalGroupBarChart() {
    val maxRange = 100
    val barSize = 2
    val groupBarData = DataUtils.getGroupBarChartData(7, maxRange, barSize)
    val yStepSize = 4
    val xAxisData = AxisData.Builder()
        .axisStepSize(30.dp)
        .bottomPadding(5.dp)
        .startDrawPadding(4.dp)
        .indicatorLineWidth(0.dp)
        .labelData { index -> index.toString() }
        .build()
    val yAxisData = AxisData.Builder()
        .steps(yStepSize)
        .labelAndAxisLinePadding(20.dp)
        .axisOffset(20.dp)
        .startPadding(0.dp)
        .axisLabelColor(blue)
        .axisLineColor(Color.Transparent)
        .labelAndAxisLinePadding(0.dp)
        .labelData { index -> (index * (maxRange / yStepSize)).toString() }
        .backgroundColor(lightGreen)
        .build()
    val groupBarPlotData = BarPlotData(
        groupBarList = groupBarData,
        barStyle = BarStyle(barWidth = 8.dp),
        barColorPaletteList = listOf(green, darkBlue)
    )
    val groupBarChartData = GroupBarChartData(
        barPlotData = groupBarPlotData,
        xAxisData = xAxisData,
        yAxisData = yAxisData,
        groupSeparatorConfig = GroupSeparatorConfig(0.dp),
        backgroundColor = lightGreen,
    )
    GroupBarChart(
        modifier = Modifier,
        groupBarChartData = groupBarChartData
    )
}

@Preview
@Composable
private fun TransactionGraphPreview() {
    PennywiseTheme {
        TransactionGraph()
    }
}