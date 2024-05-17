package com.example.unicum.presentation.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.unicum.domain.model.Coffee
import com.example.unicum.presentation.common.RuneroBox
import com.example.unicum.presentation.screens.home.components.CoffeeList

@Composable
fun HomeScreen(
    state: HomeState,
    navigateToDetails: (Coffee) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        RuneroBox()
        CoffeeList(
            coffees = state.coffees,
            onClick = navigateToDetails
        )
    }
}