package com.example.unicum.presentation.screens.home

import com.example.unicum.domain.model.Coffee

data class HomeState(
    val coffees: List<Coffee> = emptyList()
)