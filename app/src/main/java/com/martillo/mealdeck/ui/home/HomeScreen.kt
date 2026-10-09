package com.martillo.mealdeck.ui.home

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp
import kotlin.math.roundToInt

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(state: HomeState, onChangeTargets:() -> Unit)
{



    Box(modifier = Modifier.fillMaxSize()) {

        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            TopAppBar(
                title = { Text("Home Screen") }
            )

            CaloryGauge(targetKcal = state.targetKcal, kcal = state.kcal)

            MacroBar("Protein", state.protein, state.targetProtein)
            MacroBar("Carbs", state.carbs, state.targetCarbs)
            MacroBar("Fat", state.fat, state.targetFat)
            MacroBar("Sugar", state.sugar, state.targetSugar)
        }

        SmallFloatingActionButton(
            onClick = onChangeTargets,
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(16.dp),
        ) {
            Icon(Icons.Filled.Edit, contentDescription = "Edit")
        }
    }
}
@Composable
fun CaloryGauge(kcal:Double,targetKcal:Double) {
    val fraction = if (targetKcal <= 0.0) 0f else (kcal / targetKcal).toFloat()
    val baseColor = if(fraction>1f) MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.surfaceVariant
    val progress = if(fraction>1f) (targetKcal/kcal).toFloat() else fraction
    val arcColor = MaterialTheme.colorScheme.primary
    Box(modifier =Modifier.fillMaxWidth().padding(vertical = 48.dp), contentAlignment = Alignment.BottomCenter) {
        Canvas(Modifier.width(336.dp).height(168.dp).padding(10.dp)) {
            val strokeWidth = 48.dp.toPx()
            val stroke = Stroke(width = strokeWidth, cap = StrokeCap.Butt)
            val arcSize = Size(336.dp.toPx() - strokeWidth, 336.dp.toPx() - strokeWidth)
            val arcTopLeft = Offset(strokeWidth / 2f, strokeWidth / 2f)
            drawArc(
                color = baseColor,
                startAngle = 180f,
                sweepAngle = 180f,
                useCenter = false,
                topLeft = arcTopLeft,
                size = arcSize,
                style = stroke,
            )
            drawArc(
                color = arcColor,
                startAngle = 180f,
                sweepAngle = 180f * progress,
                useCenter = false,
                topLeft = arcTopLeft,
                size = arcSize,
                style = stroke,
            )

        }
        Text("${kcal.roundToInt()}/${targetKcal.roundToInt()}")
    }
}
@Composable
fun MacroBar(
    label: String,
    eaten: Double,
    target: Double,
    modifier: Modifier = Modifier,
){
    val fraction = if (target <= 0.0) 0f else (eaten / target).toFloat()
    val baseColor = if(fraction>1f) MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.surfaceVariant
    val progress = if(fraction>1f) (target/eaten).toFloat() else fraction
    val fill = MaterialTheme.colorScheme.primary
    Column(modifier.padding(horizontal = 16.dp, vertical = 6.dp)) {
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text(label)
            Text("${eaten.roundToInt()} / ${target.roundToInt()} g")
        }
        Canvas(
            Modifier
                .fillMaxWidth()
                .padding(top = 4.dp)
                .height(10.dp)
        ) {
            val radius = size.height / 2f
            val corners = CornerRadius(radius, radius)
            drawRoundRect(color = baseColor, cornerRadius = corners)
            drawRoundRect(
                color = fill,
                size = Size(size.width * progress, size.height),
                cornerRadius = corners,
            )
        }
    }
}