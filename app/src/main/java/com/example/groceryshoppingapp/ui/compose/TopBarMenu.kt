package com.example.groceryshoppingapp.ui.compose

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.groceryshoppingapp.ui.theme.CircularColor
import com.example.groceryshoppingapp.ui.theme.GroceryShoppingAppTheme
import com.example.groceryshoppingapp.ui.theme.Text1
import com.ramcosta.composedestinations.annotation.Destination
import com.example.groceryshoppingapp.R
import com.example.groceryshoppingapp.ui.compose.destinations.AddItemScreenDestination
import com.example.groceryshoppingapp.ui.compose.destinations.SplashScreenDestination
import com.example.groceryshoppingapp.ui.theme.SplashColor
import com.example.groceryshoppingapp.utiles.navigator
import com.google.firebase.auth.FirebaseAuth
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun TopBarMenu(navigator: DestinationsNavigator) {
    val context = LocalContext.current
    val firebaseAuth = FirebaseAuth.getInstance()

    Box(
        modifier = Modifier
            .width(360.dp)
            .height(540.dp)
            .background(color = Color.White)
            .clip(
                RoundedCornerShape(bottomStart = 15.dp, bottomEnd = 15.dp)
            )
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box {
                    Text(
                        text = "Grocery shopping",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier.align(Alignment.TopCenter)
                    )
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                    .clickable {
                        navigator.navigate(AddItemScreenDestination)
                    },
                verticalAlignment = Alignment.CenterVertically
            ) {
                ImageCircle(img = R.drawable.ic_add)
                Spacer(modifier = Modifier.width(15.dp))
                Text(
                    text = "Add Product to Shopping",
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp,
                    color = Color.Black
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                    .clickable {
                        Toast
                            .makeText(context, "clicked success", Toast.LENGTH_SHORT)
                            .show()
                    },
                verticalAlignment = Alignment.CenterVertically
            ) {
                ImageCircle(img = R.drawable.ic_order)
                Spacer(modifier = Modifier.width(15.dp))
                Text(
                    text = "Order History",
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp,
                    color = Color.Black
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                    .clickable {
                        Toast
                            .makeText(context, "clicked success", Toast.LENGTH_SHORT)
                            .show()
                    },
                verticalAlignment = Alignment.CenterVertically
            ) {
                ImageCircle(img = R.drawable.ic_track)
                Spacer(modifier = Modifier.width(15.dp))
                Text(
                    text = "Track Orders",
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp,
                    color = Color.Black
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                    .clickable {
                        Toast
                            .makeText(context, "clicked success", Toast.LENGTH_SHORT)
                            .show()
                    },
                verticalAlignment = Alignment.CenterVertically
            ) {
                ImageCircle(img = R.drawable.ic_curruncy)
                Spacer(modifier = Modifier.width(15.dp))
                Text(
                    text = "Currency",
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp,
                    color = Color.Black
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                    .clickable {
                        Toast
                            .makeText(context, "clicked success", Toast.LENGTH_SHORT)
                            .show()
                    },
                verticalAlignment = Alignment.CenterVertically
            ) {
                ImageCircle(img = R.drawable.ic_store)
                Spacer(modifier = Modifier.width(15.dp))
                Text(
                    text = "Store Locator",
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp,
                    color = Color.Black
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                    .clickable {
                        Toast
                            .makeText(context, "clicked success", Toast.LENGTH_SHORT)
                            .show()
                    },
                verticalAlignment = Alignment.CenterVertically
            ) {
                ImageCircle(img = R.drawable.ic_terms)
                Spacer(modifier = Modifier.width(15.dp))
                Text(
                    text = "Terms & Conditions",
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp,
                    color = Color.Black
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                    .clickable {
                        Toast
                            .makeText(context, "clicked success", Toast.LENGTH_SHORT)
                            .show()
                    },
                verticalAlignment = Alignment.CenterVertically
            ) {
                ImageCircle(img = R.drawable.ic_help)
                Spacer(modifier = Modifier.width(15.dp))
                Text(
                    text = "Help",
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp,
                    color = Color.Black
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                    .clickable {
                        Toast
                            .makeText(context, "clicked success", Toast.LENGTH_SHORT)
                            .show()
                    },
                verticalAlignment = Alignment.CenterVertically
            ) {
                ImageCircle(img = R.drawable.ic_question)
                Spacer(modifier = Modifier.width(15.dp))
                Text(
                    text = "Got a Question?",
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp,
                    color = Color.Black
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                    .clickable {
                        try {
                            firebaseAuth.signOut()
                            Toast
                                .makeText(context, "signing out", Toast.LENGTH_SHORT)
                                .show()
                            navigator.navigate(SplashScreenDestination, onlyIfResumed = true)
                        } catch (e: Exception) {
                            Toast
                                .makeText(context, e.message.toString(), Toast.LENGTH_SHORT)
                                .show()
                        }
                    },
                verticalAlignment = Alignment.CenterVertically
            ) {
                ImageCircle(img = R.drawable.ic_logout)
                Spacer(modifier = Modifier.width(15.dp))
                Text(
                    text = "Logout",
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp,
                    color = Color.Black
                )
            }

        }
    }
}

@Composable
fun ImageCircle(img: Int) {
    Box(
        modifier = Modifier
            .clip(CircleShape)
            .background(color = CircularColor)
            .width(40.dp)
            .height(40.dp)
    ) {
        Icon(
            painter = painterResource(id = img),
            contentDescription = "Image",
            modifier = Modifier.align(Alignment.Center),
            tint = SplashColor
        )
    }
}
