package com.example.unicum.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.unicum.domain.model.Coffee
import kotlinx.coroutines.flow.Flow

@Dao
interface CoffeeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(coffee: Coffee)

    @Delete
    suspend fun delete(coffee: Coffee)

    @Query("SELECT * FROM Coffee")
    fun getCoffees(): Flow<List<Coffee>>
}