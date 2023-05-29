package com.example.groceryshoppingapp.viewModel.state

data class AppState(
    val isLoading: Boolean = false,
    val error: String? = null
)