package com.example.groceryshoppingapp.viewModel.state

import com.example.groceryshoppingapp.database.GroceryRepository
import com.example.groceryshoppingapp.utiles.Deal
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetDeal @Inject constructor(
    private val groceryRepository: GroceryRepository
) {

    operator fun invoke(): Flow<List<Deal>> {
        return groceryRepository.selectDeal()
    }
}