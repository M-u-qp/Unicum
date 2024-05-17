package com.example.unicum.presentation.screens.home.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.unicum.domain.model.Coffee
import com.example.unicum.presentation.Dimens.MediumPadding3

@Composable
fun CoffeeList(
    modifier: Modifier = Modifier,
    coffees: List<Coffee>,
    onClick: (Coffee) -> Unit
) {
    LazyVerticalGrid(
        modifier = modifier
            .fillMaxSize()
            .padding(MediumPadding3),
        columns = GridCells.Fixed(5)
    ) {
        items(count = coffees.size) {
            val coffee = coffees[it]
            CoffeeCard(
                coffee = coffee,
                onClick = { onClick(coffee) }
            )
        }
    }
}