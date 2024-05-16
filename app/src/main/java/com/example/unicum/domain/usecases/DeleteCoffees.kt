package com.example.unicum.domain.usecases

import com.example.unicum.data.local.CoffeeDao

class DeleteCoffees(
    private val coffeeDao: CoffeeDao
) {
     operator fun invoke(){
        coffeeDao.deleteAll()
    }
}