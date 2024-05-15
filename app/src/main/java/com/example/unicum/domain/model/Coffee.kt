package com.example.unicum.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Coffee(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val price: Int,
    val sellFree: Boolean,
    val viewGlass: Int
)
