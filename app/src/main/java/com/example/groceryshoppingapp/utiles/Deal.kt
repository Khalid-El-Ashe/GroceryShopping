package com.example.groceryshoppingapp.utiles

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "dealTable")
data class Deal(
    @PrimaryKey (autoGenerate = true)
    val dealId: Int? = null,
    val dealGram: String,
    val dealImage: Int,
    val dealName: String,
    val dealSalary: Double
)
