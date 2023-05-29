package com.example.groceryshoppingapp.ui.compose.tabScreens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.example.groceryshoppingapp.R
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.groceryshoppingapp.ui.compose.customItems.Categories
import com.example.groceryshoppingapp.ui.compose.customItems.Deals
import com.example.groceryshoppingapp.ui.compose.customItems.Members
import com.example.groceryshoppingapp.ui.theme.Text1
import com.example.groceryshoppingapp.ui.theme.Text2
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun CategoryScreen(navigator: DestinationsNavigator) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {

        Column(modifier = Modifier.fillMaxSize()) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
                    .shadow(
                        elevation = 20.dp,
                        shape = RoundedCornerShape(bottomEnd = 15.dp, bottomStart = 15.dp)
                    )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(start = 10.dp, top = 10.dp)
                ) {
                    Text(
                        text = "All Categories",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )

                    Categories(navigator = navigator)
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
            Box(modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp)) {
                Text(
                    text = "Grocery App Member Deals",
                    fontSize = 14.sp,
                    color = Text2,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.align(
                        Alignment.CenterStart
                    )
                )

                Text(
                    text = "View all",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = Text1,
                    modifier = Modifier.align(Alignment.CenterEnd)
                )
            }

            Members(navigator = navigator)

            Spacer(modifier = Modifier.height(20.dp))
            Box(modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp)) {
                Text(
                    text = "Grocery App Deals",
                    fontSize = 14.sp,
                    color = Text2,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.align(
                        Alignment.CenterStart
                    )
                )

                Text(
                    text = "View all",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = Text1,
                    modifier = Modifier.align(Alignment.CenterEnd)
                )
            }

            Deals()

        }

    }
}

//@Composable
//fun Greeting5(name: String) {
//    CategoryScreen()
//}
//
//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    GroceryShoppingAppTheme {
//        Greeting5("Android")
//    }
//}