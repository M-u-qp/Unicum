package com.example.unicum.presentation.screens.details.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import com.example.unicum.R
import com.example.unicum.domain.model.Coffee
import com.example.unicum.presentation.Dimens
import com.example.unicum.presentation.Dimens.BigPadding1
import com.example.unicum.presentation.Dimens.ColumnWidth
import com.example.unicum.presentation.Dimens.ExtraSmallOffset2
import com.example.unicum.presentation.Dimens.ImageMediumSize2
import com.example.unicum.presentation.Dimens.LargePadding1
import com.example.unicum.presentation.Dimens.MediumFontSize4
import com.example.unicum.presentation.Dimens.MediumIconSize1
import com.example.unicum.presentation.Dimens.MediumMinusOffset1
import com.example.unicum.presentation.Dimens.MediumMinusOffset2
import com.example.unicum.presentation.Dimens.MediumOffset1
import com.example.unicum.presentation.Dimens.MediumPadding3
import com.example.unicum.presentation.Dimens.MediumPadding6
import com.example.unicum.presentation.Dimens.MediumPadding7
import com.example.unicum.presentation.Dimens.SmallPadding2
import com.example.unicum.presentation.Dimens.SmallShape1
import com.example.unicum.presentation.screens.details.DetailsEvent
import com.example.unicum.ui.theme.DarkCoffee
import com.example.unicum.ui.theme.Orange

@Composable
fun EditCoffeeCard(
    coffee: Coffee,
    event: (DetailsEvent) -> Unit,
    navigateUp: () -> Unit
) {
    var coffeeName by remember { mutableStateOf(coffee.name) }
    var coffeePrice by remember { mutableIntStateOf(coffee.price) }
    var coffeeGlass by remember { mutableIntStateOf(coffee.viewGlass) }
    val textFieldStyle = TextStyle(
        fontSize = MediumFontSize4,
        fontWeight = FontWeight.Bold,
        fontFamily = FontFamily(Font(R.font.montserrat_regular)),
        color = colorResource(id = R.color.text_field_color)
    )
    Row(
        modifier = Modifier
            .fillMaxSize(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier
                .padding(start = LargePadding1)
                .width(ColumnWidth)
        ) {
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
                    .padding(top = MediumPadding3),
                textStyle = textFieldStyle,
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = DarkCoffee,
                    focusedContainerColor = DarkCoffee
                ),
                value = coffeeName,
                onValueChange = { newName ->
                    if (newName.isNotEmpty()) {
                        coffeeName = newName
                    }
                },
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Text)
            )
            Text(
                modifier = Modifier.padding(top = MediumPadding6),
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
                    .padding(top = MediumPadding3),
                textStyle = textFieldStyle,
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = DarkCoffee,
                    focusedContainerColor = DarkCoffee
                ),
                value = coffeePrice.toString(),
                onValueChange = { newPrice ->
                    if (newPrice.isNotEmpty()) {
                        coffeePrice = newPrice.toInt()
                    }
                },
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Text)
            )
            SellFreeSwitch(coffee = coffee)
            Button(
                modifier = Modifier
                    .padding(top = BigPadding1),
                shape = RoundedCornerShape(SmallShape1),
                colors = ButtonDefaults.buttonColors(containerColor = Orange),
                onClick = {
                    coffee.name = coffeeName
                    coffee.price = coffeePrice
                    event(DetailsEvent.UpdateCoffee(coffee))
                    navigateUp()
                }) {
                Text(
                    modifier = Modifier.padding(vertical = SmallPadding2),
                    text = stringResource(id = R.string.coffee_save),
                    style = MaterialTheme.typography.bodySmall.copy(
                        fontSize = MediumFontSize4,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily(Font(R.font.montserrat_regular)),
                        color = colorResource(id = R.color.button_text)
                    )
                )
            }
        }
        Box(
            modifier = Modifier
                .alpha(if (coffeeGlass == 0) 1f else 0.3f)
                .clickable {
                coffeeGlass = 0
                coffee.viewGlass = coffeeGlass
            },
            contentAlignment = Alignment.BottomCenter
        ) {
            Image(
                modifier = Modifier
                    .padding(start = MediumPadding7)
                    .size(ImageMediumSize2),
                painter = painterResource(id = R.drawable.img),
                contentDescription = null
            )
            if (coffeeGlass == 0) {
                IconButton(
                    modifier = Modifier
                        .offset(x = MediumOffset1, y = MediumMinusOffset1)
                        .size(MediumIconSize1),
                    onClick = {},
                    colors = IconButtonDefaults.iconButtonColors(containerColor = Orange)
                ) {
                    Icon(
                        imageVector = Icons.Default.Check,
                        contentDescription = null,
                        tint = Color.White,
                    )
                }
            }
        }

        Box(
            modifier = Modifier
                .alpha(if (coffeeGlass == 1) 1f else 0.3f)
                .clickable {
                    coffeeGlass = 1
                    coffee.viewGlass = coffeeGlass
                },
            contentAlignment = Alignment.BottomCenter
        ) {
            Image(
                modifier = Modifier
                    .offset(y = MediumOffset1)
                    .size(ImageMediumSize2),
                painter = painterResource(id = R.drawable.img_1),
                contentDescription = null
            )
            if (coffeeGlass == 1) {
                IconButton(
                    modifier = Modifier
                        .offset(x = ExtraSmallOffset2, y = MediumMinusOffset2)
                        .size(MediumIconSize1),
                    onClick = {},
                    colors = IconButtonDefaults.iconButtonColors(containerColor = Orange)
                ) {
                    Icon(
                        imageVector = Icons.Default.Check,
                        contentDescription = null,
                        tint = Color.White,
                    )
                }
            }
        }
    }
}
