package com.example.unicum.di

import android.app.Application
import androidx.room.Room
import com.example.unicum.data.local.CoffeeDao
import com.example.unicum.data.local.CoffeeDatabase
import com.example.unicum.data.repository.CoffeeRepositoryImpl
import com.example.unicum.domain.repository.CoffeeRepository
import com.example.unicum.domain.usecases.CoffeeUseCases
import com.example.unicum.domain.usecases.InsertCoffees
import com.example.unicum.domain.usecases.SelectCoffee
import com.example.unicum.domain.usecases.SelectCoffees
import com.example.unicum.domain.usecases.UpdateCoffee
import com.example.unicum.utils.Constants.COFFEE_DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideCoffeeRepository(
        coffeeDao: CoffeeDao
    ): CoffeeRepository = CoffeeRepositoryImpl(coffeeDao = coffeeDao)

    @Provides
    @Singleton
    fun provideCoffeeUseCases(
        coffeeRepository: CoffeeRepository,
        coffeeDao: CoffeeDao
    ): CoffeeUseCases {
        return CoffeeUseCases(
            coffeeRepository = coffeeRepository,
            updateCoffee = UpdateCoffee(coffeeDao),
            insertCoffees = InsertCoffees(coffeeDao),
            selectCoffees = SelectCoffees(coffeeDao),
            selectCoffee = SelectCoffee(coffeeDao)
        )
    }

    @Provides
    @Singleton
    fun provideCoffeesDatabase(
        application: Application
    ): CoffeeDatabase {
        return Room.databaseBuilder(
            context = application,
            klass = CoffeeDatabase::class.java,
            name = COFFEE_DATABASE_NAME
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideCoffeeDao(
        coffeeDatabase: CoffeeDatabase
    ): CoffeeDao = coffeeDatabase.coffeeDao
}