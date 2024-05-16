package com.example.unicum.presentation.screens.details

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.unicum.domain.model.Coffee
import com.example.unicum.domain.usecases.CoffeeUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val coffeeUseCases: CoffeeUseCases
): ViewModel() {

 var sideEffect by mutableStateOf<String?>(null)
     private set
    fun onEvent(event: DetailsEvent){
        when(event){
            is DetailsEvent.UpdateCoffee -> {
                viewModelScope.launch {
                    val coffee = coffeeUseCases.selectCoffee(event.coffee.id)
                    if (coffee == null) updateCoffee(event.coffee)
                }
            }
            is DetailsEvent.RemoveSideEffect -> {
                sideEffect = null
            }
        }
    }

    private suspend fun updateCoffee(coffee: Coffee) {
        coffeeUseCases.updateCoffee(coffee)
        sideEffect = "Coffee Save"
    }
}