package com.example.unicum.presentation.common

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.IntSize
import com.example.unicum.R
import com.example.unicum.presentation.Dimens.IconSize1
import com.example.unicum.presentation.Dimens.MediumFontSize2
import com.example.unicum.presentation.Dimens.MediumPadding3
import com.example.unicum.presentation.Dimens.MediumPadding4
import com.example.unicum.presentation.Dimens.NormalBorder1

@Composable
fun RuneroBox(navigateUp: () -> Unit, outsideContainerSize: IntSize) {

    val isContentOverflowing = remember { mutableStateOf(false) }
    val containerSize = remember { mutableStateOf(outsideContainerSize) }
    val contentSize = remember { mutableStateOf(IntSize.Zero) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .onSizeChanged { contentSize.value = it }
            .border(width = NormalBorder1, color = colorResource(id = R.color.border_window)),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            modifier = Modifier
                .padding(start = MediumPadding4)
                .clickable { navigateUp() },
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                modifier = Modifier
                    .padding(end = MediumPadding3)
                    .size(IconSize1),
                painter = painterResource(id = R.drawable.ic_runero),
                contentDescription = null,
                tint = colorResource(id = R.color.runero)
            )
            if (isContentOverflowing.value)
            Text(
                text = "RUNERO Touch",
                style = MaterialTheme.typography.bodySmall.copy(
                    fontSize = MediumFontSize2,
                    fontFamily = FontFamily(Font(R.font.montserrat_regular)),
                    color = colorResource(id = R.color.runero)
                )
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            CurrentTime()
            RandomDegree()
            CurrentRegion()
        }
    }
    HorizontalDivider(
        modifier = Modifier.fillMaxWidth(),
        thickness = NormalBorder1,
        color = colorResource(id = R.color.border_window)
    )

    LaunchedEffect(Unit) {
        isContentOverflowing.value = contentSize.value.width < containerSize.value.width
    }
}