package com.example.unicum.presentation.screens.home.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.unicum.domain.model.Coffee
import com.example.unicum.presentation.Dimens.MediumPadding1

@Composable
fun CoffeeList(
    modifier: Modifier = Modifier,
    coffees: List<Coffee>,
    onClick: (Coffee) -> Unit
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = MediumPadding1
            )
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