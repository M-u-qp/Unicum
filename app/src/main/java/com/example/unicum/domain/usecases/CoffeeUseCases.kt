package com.example.unicum.domain.usecases

import com.example.unicum.domain.repository.CoffeeRepository

data class CoffeeUseCases(
    val coffeeRepository: CoffeeRepository,
    val upsertCoffee: UpsertCoffee,
    val deleteCoffee: DeleteCoffee,
    val selectCoffees: SelectCoffees
)