package com.example.unicum.presentation.screens.details.components

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.example.unicum.R
import com.example.unicum.domain.model.Coffee
import com.example.unicum.presentation.Dimens.BigPadding1
import com.example.unicum.presentation.Dimens.MediumFontSize4
import com.example.unicum.presentation.Dimens.MediumPadding1
import com.example.unicum.presentation.Dimens.SmallPadding2
import com.example.unicum.presentation.Dimens.SmallShape1
import com.example.unicum.presentation.screens.details.DetailsEvent
import com.example.unicum.ui.theme.Orange

@Composable
fun EditCoffeeCard(
    coffee: Coffee,
    event: (DetailsEvent) -> Unit,
    navigateUp: () -> Unit
) {
    val scrollStateColumn = rememberScrollState()
    val scrollStateRow = rememberScrollState()
    var coffeeName by remember { mutableStateOf(coffee.name) }
    var coffeePrice by remember { mutableIntStateOf(coffee.price) }
    var coffeeGlass by remember { mutableIntStateOf(coffee.viewGlass) }
    var coffeeFreeState by remember { mutableStateOf(coffee.sellFree) }

    fun isSaveButtonEnabled(): Boolean {
        return coffee.name != coffeeName || coffee.price != coffeePrice
                || coffee.sellFree != coffeeFreeState || coffee.viewGlass != coffeeGlass
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .horizontalScroll(state = scrollStateRow),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(start = MediumPadding1)
                .verticalScroll(state = scrollStateColumn),
            verticalArrangement = Arrangement.Center
        ) {

            TextFields(
                coffeeName = coffeeName,
                coffeePrice = coffeePrice,
                coffeeFree = coffeeFreeState,
                outsideName = { coffeeName = it },
                outsidePrice = { coffeePrice = it }
            )

            SwitchCard(
                coffeeFree = coffeeFreeState,
                coffeePrice = coffeePrice,
                outsidePrice = { coffeePrice = it },
                outsideFree = { coffeeFreeState = it }
            )

            Button(
                modifier = Modifier
                    .padding(top = BigPadding1),
                shape = RoundedCornerShape(SmallShape1),
                colors = ButtonDefaults.buttonColors(containerColor = Orange),
                enabled = isSaveButtonEnabled(),
                onClick = {
                    coffee.name = coffeeName
                    coffee.price = coffeePrice
                    coffee.viewGlass = coffeeGlass
                    coffee.sellFree = coffeeFreeState
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
        CoffeeCup(coffeeGlassState = coffeeGlass) {
            coffeeGlass = it
        }
    }
}