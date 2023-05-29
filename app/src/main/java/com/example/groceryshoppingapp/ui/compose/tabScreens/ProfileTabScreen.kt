package com.example.groceryshoppingapp.ui.compose.tabScreens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.groceryshoppingapp.ui.compose.destinations.EditProfileDestination
import com.example.groceryshoppingapp.ui.theme.SplashColor
import com.example.groceryshoppingapp.ui.theme.Text2
import com.google.firebase.auth.FirebaseAuth
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun ProfileScreen(navigator: DestinationsNavigator) {
    val firebaseAuth = FirebaseAuth.getInstance()
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {
        Text(
            text = "Profile Screen",
            fontSize = 18.sp,
            color = Text2,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(
                Alignment.TopStart
            )
        )

        Icon(
            Icons.Default.Edit,
            contentDescription = "Edit Image",
            modifier = Modifier
                .align(Alignment.TopEnd)
                .clickable {
                    navigator.navigate(EditProfileDestination)
                },
            tint = SplashColor
        )
    }
}