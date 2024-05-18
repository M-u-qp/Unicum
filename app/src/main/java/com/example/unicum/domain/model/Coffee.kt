package com.example.unicum.domain.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity
data class Coffee(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var name: String,
    var price: Int,
    var sellFree: Boolean,
    var viewGlass: Int
) : Parcelable
