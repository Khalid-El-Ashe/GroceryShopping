package com.example.groceryshoppingapp.utiles

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "drinkTable")
data class Drink(
    @PrimaryKey(autoGenerate = true)
    val drinkId: Int,
    val drinkGram: String,
    val drinkImage: Int,
    val drinkName: String,
    val drinkSalary: Double
)
