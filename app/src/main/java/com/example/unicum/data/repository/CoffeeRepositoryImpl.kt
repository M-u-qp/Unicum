package com.example.unicum.data.repository

import com.example.unicum.domain.model.Coffee
import com.example.unicum.domain.repository.CoffeeRepository
import kotlinx.coroutines.flow.Flow

class CoffeeRepositoryImpl: CoffeeRepository {
    override suspend fun upsertCoffee(coffee: Coffee) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteCoffee(coffee: Coffee) {
        TODO("Not yet implemented")
    }

    override fun getCoffees(): Flow<List<Coffee>> {
        TODO("Not yet implemented")
    }

}