package com.example.unicum.presentation.screens.home

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.unicum.domain.model.Coffee
import com.example.unicum.domain.usecases.CoffeeUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.count
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val coffeeUseCases: CoffeeUseCases
) : ViewModel() {

    private val _state = mutableStateOf(HomeState())
    val state: State<HomeState> = _state

    init {
//        deleteCoffee()
        insertCoffee()
        getCoffees()
    }

//    private fun deleteCoffee() {
//        viewModelScope.launch {
//            coffeeUseCases.deleteCoffees.invoke()
//        }
//    }

    private fun insertCoffee() {
        val coffee = Coffee(
            name = "Капучино эконом",
            price = 199,
            sellFree = false,
            viewGlass = 0
        )
        val listCoffee = MutableList(15) { coffee }
        viewModelScope.launch {
            val coffeeCount = coffeeUseCases.selectCoffees.invoke().count()
            Log.d("MYTAGS", "$coffeeCount")
            if (coffeeCount == 0) {
                coffeeUseCases.insertCoffees(listCoffee)
            }
        }
    }

    private fun getCoffees() {
        coffeeUseCases.selectCoffees().onEach {
            _state.value = _state.value.copy(coffees = it)
        }.launchIn(viewModelScope)
    }
}