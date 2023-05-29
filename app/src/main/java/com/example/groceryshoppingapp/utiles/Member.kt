package com.example.groceryshoppingapp.utiles

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "memberTable")

data class Member(
    @PrimaryKey(autoGenerate = true)
    val memberId: Int,
    val memberGram: String,
    val memberImage: Int,
    val memberName: String,
    val memberSalary: Double
): java.io.Serializable
