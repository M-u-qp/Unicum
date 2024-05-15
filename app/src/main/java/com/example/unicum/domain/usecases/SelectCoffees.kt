package com.example.unicum.domain.usecases

import com.example.unicum.data.local.CoffeeDao
import com.example.unicum.domain.model.Coffee
import kotlinx.coroutines.flow.Flow

class SelectCoffees(
    private val coffeeDao: CoffeeDao
) {
     operator fun invoke() : Flow<List<Coffee>> {
       return coffeeDao.getCoffees()
    }
}