package com.example.groceryshoppingapp.utiles

import androidx.compose.runtime.Composable
import com.example.groceryshoppingapp.ui.compose.tabScreens.CategoryScreen
import com.example.groceryshoppingapp.ui.compose.tabScreens.FavoriteScreen
import com.example.groceryshoppingapp.ui.compose.tabScreens.ProfileScreen
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

typealias ComposableFun = @Composable () -> Unit
val navigator: DestinationsNavigator = TODO()

sealed class TabItems(var title: String, var screen: ComposableFun) {

    object Category : TabItems("Category", { CategoryScreen(navigator = navigator) })
    object Favorite : TabItems("Favorite", { FavoriteScreen() })
    object Profile : TabItems("Profile", { ProfileScreen(navigator = navigator) })
}
