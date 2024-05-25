package com.example.unicum.presentation.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.unit.IntSize
import com.example.unicum.domain.model.Coffee
import com.example.unicum.presentation.common.RuneroBox
import com.example.unicum.presentation.screens.home.components.CoffeeList

@Composable
fun HomeScreen(
    state: HomeState,
    navigateToDetails: (Coffee) -> Unit,
    navigateUp: () -> Unit
) {
    val containerSize = remember { mutableStateOf(IntSize.Zero) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .onSizeChanged { containerSize.value = it }
    ) {
        RuneroBox(navigateUp, containerSize.value)
        CoffeeList(
            coffees = state.coffees,
            onClick = navigateToDetails
        )
    }
}