package com.example.unicum.presentation.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.unicum.domain.model.Coffee
import com.example.unicum.presentation.common.RuneroBox
import com.example.unicum.presentation.screens.home.components.CoffeeList

@Composable
fun HomeScreen(
    navController: NavController,
    state: HomeState,
    navigateToDetails: (Coffee) -> Unit,
    navigateUp: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        RuneroBox(
            navController = navController,
            navigateUp = navigateUp,
            onClick = {navigateToDetails(state.coffees[0])}
        )
        CoffeeList(
            coffees = state.coffees,
//            onClick = navigateToDetails
        )
    }
}