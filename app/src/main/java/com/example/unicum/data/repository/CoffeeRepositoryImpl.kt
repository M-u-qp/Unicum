package com.example.unicum.data.repository

import com.example.unicum.data.local.CoffeeDao
import com.example.unicum.domain.model.Coffee
import com.example.unicum.domain.repository.CoffeeRepository
import kotlinx.coroutines.flow.Flow

class CoffeeRepositoryImpl(
    private val coffeeDao: CoffeeDao
) : CoffeeRepository {
    override suspend fun updateCoffee(coffee: Coffee) {
        coffeeDao.update(coffee)
    }

    override suspend fun insertCoffees(listCoffee: List<Coffee>) {
        coffeeDao.insert(listCoffee)
    }

    override fun getCoffees(): Flow<List<Coffee>> {
        return coffeeDao.getCoffees()
    }

    override suspend fun getCoffee(id: Int): Coffee? {
        return coffeeDao.getCoffee(id)
    }
}