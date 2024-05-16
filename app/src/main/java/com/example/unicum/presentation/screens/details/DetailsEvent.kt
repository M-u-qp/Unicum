package com.example.unicum.presentation.screens.details

import com.example.unicum.domain.model.Coffee

sealed class DetailsEvent {

    data class UpdateCoffee(val coffee: Coffee) : DetailsEvent()

    data object RemoveSideEffect : DetailsEvent()
}