package com.example.unicum.presentation.screens.details.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import com.example.unicum.R
import com.example.unicum.domain.model.Coffee
import com.example.unicum.presentation.Dimens
import com.example.unicum.presentation.Dimens.MediumPadding1
import com.example.unicum.presentation.Dimens.MediumPadding3
import com.example.unicum.presentation.Dimens.NormalBorder1
import com.example.unicum.presentation.Dimens.SmallShape1
import com.example.unicum.ui.theme.Orange

@Composable
fun SellFreeSwitch(coffee: Coffee) {
    var coffeeFreeState by remember { mutableStateOf(coffee.sellFree) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = MediumPadding3),
        border = BorderStroke(
            width = NormalBorder1,
            color = colorResource(id = R.color.border_window)
        ),
        shape = RoundedCornerShape(SmallShape1)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Black),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier.padding(start = MediumPadding1),
                text = stringResource(id = R.string.coffee_free),
                style = MaterialTheme.typography.bodySmall.copy(
                    fontSize = Dimens.MediumFontSize2,
                    fontFamily = FontFamily(Font(R.font.montserrat_regular)),
                    color = colorResource(id = R.color.times)
                )
            )
            Switch(
                modifier = Modifier
                    .padding(end = MediumPadding1),
                colors = SwitchDefaults.colors(
                    checkedThumbColor = Color.White,
                    checkedTrackColor = Orange,
                    uncheckedThumbColor = Color.White,
                    uncheckedTrackColor = Orange
                ), checked = coffeeFreeState, onCheckedChange = { isChecked ->
                    coffeeFreeState = isChecked
                    coffee.sellFree = coffeeFreeState
                })
        }
    }
}