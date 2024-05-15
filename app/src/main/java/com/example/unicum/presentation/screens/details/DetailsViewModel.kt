package com.example.unicum.presentation.screens.details

import androidx.lifecycle.ViewModel
import com.example.unicum.domain.usecases.CoffeeUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val coffeeUseCases: CoffeeUseCases
): ViewModel() {

}