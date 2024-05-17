package com.example.unicum.presentation.screens.details.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.unicum.R
import com.example.unicum.presentation.Dimens
import com.example.unicum.ui.theme.Beige
import com.example.unicum.ui.theme.DarkCoffee
import com.example.unicum.ui.theme.Orange

@Composable
fun EditCoffeeCard() {
    var coffeeName by remember { mutableStateOf("Капучино эконом") }
    var coffeePrice by remember { mutableIntStateOf(199) }
    Row(
        modifier = Modifier.padding(),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier.size(width = 418.dp, height = 380.dp)
        ) {
            Text(
                modifier = Modifier.padding(bottom = 12.dp),
                text = "Наименование",
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
                    .padding(bottom = 32.dp),
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = DarkCoffee,
                    focusedContainerColor = DarkCoffee,
                    focusedTextColor = Beige,
                    unfocusedTextColor = Beige
                ),
                value = coffeeName,
                onValueChange = { newName ->
                    coffeeName = newName
                })
            Text(
                modifier = Modifier.padding(bottom = 12.dp),
                text = "Цена",
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
                    .padding(bottom = 12.dp),
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = DarkCoffee,
                    focusedContainerColor = DarkCoffee,
                    focusedTextColor = Beige,
                    unfocusedTextColor = Beige
                ),
                value = coffeePrice.toString(),
                onValueChange = { newPrice ->
                    coffeePrice = newPrice.toInt()
                })
            SellFreeSwitch()
            Button(
                modifier = Modifier.size(width = 162.dp, height = 52.dp),
                shape = RoundedCornerShape(6.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Orange),
                onClick = { /*TODO*/ }) {
                Text(
                    text = "Сохранить",
                    style = MaterialTheme.typography.bodySmall.copy(
                        fontSize = Dimens.MediumFontSize4,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily(Font(R.font.montserrat_regular)),
                        color = colorResource(id = R.color.button_text)
                    )
                )
            }
        }
        Image(
            modifier = Modifier.size(227.dp),
            painter = painterResource(id = R.drawable.img),
            contentDescription = null
        )
        Image(
            modifier = Modifier.size(227.dp),
            painter = painterResource(id = R.drawable.img_1),
            contentDescription = null
        )
    }
}