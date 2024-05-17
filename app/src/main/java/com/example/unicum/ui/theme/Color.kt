package com.example.unicum.ui.theme

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)

val DarkCoffee = Color(0xFF150E0C)
val Orange = Color(0xFFF77416)
val Beige = Color(0xFFFFF2ED)

val gradientPrice = androidx.compose.ui.graphics.Brush.linearGradient(
    colors = listOf(
        Color(0xFF1D1412),
        Color(0xFF160E0C),
        Color(0xFF231917)
    ),
    start = Offset.Zero,
    end = Offset.Infinite
)

val gradientCard = androidx.compose.ui.graphics.Brush.linearGradient(
    colors = listOf(
        Color(0xFF19110E),
        Color(0xFF100909)
    ),
    start = Offset.Zero,
    end = Offset.Infinite
)

val gradientSwitch = androidx.compose.ui.graphics.Brush.linearGradient(
    colors = listOf(
        Color(0xFFEE4E2B),
        Color(0xFFFF9900)
    ),
    start = Offset.Zero,
    end = Offset.Infinite
)