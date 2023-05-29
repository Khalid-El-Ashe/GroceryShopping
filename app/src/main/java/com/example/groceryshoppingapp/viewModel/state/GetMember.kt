package com.example.groceryshoppingapp.viewModel.state

import com.example.groceryshoppingapp.database.GroceryRepository
import com.example.groceryshoppingapp.utiles.Deal
import com.example.groceryshoppingapp.utiles.Member
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetMember @Inject constructor(
    private val groceryRepository: GroceryRepository
) {

    operator fun invoke(): Flow<List<Member>> {
        return groceryRepository.selectMember()
    }
}