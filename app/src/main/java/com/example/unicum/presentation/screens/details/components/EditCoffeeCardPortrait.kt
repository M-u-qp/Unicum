package com.example.unicum.presentation.screens.details.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
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
import com.example.unicum.presentation.Dimens
import com.example.unicum.presentation.Dimens.MediumPadding1
import com.example.unicum.presentation.screens.details.DetailsEvent
import com.example.unicum.ui.theme.Orange

@Composable
fun EditCoffeeCardPortrait(
    coffee: Coffee,
    event: (DetailsEvent) -> Unit,
    navigateUp: () -> Unit
) {
    val scrollStateColumn = rememberScrollState()
    var coffeeName by remember { mutableStateOf(coffee.name) }
    var coffeePrice by remember { mutableIntStateOf(coffee.price) }
    var coffeeGlass by remember { mutableIntStateOf(coffee.viewGlass) }
    var coffeeFreeState by remember { mutableStateOf(coffee.sellFree) }

    fun isSaveButtonEnabled(): Boolean {
        return coffee.name != coffeeName || coffee.price != coffeePrice
                || coffee.sellFree != coffeeFreeState || coffee.viewGlass != coffeeGlass
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(MediumPadding1)
            .verticalScroll(state = scrollStateColumn),
        horizontalAlignment = Alignment.CenterHorizontally
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

        CoffeeCup(coffeeGlassState = coffeeGlass) {
            coffeeGlass = it
        }

        Button(
            modifier = Modifier
                .padding(top = Dimens.BigPadding1),
            shape = RoundedCornerShape(Dimens.SmallShape1),
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
                modifier = Modifier.padding(vertical = Dimens.SmallPadding2),
                text = stringResource(id = R.string.coffee_save),
                style = MaterialTheme.typography.bodySmall.copy(
                    fontSize = Dimens.MediumFontSize4,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily(Font(R.font.montserrat_regular)),
                    color = colorResource(id = R.color.button_text)
                )
            )
        }
    }
}