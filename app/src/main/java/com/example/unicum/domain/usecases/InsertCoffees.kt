package com.example.unicum.domain.usecases

import com.example.unicum.data.local.CoffeeDao
import com.example.unicum.domain.model.Coffee

class InsertCoffees(
    private val coffeeDao: CoffeeDao
) {
    suspend operator fun invoke(listCoffee: List<Coffee>){
        coffeeDao.insert(listCoffee)
    }
}