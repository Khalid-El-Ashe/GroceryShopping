package com.example.groceryshoppingapp.ui.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.groceryshoppingapp.R
import com.example.groceryshoppingapp.ui.theme.SplashColor
import com.example.groceryshoppingapp.ui.theme.Text1
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun SearchScreen(navigator: DestinationsNavigator) {
    var searchText by remember {
        mutableStateOf("")
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {

        TextField(
            value = searchText,
            textStyle = TextStyle(
                fontWeight = FontWeight.Bold,
                color = Color.White,
                fontSize = 15.sp
            ),
            placeholder = {
                Text(
                    text = "Search",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            },
            onValueChange = { search -> searchText = search },
            modifier = Modifier
                .fillMaxWidth()
                .background(color = SplashColor)
                .align(Alignment.TopStart),
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_search),
                    contentDescription = "search",
                    tint = Color.White,
                )
            },
            trailingIcon = {
                Icon(
                    imageVector = Icons.Default.Close,
                    contentDescription = "search",
                    tint = Color.White,
                    modifier = Modifier.clickable {
                        navigator.navigateUp()
                    }
                )
            }
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center), horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_no_search_result),
                contentDescription = "no result"
            )
            Text(text = "No search result found!", fontSize = 16.sp, color = Text1)
        }

    }
}