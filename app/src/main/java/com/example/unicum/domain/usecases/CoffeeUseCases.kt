package com.example.unicum.domain.usecases

import com.example.unicum.domain.repository.CoffeeRepository

data class CoffeeUseCases(
    val coffeeRepository: CoffeeRepository,
    val updateCoffee: UpdateCoffee,
    val insertCoffees: InsertCoffees,
    val selectCoffees: SelectCoffees,
    val selectCoffee: SelectCoffee
)