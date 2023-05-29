package com.example.groceryshoppingapp.viewModel

import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.groceryshoppingapp.utiles.Constants.INTRODUCTION_KEY
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class IntroductionViewModel @Inject constructor(private val sharedPreferences: SharedPreferences, val firebaseAuth: FirebaseAuth): ViewModel() {

    private val _navigate = MutableStateFlow(0)
    val navigate: StateFlow<Int> =_navigate

    companion object {
        const val STORE_SCREEN = 3
    }

    init {
        val isButtonClick = sharedPreferences.getBoolean(INTRODUCTION_KEY, false)
        val user = firebaseAuth.currentUser

        if (user != null){
            viewModelScope.launch {
                _navigate.emit(STORE_SCREEN)
            }
        } else {
            Unit
        }
    }

    fun startToStoreScreen(){
        sharedPreferences.edit().putBoolean(INTRODUCTION_KEY, true).apply()
    }
}