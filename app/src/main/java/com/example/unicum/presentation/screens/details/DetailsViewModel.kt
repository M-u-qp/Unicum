package com.example.unicum.presentation.screens.details

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.unicum.domain.model.Coffee
import com.example.unicum.domain.usecases.CoffeeUseCases
import com.example.unicum.utils.UIComponent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val coffeeUseCases: CoffeeUseCases
): ViewModel() {

 var sideEffect by mutableStateOf<UIComponent?>(null)
     private set
    fun onEvent(event: DetailsEvent){
        when(event){
            is DetailsEvent.UpdateCoffee -> {
                viewModelScope.launch {
                    coffeeUseCases.selectCoffees().collect{
                        if (it.isNotEmpty()) updateCoffee(event.listCoffee)
                    }
                }
            }
            is DetailsEvent.RemoveSideEffect -> {
                sideEffect = null
            }
            else -> Unit
        }
    }

    private suspend fun updateCoffee(listCoffee: List<Coffee>) {
        coffeeUseCases.updateCoffee(listCoffee)
        sideEffect = UIComponent.Toast("Coffee Save")
    }
}