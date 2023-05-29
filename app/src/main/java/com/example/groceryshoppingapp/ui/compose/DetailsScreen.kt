package com.example.groceryshoppingapp.ui.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.groceryshoppingapp.R
import com.example.groceryshoppingapp.ui.theme.*
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun DetailsScreen(navigator: DestinationsNavigator) {
    val systemUiController = rememberSystemUiController()
    systemUiController.setSystemBarsColor(color = TaskBarColor)

    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Box(modifier = Modifier.fillMaxWidth()) {
            TopAppBar(contentColor = Color.White,
                backgroundColor = SplashColor, title = {
                    Text(text = "Grocery App Deals")
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
                    Icon(
                        Icons.Default.FavoriteBorder,
                        contentDescription = "favorite",
                        modifier = Modifier
                            .padding(end = 10.dp)
                            .clickable {

                            },
                        tint = Color.White
                    )
                })
        }

        Spacer(modifier = Modifier.height(20.dp))

        Image(
            painter = painterResource(id = R.drawable.ic_fd1),
            contentDescription = "category image",
            modifier = Modifier
                .width(207.dp)
                .height(140.dp)
        )

        Spacer(modifier = Modifier.height(5.dp))

        Box(
            modifier = Modifier
                .width(36.dp)
                .height(20.dp)
                .clip(RoundedCornerShape(2.dp))
                .background(color = BackgroundContainer)
        ) {
            Text(
                text = "1KG",
                fontSize = 10.sp,
                color = TextCard,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.align(
                    Alignment.Center
                )
            )
        }

        Spacer(modifier = Modifier.height(20.dp))
        Text(text = "Bell Pepper Red", fontWeight = FontWeight.Medium, fontSize = 24.sp)

        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Rs.1,100.00",
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            color = TextCard
        )

        Spacer(modifier = Modifier.height(50.dp))
        Text(text = "Quantity", fontWeight = FontWeight.Medium, fontSize = 16.sp, color = TextCard)
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .clip(shape = CircleShape)
                    .width(50.dp)
                    .height(50.dp)
                    .background(color = CircularColor2)
                    .clickable {

                    }
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_minus),
                    contentDescription = "Minimize",
                    tint = Color.White,
                    modifier = Modifier
                        .align(Alignment.Center)
                )
            }


            Spacer(modifier = Modifier.width(60.dp))
            Text(text = "2", fontSize = 30.sp, fontWeight = FontWeight.Bold, color = Text2)

            Spacer(modifier = Modifier.width(60.dp))
            Box(
                modifier = Modifier
                    .clip(shape = CircleShape)
                    .width(50.dp)
                    .height(50.dp)
                    .background(color = CircularColor2)
                    .clickable {

                    }
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_add),
                    contentDescription = "Add",
                    tint = Color.White,
                    modifier = Modifier
                        .align(Alignment.Center)
                )
            }

        }

        Spacer(modifier = Modifier.height(100.dp))
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Box(
                modifier = Modifier
                    .shadow(elevation = 5.dp, shape = RoundedCornerShape(4.dp))
                    .width(134.dp)
                    .height(36.dp)
                    .background(color = SplashColor)
            ) {
                Text(
                    text = "BUY NOW",
                    fontWeight = FontWeight.Medium,
                    fontSize = 14.sp,
                    color = Color.White,
                    modifier = Modifier.align(Alignment.Center)
                )
            }


            Spacer(modifier = Modifier.height(5.dp))
            Box(
                modifier = Modifier
                    .width(134.dp)
                    .height(36.dp)
            ) {
                Text(
                    text = "ADD TO CART",
                    fontWeight = FontWeight.Medium,
                    fontSize = 14.sp,
                    color = SplashColor,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }
    }
}

//@Composable
//fun Greeting5(name: String) {
//    DetailsScreen()
//}
//
//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    GroceryShoppingAppTheme {
//        Greeting5("Android")
//    }
//}