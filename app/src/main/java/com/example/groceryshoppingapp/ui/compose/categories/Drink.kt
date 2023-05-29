package com.example.groceryshoppingapp.ui.compose.categories

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.groceryshoppingapp.ui.theme.SplashColor
import com.example.groceryshoppingapp.ui.theme.TaskBarColor
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.example.groceryshoppingapp.R
import com.example.groceryshoppingapp.ui.compose.customItems.Drinks
import com.example.groceryshoppingapp.ui.compose.destinations.SearchScreenDestination
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun DrinkScreen(navigator: DestinationsNavigator) {
    val systemUiController = rememberSystemUiController()
    systemUiController.setSystemBarsColor(color = TaskBarColor)

    Column(modifier = Modifier.fillMaxSize()) {
        Box(modifier = Modifier.fillMaxWidth()) {
            TopAppBar(contentColor = Color.White,
                backgroundColor = SplashColor, title = {
                    Text(text = "Coffee")
                }, navigationIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_back),
                        contentDescription = "back", modifier = Modifier
                            .padding(start = 10.dp)
                            .clickable {
                                navigator.navigateUp()
                            }
                    )
                }, actions = {
                    IconButton(onClick = {
                        navigator.navigate(SearchScreenDestination)
                    }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_search),
                            contentDescription = "search",
                            modifier = Modifier
                                .padding(end = 10.dp),
                            tint = Color.White
                        )
                    }
                })
        }
        Drinks()
    }
}

//@Composable
//fun Greeting5(name: String) {
//    CoffeeScreen()
//}
//
//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    GroceryShoppingAppTheme {
//        Greeting5("Android")
//    }
//}