package com.example.groceryshoppingapp.database

import com.example.groceryshoppingapp.utiles.Deal
import com.example.groceryshoppingapp.utiles.Drink
import com.example.groceryshoppingapp.utiles.Member

class GroceryRepository(val database: GroceryDatabase) {

    suspend fun upsertDeal(deal: Deal) = database.dealDao().upsertDeal(deal = deal)
    suspend fun deleteDeal(deal: Deal) = database.dealDao().deleteDeal(deal = deal)
    fun selectDeal() = database.dealDao().selectDeal()

    suspend fun upsertDrink(drink: Drink) = database.drinkDao().upsertDrink(drink = drink)
    suspend fun deleteDrink(drink: Drink) = database.drinkDao().deleteDrink(drink = drink)
    fun selectDrink() = database.drinkDao().selectDrink()

    suspend fun upsertMember(member: Member) = database.memberDao().upsertMember(member = member)
    suspend fun deleteMember(member: Member) = database.memberDao().deleteMember(member = member)
    fun selectMember() = database.memberDao().selectMember()

}