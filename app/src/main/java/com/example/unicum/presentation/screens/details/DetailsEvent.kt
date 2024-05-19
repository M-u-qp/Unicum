package com.example.unicum.presentation.screens.details

import com.example.unicum.domain.model.Coffee

sealed class DetailsEvent {

    data class UpdateCoffee(val listCoffee: List<Coffee>) : DetailsEvent()

    data object RemoveSideEffect : DetailsEvent()
}