package com.example.groceryshoppingapp.ui.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import com.example.groceryshoppingapp.R
import com.example.groceryshoppingapp.ui.compose.destinations.SignInScreenDestination
import com.example.groceryshoppingapp.ui.compose.destinations.SignUpScreenDestination
import com.example.groceryshoppingapp.ui.theme.SplashColor
import com.example.groceryshoppingapp.ui.theme.TaskBarColor
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination(start = true)
@Composable
fun SplashScreen(navigator: DestinationsNavigator) {
    val systemUiController = rememberSystemUiController()
    systemUiController.setSystemBarsColor(color = TaskBarColor)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(SplashColor)
    ) {

        val constraint = ConstraintSet {
            val image1 = createRefFor("image1")
            val image2 = createRefFor("image2")
            val image3 = createRefFor("image3")

            constrain(image1) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
            constrain(image2) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
            constrain(image3) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
//                width = Dimension.value(50.dp)
//                height = Dimension.value(50.dp)
            }
        }

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            ConstraintLayout(
                constraint, modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 150.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_path1),
                    contentDescription = "path1",
                    modifier = Modifier.layoutId("image1")
                )
                Image(
                    painter = painterResource(id = R.drawable.ic_path3),
                    contentDescription = "path3",
                    modifier = Modifier
                        .layoutId("image3")
                        .padding(top = 10.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.ic_path2),
                    contentDescription = "path2",
                    modifier = Modifier
                        .layoutId("image2")
                        .padding(top = 40.dp)
                )
            }

            Text(
                text = "Welcome to \n Grocery shopping",
                style = TextStyle(
                    fontSize = 20.sp,
                    color = Color.White,
                    textAlign = TextAlign.Center
                ),
                modifier = Modifier.padding(top = 150.dp)
            )

            Spacer(modifier = Modifier.height(50.dp))

            Box(
                modifier = Modifier
                    .shadow(elevation = 5.dp, shape = RoundedCornerShape(4.dp))
                    .clickable {
                        navigator.navigate(SignInScreenDestination)
                    }
                    .background(color = Color.White)
                    .width(136.dp)
                    .height(36.dp)

            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "SIGN IN",
                        style = TextStyle(
                            color = SplashColor,
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Bold,
                            fontSize = 14.sp,
                        )
                    )
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(4.dp))
                    .clickable {
                        navigator.navigate(SignUpScreenDestination)
                    }
                    .width(136.dp)
                    .height(36.dp)

            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "SIGN UP",
                        style = TextStyle(
                            color = Color.White,
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Bold,
                            fontSize = 14.sp,
                        )
                    )
                }
            }

        }
    }
}
