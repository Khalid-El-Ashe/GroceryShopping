package com.example.groceryshoppingapp.ui.compose.tabScreens

import androidx.compose.runtime.Composable
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@ExperimentalPagerApi
@Composable
fun TabsContent(pagerState: PagerState, navigator: DestinationsNavigator) {
    HorizontalPager(state = pagerState, dragEnabled = false) { page ->
        when (page) {
            0 -> CategoryScreen(navigator = navigator)
            1 -> FavoriteScreen()
            2 -> ProfileScreen(navigator = navigator)
        }
    }
}
