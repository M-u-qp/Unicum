package com.example.unicum.presentation.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.unicum.domain.model.Coffee
import com.example.unicum.presentation.Dimens.MediumPadding1
import com.example.unicum.presentation.screens.home.components.CoffeeList
import com.example.unicum.presentation.screens.home.components.RuneroBox

@Composable
fun HomeScreen(
    state: HomeState,
    navigateToDetails: (Coffee) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        RuneroBox()

        Spacer(modifier = Modifier.height(MediumPadding1))

        CoffeeList(
            coffees = state.coffees,
            onClick = navigateToDetails
        )
    }
}