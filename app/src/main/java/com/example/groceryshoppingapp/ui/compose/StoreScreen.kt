package com.example.groceryshoppingapp.ui.compose

import android.annotation.SuppressLint
import android.content.Intent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.groceryshoppingapp.ui.compose.tabScreens.TabsContent
import com.example.groceryshoppingapp.R
import com.example.groceryshoppingapp.ui.compose.destinations.SearchScreenDestination
import com.example.groceryshoppingapp.ui.compose.destinations.SignInScreenDestination
import com.example.groceryshoppingapp.ui.theme.SplashColor
import com.example.groceryshoppingapp.utiles.TabItems
import com.example.groceryshoppingapp.utiles.navigator
import com.google.accompanist.pager.*
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import kotlinx.coroutines.launch

@Destination
@OptIn(ExperimentalPagerApi::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun StoreScreen(navigator: DestinationsNavigator) {
    var showMenu by remember { mutableStateOf(false) }
    val pagerState = rememberPagerState(pageCount = 3)
    val context = LocalContext.current

    Column(modifier = Modifier.fillMaxSize()) {
        TopAppBar(
            contentColor = Color.White,
            backgroundColor = SplashColor,
            title = {
                Box(modifier = Modifier.fillMaxSize()) {
                    Text(text = "Store", modifier = Modifier.align(Alignment.CenterStart))
                }
            },
            actions = {
                IconButton(onClick = {
                    navigator.navigate(SearchScreenDestination)
                }) {
                    Icon(painter = painterResource(id = R.drawable.ic_search), contentDescription = "search")
                }
                IconButton(onClick = {

                }) {
                    Icon(painter = painterResource(id = R.drawable.ic_notification), contentDescription = "notification")
                }
            },
            navigationIcon = {
                IconButton(onClick = { showMenu = !showMenu }) {
                    Icon(Icons.Default.Menu, contentDescription = null)
                }
            }
        )

        DropdownMenu(expanded = showMenu, onDismissRequest = { showMenu = false }, modifier = Modifier.fillMaxWidth().padding(bottom = 50.dp)) {
            DropdownMenuItem(onClick = { /*TODO*/ }) {
                TopBarMenu(navigator = navigator)
            }
        }

        Tabs(pagerState = pagerState)
        TabsContent(pagerState = pagerState, navigator = navigator)
    }
}


@ExperimentalPagerApi
@Composable
fun Tabs(pagerState: PagerState) {
    val list = listOf(
        TabItems.Category,
        TabItems.Favorite,
        TabItems.Profile
    )

    val scope = rememberCoroutineScope()

    TabRow(
        selectedTabIndex = pagerState.currentPage,

        backgroundColor = SplashColor,

        contentColor = Color.White,

        indicator = { tabPositions ->
            TabRowDefaults.Indicator(
                Modifier.pagerTabIndicatorOffset(pagerState, tabPositions),
                height = 2.dp,
                color = Color.White
            )
        }
    ) {
        list.forEachIndexed { index, _ ->
            Tab(
                text = {
                    Text(
                        list[index].title,
                        color = if (pagerState.currentPage == index) Color.White else Color.LightGray
                    )
                },
                selected = pagerState.currentPage == index,
                onClick = {
                    // on below line we are specifying the scope.
                    scope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                },
            )
        }
    }
}
