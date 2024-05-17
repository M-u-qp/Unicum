package com.example.unicum.presentation.common

import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.example.unicum.R
import com.example.unicum.presentation.Dimens
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

    Text(
        modifier = Modifier.padding(start = Dimens.MediumPadding1),
        text = "${randomNumber.doubleValue}${Constants.DEGREE}",
        style = MaterialTheme.typography.bodySmall.copy(
            fontWeight = FontWeight.Bold,
            fontSize = Dimens.MediumFontSize2,
            fontFamily = FontFamily(Font(R.font.montserrat_regular)),
            color = colorResource(id = R.color.runero)
        )
    )
    Icon(
        modifier = Modifier
            .offset(y = Dimens.ExtraSmallOffset)
            .padding(end = Dimens.MediumPadding1),
        painter = painterResource(id = R.drawable.ic_droplet),
        contentDescription = null,
        tint = colorResource(id = R.color.runero)
    )
}

fun generateRandomNumber(): Double {
    val number = Random.nextDouble(85.0, 95.0)
    return (number * 10).roundToInt() / 10.0
}