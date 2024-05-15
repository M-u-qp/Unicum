package com.example.unicum.domain.usecases

import com.example.unicum.data.local.CoffeeDao
import com.example.unicum.domain.model.Coffee

class DeleteCoffee(
    private val coffeeDao: CoffeeDao
) {
    suspend operator fun invoke(coffee: Coffee){
        coffeeDao.delete(coffee)
    }
}