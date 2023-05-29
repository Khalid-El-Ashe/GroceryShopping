package com.example.groceryshoppingapp.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.groceryshoppingapp.database.dao.DealDao
import com.example.groceryshoppingapp.database.dao.DrinkDao
import com.example.groceryshoppingapp.database.dao.MemberDao
import com.example.groceryshoppingapp.utiles.Deal
import com.example.groceryshoppingapp.utiles.Drink
import com.example.groceryshoppingapp.utiles.Member

@Database(entities = [Deal::class, Drink::class, Member::class], version = 1)
abstract class GroceryDatabase: RoomDatabase() {

    abstract fun dealDao(): DealDao
    abstract fun drinkDao(): DrinkDao
    abstract fun memberDao(): MemberDao
}