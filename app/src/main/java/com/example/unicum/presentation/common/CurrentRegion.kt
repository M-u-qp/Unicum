package com.example.unicum.presentation.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.intl.Locale
import com.example.unicum.R
import com.example.unicum.presentation.Dimens
import com.example.unicum.presentation.Dimens.BigPadding2

@Composable
fun CurrentRegion() {
    val systemLanguage = Locale.current
    Image(
        painter = painterResource(id = if (systemLanguage.region == "RU") R.drawable.img_2 else R.drawable.us),
        contentDescription = null
    )
    Text(
        modifier = Modifier.padding(end = BigPadding2),
        text = systemLanguage.region,
        style = MaterialTheme.typography.bodySmall.copy(
            fontSize = Dimens.MediumFontSize2,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily(Font(R.font.montserrat_regular)),
            color = colorResource(id = R.color.times)
        )
    )
}