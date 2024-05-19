package com.example.unicum.presentation.screens.details

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.example.unicum.domain.model.Coffee
import com.example.unicum.presentation.common.RuneroBox
import com.example.unicum.presentation.screens.details.components.EditCoffeeCard
import com.example.unicum.utils.UIComponent

@Composable
fun DetailsScreen(
    navController: NavController,
    coffee: Coffee,
    listCoffees: List<Coffee>,
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
        RuneroBox(
            navController = navController,
            navigateUp = navigateUp
        )
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            EditCoffeeCard(coffee = coffee, listCoffees = listCoffees, event = event, navigateUp = navigateUp)
        }
    }
}