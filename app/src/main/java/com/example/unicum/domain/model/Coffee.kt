package com.example.unicum.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Coffee(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    val name: String,
    val price: Int,
    val sellFree: Boolean,
    val viewGlass: Int
)
