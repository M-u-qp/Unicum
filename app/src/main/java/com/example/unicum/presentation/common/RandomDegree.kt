package com.example.unicum.presentation.common

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.example.unicum.R
import com.example.unicum.presentation.Dimens.DividerMediumHeight
import com.example.unicum.presentation.Dimens.DividerMediumWidth
import com.example.unicum.presentation.Dimens.ExtraSmallOffset1
import com.example.unicum.presentation.Dimens.MediumFontSize2
import com.example.unicum.presentation.Dimens.MediumPadding1
import com.example.unicum.presentation.Dimens.NormalBorder1
import com.example.unicum.utils.Constants
import kotlinx.coroutines.delay
import kotlin.math.roundToInt
import kotlin.random.Random

@Composable
fun RandomDegree() {
    val randomNumber = remember { mutableDoubleStateOf(generateRandomNumber()) }

    LaunchedEffect(Unit) {
        while (true) {
            randomNumber.doubleValue = generateRandomNumber()
            delay(1000)
        }
    }

    Row(
        modifier = Modifier
            .padding(end = MediumPadding1)
            .height(DividerMediumHeight)
            .border(width = NormalBorder1, color = colorResource(id = R.color.border_window)),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {

        Text(
            modifier = Modifier
                .padding(start = MediumPadding1)
                .width(DividerMediumWidth),
            text = "${randomNumber.doubleValue}${Constants.DEGREE}",
            style = MaterialTheme.typography.bodySmall.copy(
                fontWeight = FontWeight.Bold,
                fontSize = MediumFontSize2,
                fontFamily = FontFamily(Font(R.font.montserrat_regular)),
                color = colorResource(id = R.color.times)
            )
        )
        Icon(
            modifier = Modifier
                .offset(y = ExtraSmallOffset1),
            painter = painterResource(id = R.drawable.ic_droplet),
            contentDescription = null,
            tint = colorResource(id = R.color.times)
        )
    }
}

fun generateRandomNumber(): Double {
    val number = Random.nextDouble(85.0, 95.0)
    return (number * 10).roundToInt() / 10.0
}