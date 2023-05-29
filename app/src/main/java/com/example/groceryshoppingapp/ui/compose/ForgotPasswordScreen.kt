package com.example.groceryshoppingapp.ui.compose

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.groceryshoppingapp.R
import com.example.groceryshoppingapp.ui.compose.categories.DrinkScreen
import com.example.groceryshoppingapp.ui.compose.destinations.StoreScreenDestination
import com.example.groceryshoppingapp.ui.theme.ContentBackgroundColor
import com.example.groceryshoppingapp.ui.theme.SplashColor
import com.example.groceryshoppingapp.ui.theme.Text1
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator


@Destination
@Composable
fun ForgotPasswordScreen(navigator: DestinationsNavigator) {
    val context = LocalContext.current

    var emailInputRefresh by remember {
        mutableStateOf("")
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(ContentBackgroundColor)
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(312.dp)
                .background(color = Color.White)
                .shadow(
                    elevation = 5.dp,
                    shape = RoundedCornerShape(bottomStart = 15.dp, bottomEnd = 15.dp)
                )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                TopAppBar(contentColor = Color.White, backgroundColor = SplashColor) {
                    Box(modifier = Modifier.fillMaxSize()) {
                        Text(
                            text = "Forgot password",
                            style = TextStyle(
                                color = Color.White,
                                fontWeight = FontWeight.Bold,
                                fontSize = 20.sp,
                            ),
                            modifier = Modifier.align(Alignment.Center)
                        )
                        IconButton(onClick = {

                        }) {
                            Column(
                                modifier = Modifier.fillMaxHeight(),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_back),
                                    contentDescription = "Back",
                                    modifier = Modifier.clickable {
                                        navigator.navigateUp()
                                    }
                                )
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "Password reset",
                    style = TextStyle(fontSize = 24.sp),
                    modifier = Modifier.padding(start = 10.dp, end = 10.dp)
                )
                Spacer(modifier = Modifier.height(5.dp))

                Text(
                    text = "Enter email address to send reset code",
                    style = TextStyle(fontSize = 16.sp, color = Text1),
                    modifier = Modifier.padding(start = 10.dp, end = 10.dp)
                )

                Spacer(modifier = Modifier.height(10.dp))

                TextField(
                    value = emailInputRefresh,
                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Email),
                    onValueChange = { emailaddress -> emailInputRefresh = emailaddress },
                    placeholder = {
                        Text(
                            text = "Email address",
                            style = TextStyle(fontSize = 16.sp, color = Text1)
                        )
                    },
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = Color.White
                    ),
                    modifier = Modifier
                        .padding(start = 10.dp, end = 10.dp)
                        .fillMaxWidth()
                )


                Spacer(modifier = Modifier.height(15.dp))

                Box(
                    modifier = Modifier
                        .align(Alignment.End)
                        .padding(start = 10.dp, end = 10.dp)
                        .shadow(elevation = 15.dp, shape = RoundedCornerShape(4.dp))
                        .clickable {
                            if (emailInputRefresh.isEmpty()) {
                                Toast
                                    .makeText(
                                        context,
                                        "you must to validate to values",
                                        Toast.LENGTH_LONG
                                    )
                                    .show()
                            } else {
                                navigator.navigate(StoreScreenDestination)
                                Toast
                                    .makeText(context, "success sign in", Toast.LENGTH_SHORT)
                                    .show()
                            }
                        }
                        .background(color = SplashColor)
                        .width(94.dp)
                        .height(36.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxSize(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "SEND",
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
}
