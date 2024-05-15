package com.example.unicum.domain.repository

import com.example.unicum.domain.model.Coffee
import kotlinx.coroutines.flow.Flow

interface CoffeeRepository {

    suspend fun upsertCoffee(coffee: Coffee)
    suspend fun deleteCoffee(coffee: Coffee)
    fun getCoffees(): Flow<List<Coffee>>
}