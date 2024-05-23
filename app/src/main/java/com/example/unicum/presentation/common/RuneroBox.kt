package com.example.unicum.presentation.common

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import com.example.unicum.R
import com.example.unicum.presentation.Dimens.IconSize1
import com.example.unicum.presentation.Dimens.MediumFontSize2
import com.example.unicum.presentation.Dimens.MediumPadding3
import com.example.unicum.presentation.Dimens.MediumPadding4
import com.example.unicum.presentation.Dimens.MediumPadding5
import com.example.unicum.presentation.Dimens.NormalBorder1

@Composable
fun RuneroBox(navigateUp: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .border(width = NormalBorder1, color = colorResource(id = R.color.border_window)),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            modifier = Modifier
                .padding(
                    start = MediumPadding4,
                    top = MediumPadding5,
                    bottom = MediumPadding5
                )
                .clickable { navigateUp() }
        ) {
            Icon(
                modifier = Modifier
                    .padding(end = MediumPadding3)
                    .size(IconSize1),
                painter = painterResource(id = R.drawable.ic_runero),
                contentDescription = null,
                tint = colorResource(id = R.color.runero)
            )
            Text(
                text = "RUNERO Touch",
                style = MaterialTheme.typography.bodySmall.copy(
                    fontSize = MediumFontSize2,
                    fontFamily = FontFamily(Font(R.font.montserrat_regular)),
                    color = colorResource(id = R.color.runero)
                )
            )
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            Spacer(modifier = Modifier.weight(1f))
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
}