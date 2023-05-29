package com.example.groceryshoppingapp.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.groceryshoppingapp.database.GroceryRepository
import com.example.groceryshoppingapp.utiles.Deal
import com.example.groceryshoppingapp.utiles.Drink
import com.example.groceryshoppingapp.utiles.Member
import dagger.hilt.android.lifecycle.HiltViewModel
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import com.example.groceryshoppingapp.viewModel.state.DealState
import com.example.groceryshoppingapp.viewModel.state.GetDeal
import com.example.groceryshoppingapp.viewModel.state.GetMember
import com.example.groceryshoppingapp.viewModel.state.MemberState
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GroceryViewModel @Inject constructor(val groceryRepository: GroceryRepository, getDeal: GetDeal, getMember: GetMember) : ViewModel() {

    private val _dealState = mutableStateOf(DealState())
    val dealState: State<DealState> = _dealState

    private val _memberState = mutableStateOf(MemberState())
    val memberState: State<MemberState> = _memberState

    init {
        getDeal().onEach {
            _dealState.value = dealState.value.copy(deals = it)
        }.launchIn(viewModelScope)

        getMember().onEach {
            _memberState.value = memberState.value.copy(members = it)
        }.launchIn(viewModelScope)

    }

    fun upsertDeal(deal: Deal) {
        viewModelScope.launch {
            groceryRepository.upsertDeal(deal = deal)
        }
    }

    fun deleteDeal(deal: Deal) {
        viewModelScope.launch {
            groceryRepository.deleteDeal(deal = deal)
        }
    }

//    fun selectDeal(): LiveData<List<Deal>> {
//        return groceryRepository.selectDeal()
//    }

    fun upsertDrink(drink: Drink) {
        viewModelScope.launch {
            groceryRepository.upsertDrink(drink = drink)
        }
    }

    fun deleteDrink(drink: Drink) {
        viewModelScope.launch {
            groceryRepository.deleteDrink(drink = drink)
        }
    }

    fun selectDrink(): LiveData<List<Drink>> {
        return groceryRepository.selectDrink()
    }

    fun upsertMember(member: Member) {
        viewModelScope.launch {
            groceryRepository.upsertMember(member = member)
        }
    }

    fun deleteMember(member: Member) {
        viewModelScope.launch {
            groceryRepository.deleteMember(member = member)
        }
    }

//    fun selectMember(): LiveData<List<Member>> {
//        return groceryRepository.selectMember()
//    }

}