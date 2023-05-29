package com.example.groceryshoppingapp.ui.compose.categories

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.groceryshoppingapp.R
import com.example.groceryshoppingapp.ui.compose.destinations.AddItemScreenDestination
import com.example.groceryshoppingapp.ui.theme.SplashColor
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun ChilledScreen(navigator: DestinationsNavigator) {
    Column(modifier = Modifier.fillMaxSize()) {
        TopAppBar(
            contentColor = Color.White,
            backgroundColor = SplashColor,
            title = {
                Box(modifier = Modifier.fillMaxSize()) {
                    Text(text = "Chilled", modifier = Modifier.align(Alignment.CenterStart))
                }
            },
            navigationIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_back),
                    contentDescription = "Back", modifier = Modifier
                        .padding(start = 10.dp)
                        .clickable {
                            navigator.navigateUp()
                        }
                )
            }
        )
    }
}