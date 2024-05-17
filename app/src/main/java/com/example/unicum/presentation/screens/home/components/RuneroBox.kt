package com.example.unicum.presentation.screens.home.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import com.example.unicum.presentation.Dimens
import com.example.unicum.presentation.Dimens.IconSize1
import com.example.unicum.presentation.Dimens.MediumPadding3
import com.example.unicum.presentation.Dimens.MediumPadding4
import com.example.unicum.presentation.Dimens.MediumPadding5
import com.example.unicum.presentation.Dimens.NormalBorder1
import com.example.unicum.presentation.common.CurrentTime
import com.example.unicum.presentation.common.RandomDegree

@Composable
fun RuneroBox() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .border(width = NormalBorder1, color = colorResource(id = R.color.border_window)),
        contentAlignment = Alignment.CenterStart,
    ) {
        Row(
            modifier = Modifier.padding(
                start = MediumPadding4,
                top = MediumPadding5,
                bottom = MediumPadding5
            )
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
                    fontSize = Dimens.MediumFontSize2,
                    fontFamily = FontFamily(Font(R.font.montserrat_regular)),
                    color = colorResource(id = R.color.runero)
                )
            )
            Spacer(modifier = Modifier.weight(1f))
            CurrentTime()
            RandomDegree()
        }
    }
}