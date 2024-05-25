package com.example.unicum.presentation.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.intl.Locale
import com.example.unicum.R
import com.example.unicum.presentation.Dimens.BigPadding2
import com.example.unicum.presentation.Dimens.IconSize1
import com.example.unicum.presentation.Dimens.MediumFontSize2

@Composable
fun CurrentRegion() {
    val systemLanguage = Locale.current
    Image(
        modifier = Modifier
            .size(IconSize1)
            .background(Color.White),
        painter = painterResource(id = if (systemLanguage.region == "RU") R.drawable.img_2 else R.drawable.flag_usa),
        contentDescription = null,
        contentScale = ContentScale.Crop
    )
    Text(
        modifier = Modifier.padding(end = BigPadding2),
        text = systemLanguage.region,
        style = MaterialTheme.typography.bodySmall.copy(
            fontSize = MediumFontSize2,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily(Font(R.font.montserrat_regular)),
            color = colorResource(id = R.color.times)
        )
    )
}