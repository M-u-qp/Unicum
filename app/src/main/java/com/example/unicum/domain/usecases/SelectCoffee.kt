package com.example.unicum.domain.usecases

import com.example.unicum.data.local.CoffeeDao
import com.example.unicum.domain.model.Coffee

class SelectCoffee(
    private val coffeeDao: CoffeeDao
) {
    suspend operator fun invoke(id: Int): Coffee? {
        return coffeeDao.getCoffee(id)
    }
}