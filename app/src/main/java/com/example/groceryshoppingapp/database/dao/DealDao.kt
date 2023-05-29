package com.example.groceryshoppingapp.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.groceryshoppingapp.utiles.Deal
import kotlinx.coroutines.flow.Flow

@Dao
interface DealDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertDeal(deal: Deal)

    @Delete
    suspend fun deleteDeal(deal: Deal)

    @Query("select * from dealTable")
    fun selectDeal(): Flow<List<Deal>>
}