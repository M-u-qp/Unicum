package com.example.unicum.domain.usecases

import com.example.unicum.data.local.CoffeeDao
import com.example.unicum.domain.model.Coffee

class UpsertCoffee(
    private val coffeeDao: CoffeeDao
) {
    suspend operator fun invoke(coffee: Coffee){
        coffeeDao.upsert(coffee)
    }
}