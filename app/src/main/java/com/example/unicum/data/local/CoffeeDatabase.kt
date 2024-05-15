package com.example.unicum.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.unicum.domain.model.Coffee

@Database(entities = [Coffee::class], version = 1)
abstract class CoffeeDatabase: RoomDatabase() {

    abstract val coffeeDao: CoffeeDao
}