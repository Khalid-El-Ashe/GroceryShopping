package com.example.groceryshoppingapp.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.groceryshoppingapp.utiles.Drink

@Dao
interface DrinkDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertDrink(drink: Drink)

    @Delete
    suspend fun deleteDrink(drink: Drink)

    @Query("select * from drinkTable")
    fun selectDrink(): LiveData<List<Drink>>
}