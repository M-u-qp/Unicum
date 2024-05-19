package com.example.unicum.domain.repository

import com.example.unicum.domain.model.Coffee
import kotlinx.coroutines.flow.Flow

interface CoffeeRepository {

   suspend fun updateCoffee(listCoffee: List<Coffee>)

   suspend fun insertCoffees(listCoffee: List<Coffee>)
    fun getCoffees(): Flow<List<Coffee>>
    suspend fun getCoffee(id: Int): Coffee?
}