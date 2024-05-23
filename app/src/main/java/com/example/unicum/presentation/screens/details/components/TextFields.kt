package com.example.unicum.presentation.screens.details.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import com.example.unicum.R
import com.example.unicum.presentation.Dimens
import com.example.unicum.ui.theme.DarkCoffee
import com.example.unicum.utils.Constants

@Composable
fun TextFields(
    coffeeName: String,
    coffeePrice: Int,
    coffeeFree: Boolean,
    outsideName: (String) -> Unit,
    outsidePrice: (Int) -> Unit
) {

    var coffeeNameState by remember { mutableStateOf(coffeeName) }
    var coffeePriceState by remember { mutableIntStateOf(coffeePrice) }

    val textFieldStyle = TextStyle(
        fontSize = Dimens.MediumFontSize4,
        fontWeight = FontWeight.Bold,
        fontFamily = FontFamily(Font(R.font.montserrat_regular)),
        color = colorResource(id = R.color.text_field_color)
    )


        Text(
            text = stringResource(id = R.string.coffee_name),
            style = MaterialTheme.typography.bodySmall.copy(
                fontSize = Dimens.MediumFontSize2,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily(Font(R.font.montserrat_regular)),
                color = colorResource(id = R.color.name_text)
            )
        )
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = Dimens.MediumPadding3),
            textStyle = textFieldStyle,
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = DarkCoffee,
                focusedContainerColor = DarkCoffee
            ),
            value = coffeeName,
            onValueChange = { newName ->
                if (newName.isNotEmpty()) {
                    coffeeNameState = newName
                    outsideName(coffeeNameState)
                }
            },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Text)
        )
        Text(
            modifier = Modifier.padding(top = Dimens.MediumPadding6),
            text = stringResource(id = R.string.coffee_price),
            style = MaterialTheme.typography.bodySmall.copy(
                fontSize = Dimens.MediumFontSize2,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily(Font(R.font.montserrat_regular)),
                color = colorResource(id = R.color.name_text)
            )
        )
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = Dimens.MediumPadding3),
            textStyle = textFieldStyle,
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = DarkCoffee,
                focusedContainerColor = DarkCoffee
            ),
            value = coffeePrice.toString(),
            trailingIcon = {
                Text(
                    text = Constants.RUB,
                    style = MaterialTheme.typography.bodySmall.copy(
                        fontSize = Dimens.MediumFontSize2,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily(Font(R.font.montserrat_regular)),
                        color = colorResource(id = R.color.times)
                    )
                )
            },
            onValueChange = { newPrice ->
                try {
                    if (newPrice.isNotEmpty()) {
                        coffeePriceState = newPrice.toInt()
                        outsidePrice(coffeePriceState)
                    }
                } catch (e: NumberFormatException) {
                    coffeePriceState = 1
                    outsidePrice(coffeePriceState)
                }
            },
            enabled = !coffeeFree,
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Text)
        )
}