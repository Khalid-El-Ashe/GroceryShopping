package com.example.groceryshoppingapp.ui.compose

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.groceryshoppingapp.ui.compose.destinations.ForgotPasswordScreenDestination
import com.example.groceryshoppingapp.ui.compose.destinations.StoreScreenDestination
import com.example.groceryshoppingapp.ui.theme.*
import com.example.groceryshoppingapp.utiles.Resource
import com.example.groceryshoppingapp.viewModel.SignInViewModel
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.google.firebase.auth.FirebaseAuth
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import kotlinx.coroutines.launch

@SuppressLint("CoroutineCreationDuringComposition")
@Destination
@Composable
fun SignInScreen(navigator: DestinationsNavigator) {
    val firebaseAuth = FirebaseAuth.getInstance()

    var systemUiController = rememberSystemUiController()
    systemUiController.setSystemBarsColor(color = StatusBarColor)

    val context = LocalContext.current

    val viewModel = hiltViewModel<SignInViewModel>()

    val scop = rememberCoroutineScope()

    var emailInputRefresh by remember {
        mutableStateOf("")
    }
    var passwordInputRefresh by remember {
        mutableStateOf("")
    }
    var passwordVisible by rememberSaveable { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(ContentBackgroundColor)
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(356.dp)
                .background(color = Color.White)
                .shadow(
                    elevation = 5.dp,
                    shape = RoundedCornerShape(bottomStart = 15.dp, bottomEnd = 15.dp)
                )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 10.dp, end = 10.dp)
            ) {
                Spacer(modifier = Modifier.height(5.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Text(
                        text = "Sign in",
                        style = TextStyle(
                            fontSize = 17.sp,
                            color = SplashColor,
                            fontWeight = FontWeight.Bold
                        ),
                        modifier = Modifier.align(Alignment.TopStart)
                    )

                    Text(
                        text = "Sign up",
                        style = TextStyle(
                            fontSize = 17.sp,
                            color = Text1,
                            fontWeight = FontWeight.Bold
                        ),
                        modifier = Modifier.align(Alignment.TopEnd)
                    )
                }

                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "Sign in to Grocery App",
                    style = TextStyle(fontSize = 24.sp),
                )
                Spacer(modifier = Modifier.height(5.dp))

                Text(
                    text = "Enter email & password to continue",
                    style = TextStyle(fontSize = 16.sp, color = Text1)
                )

                Spacer(modifier = Modifier.height(10.dp))

                TextField(
                    value = emailInputRefresh,
                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Email),
                    onValueChange = { emailInputRefresh = it },
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

                        .fillMaxWidth()
                )


                Spacer(modifier = Modifier.height(15.dp))

                TextField(
                    value = passwordInputRefresh,
                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Password),
                    onValueChange = { passwordInputRefresh = it },
                    placeholder = {
                        Text(
                            text = "Password",
                            style = TextStyle(fontSize = 16.sp, color = Text1)
                        )
                    },
                    visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = Color.White
                    ),
                    modifier = Modifier

                        .fillMaxWidth(),
                    trailingIcon = {
                        val image = if (passwordVisible)
                            Icons.Filled.Visibility
                        else Icons.Filled.VisibilityOff

                        val description = if (passwordVisible) "Hide password" else "Show password"

                        IconButton(onClick = { passwordVisible = !passwordVisible }) {
                            Icon(imageVector = image, description)
                        }
                    }
                )

                Spacer(modifier = Modifier.height(35.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 10.dp, end = 10.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Forgot password?",
                        fontSize = 16.sp,
                        color = Text1,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.clickable {
                            navigator.navigate(ForgotPasswordScreenDestination)
                        }
                    )
                    Spacer(modifier = Modifier.width(120.dp))
                    Box(
                        modifier = Modifier
//                            .align(Alignment.End)
                            .shadow(elevation = 15.dp, shape = RoundedCornerShape(4.dp))
                            .clickable {

                                if (emailInputRefresh.isEmpty() || passwordInputRefresh.isEmpty()) {
                                    Toast
                                        .makeText(
                                            context,
                                            "you must to validate to values",
                                            Toast.LENGTH_LONG
                                        )
                                        .show()
                                } else {
                                    try {
                                        viewModel.signIn(
                                            email = emailInputRefresh,
                                            password = passwordInputRefresh
                                        )
                                    } catch (e: Exception) {
                                        Toast
                                            .makeText(
                                                context,
                                                "something is wrong",
                                                Toast.LENGTH_SHORT
                                            )
                                            .show()
                                    }
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
                                text = "SIGN IN",
                                style = TextStyle(
                                    color = Color.White,
                                    textAlign = TextAlign.Center,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 14.sp,
                                )
                            )
                        }
                    }

                    scop.launch {
                        viewModel.signIn.collect {
                            when(it){
                                is  Resource.Loading -> {
                                }
                                is  Resource.Success -> {
                                    navigator.navigate(StoreScreenDestination)
                                }
                                is  Resource.Error -> {
                                    Toast.makeText(context, it.message.toString(), Toast.LENGTH_SHORT).show()
                                }
                                else -> Unit
                            }
                        }
                    }

                }
            }
        }
    }

    scop.launch {
        if (firebaseAuth.uid != null){
            navigator.navigate(StoreScreenDestination)
        }
    }
}

