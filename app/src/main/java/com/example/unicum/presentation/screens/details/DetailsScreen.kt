package com.example.unicum.presentation.screens.details

import android.content.res.Configuration
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import com.example.unicum.domain.model.Coffee
import com.example.unicum.presentation.common.RuneroBox
import com.example.unicum.presentation.screens.details.components.EditCoffeeCard
import com.example.unicum.presentation.screens.details.components.EditCoffeeCardPortrait
import com.example.unicum.utils.UIComponent

@Composable
fun DetailsScreen(
    coffee: Coffee,
    event: (DetailsEvent) -> Unit,
    sideEffect: UIComponent?,
    navigateUp: () -> Unit
) {
    val context = LocalContext.current
    LaunchedEffect(key1 = sideEffect) {
        sideEffect?.let {
            when (sideEffect) {
                is UIComponent.Toast -> {
                    Toast.makeText(context, sideEffect.message, Toast.LENGTH_SHORT).show()
                    event(DetailsEvent.RemoveSideEffect)
                }
            }
        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        RuneroBox(navigateUp)

        val configuration = LocalConfiguration.current
        when (configuration.orientation) {
            Configuration.ORIENTATION_LANDSCAPE -> {
                EditCoffeeCard(coffee = coffee, event = event, navigateUp = navigateUp)
            }

            else -> {
                EditCoffeeCardPortrait(coffee = coffee, event = event, navigateUp = navigateUp)
            }
        }
    }
}