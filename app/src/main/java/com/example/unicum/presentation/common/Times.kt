package com.example.unicum.presentation.common

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.example.unicum.R
import com.example.unicum.presentation.Dimens
import kotlinx.coroutines.delay
import java.time.LocalTime
import java.time.format.DateTimeFormatter

@Composable
fun CurrentTime() {
    val currentTimeState = remember { mutableStateOf(LocalTime.now()) }

    LaunchedEffect(Unit) {
        while (true) {
            currentTimeState.value = LocalTime.now()
            delay(61000)
        }
    }
    val timeString = remember(currentTimeState.value) {
        currentTimeState.value.format(DateTimeFormatter.ofPattern("HH:mm"))
    }

    Text(
        modifier = Modifier.padding(horizontal = Dimens.MediumPadding1),
        text = timeString,
        style = MaterialTheme.typography.bodySmall.copy(
            fontWeight = FontWeight.Bold,
            fontSize = Dimens.MediumFontSize2,
            fontFamily = FontFamily(Font(R.font.montserrat_regular)),
            color = colorResource(id = R.color.times)
        )
    )
}