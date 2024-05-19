package com.example.unicum.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.unicum.domain.model.Coffee
import kotlinx.coroutines.flow.Flow

@Dao
interface CoffeeDao {

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(listCoffee: List<Coffee>)

    @Insert
    suspend fun insert(listCoffee: List<Coffee>)

    @Query("DELETE FROM Coffee")
    fun deleteAll()

    @Query("SELECT * FROM Coffee")
    fun getCoffees(): Flow<List<Coffee>>

    @Query("SELECT * FROM Coffee WHERE id=:id")
    suspend fun getCoffee(id: Int): Coffee?
}